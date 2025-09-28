package com.antonromanov.ejb;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

/**
 * Remote interface that exposes CRUD operations for {@link Message} objects.
 */
@Remote
public interface MessageServiceRemote {

    /**
     * Create and store a new message.
     *
     * @param text content of the message
     * @return created message instance
     */
    Message create(String text);

    /**
     * Retrieve the message with the provided identifier.
     *
     * @param id message identifier
     * @return an optional containing the message if it exists
     */
    Optional<Message> findById(String id);

    /**
     * @return a snapshot of all messages currently stored.
     */
    List<Message> findAll();

    /**
     * Update the text of the message.
     *
     * @param id message identifier
     * @param newText new text to set
     * @return updated message
     */
    Optional<Message> update(String id, String newText);

    /**
     * Remove a message with the provided identifier.
     *
     * @param id message identifier
     * @return {@code true} if a message was removed, {@code false} otherwise
     */
    boolean delete(String id);
}
