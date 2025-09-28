package com.antonromanov.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Stateless EJB that provides an in-memory CRUD implementation for messages.
 */
@Stateless
public class MessageServiceBean implements MessageServiceRemote {

    private final ConcurrentMap<String, Message> messages = new ConcurrentHashMap<>();

    @PostConstruct
    void bootstrap() {
        Message welcome = new Message("Hello, World from EJB!");
        messages.put(welcome.getId(), welcome);
    }

    @Override
    public Message create(String text) {
        Message message = new Message(text);
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Optional<Message> findById(String id) {
        return Optional.ofNullable(messages.get(id));
    }

    @Override
    public List<Message> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(messages.values()));
    }

    @Override
    public Optional<Message> update(String id, String newText) {
        return Optional.ofNullable(messages.computeIfPresent(id, (key, existing) -> {
            existing.setText(newText);
            return existing;
        }));
    }

    @Override
    public boolean delete(String id) {
        return messages.remove(id) != null;
    }
}
