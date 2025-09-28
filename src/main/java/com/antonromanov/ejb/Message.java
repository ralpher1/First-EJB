package com.antonromanov.ejb;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Simple data transfer object that represents a message.
 */
public class Message implements Serializable {

    private final String id;
    private String text;
    private Instant updatedAt;

    public Message(String text) {
        this(UUID.randomUUID().toString(), text, Instant.now());
    }

    public Message(String id, String text, Instant updatedAt) {
        this.id = id;
        this.text = text;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.updatedAt = Instant.now();
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
