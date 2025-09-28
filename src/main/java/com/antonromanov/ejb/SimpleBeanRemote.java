package com.antonromanov.ejb;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface SimpleBeanRemote {

    /**
     * Returns the default welcome message supplied by the bean.
     */
    String getMessage();

    /**
     * Creates a new message managed by the bean.
     */
    Message create(String text);

    /**
     * Looks up a message by its identifier.
     */
    Optional<Message> findById(String id);

    /**
     * Returns an immutable view of all messages stored in memory.
     */
    List<Message> findAll();

    /**
     * Updates an existing message if it is present.
     */
    Optional<Message> update(String id, String newText);

    /**
     * Removes the message with the provided identifier.
     */
    boolean delete(String id);
}
