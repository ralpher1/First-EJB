package com.antonromanov.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Stateless
public class SimpleBean implements SimpleBeanRemote {

    private final ConcurrentMap<String, Message> messages = new ConcurrentHashMap<>();

    public SimpleBean() {
        seedWelcomeMessage();
    }

    @PostConstruct
    void bootstrap() {
        seedWelcomeMessage();
    }

    private void seedWelcomeMessage() {
        if (messages.isEmpty()) {
            Message welcome = new Message("Hello, World from EJB!");
            messages.put(welcome.getId(), welcome);
        }
    }

    @Override
    public String getMessage() {
        return findAll().stream()
                .findFirst()
                .map(Message::getText)
                .orElse("Hello, World from EJB!");
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
