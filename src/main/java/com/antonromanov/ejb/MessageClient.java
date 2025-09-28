package com.antonromanov.ejb;

import java.util.List;

/**
 * Simple entry point that demonstrates CRUD operations on the {@link SimpleBean}.
 *
 * <p>The bean is instantiated directly so the sample can run without an
 * application server.</p>
 */
public final class MessageClient {

    private MessageClient() {
    }

    public static void main(String[] args) {
        SimpleBeanRemote service = new SimpleBean();

        System.out.println(service.getMessage());

        System.out.println("\n=== Initial data ===");
        printMessages(service.findAll());

        Message created = service.create("Created from the client");
        System.out.println("\nCreated message: " + created);

        service.update(created.getId(), "Hello World - updated!")
                .ifPresent(updated -> System.out.println("Updated message: " + updated));

        System.out.println("\n=== After update ===");
        printMessages(service.findAll());

        service.delete(created.getId());
        System.out.println("\n=== After delete ===");
        printMessages(service.findAll());
    }

    private static void printMessages(List<Message> messages) {
        if (messages.isEmpty()) {
            System.out.println("(no messages)");
            return;
        }
        messages.forEach(message ->
                System.out.println(message.getId() + " -> " + message.getText()));
    }
}
