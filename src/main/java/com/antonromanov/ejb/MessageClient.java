package com.antonromanov.ejb;

import java.util.List;

/**
 * Simple entry point that demonstrates CRUD operations on the {@link MessageServiceBean}.
 * <p>
 * In a real EJB container you would obtain the bean via JNDI. For this example we
 * instantiate it directly so that the sample can be executed with {@code mvn exec:java}.
 */
public final class MessageClient {

    private MessageClient() {
    }

    public static void main(String[] args) {
        MessageServiceBean service = new MessageServiceBean();
        service.bootstrap();

        System.out.println("=== Initial data ===");
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
