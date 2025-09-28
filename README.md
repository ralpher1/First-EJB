# First-EJB

A minimal Enterprise Java Bean (EJB) project that demonstrates a full CRUD flow around a `Message` object.
The `MessageServiceBean` keeps data in-memory so the application can be executed directly from the
command line without any application server.

## Running the sample

```bash
mvn -q compile exec:java -Dexec.mainClass=com.antonromanov.ejb.MessageClient
```

The client prints the following sequence:

1. The welcome "Hello, World" message that is bootstrapped inside the bean.
2. Creation of a new message.
3. Update of the freshly created message.
4. Deletion of the updated message.

Each step is displayed in the console so you can see the CRUD operations in action.

## Developing in GitHub Codespaces

This repository includes a `.devcontainer/devcontainer.json` configuration so the sample can be
opened directly in GitHub Codespaces or VS Code Dev Containers. The container installs Java 8 and
Maven 3.9 automatically and runs a Maven package build after creation so the project is ready to
execute the sample command above.
