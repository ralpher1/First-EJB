# First-EJB

A minimal Enterprise Java Bean (EJB) project that demonstrates a full CRUD flow around a `Message`
object. The `SimpleBean` keeps data in-memory so the application can be executed directly from the
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

### Sample output

```text
Hello, World from EJB!

=== Initial data ===
<uuid> -> Hello, World from EJB!

Created message: Message{id='<uuid>', text='Created from the client', updatedAt=<timestamp>}
Updated message: Message{id='<uuid>', text='Hello World - updated!', updatedAt=<timestamp>}

=== After update ===
<uuid> -> Hello, World from EJB!
<uuid> -> Hello World - updated!

=== After delete ===
<uuid> -> Hello, World from EJB!
```

The UUID and timestamp values change on every run, but the lifecycle of the message remains the same.

## Developing in GitHub Codespaces

This repository includes a `.devcontainer/devcontainer.json` configuration so the sample can be
opened directly in GitHub Codespaces or VS Code Dev Containers. The container installs Java 8 and
Maven automatically using the official dev container features and then runs `.devcontainer/post-create.sh`
to ensure Maven is present (even if the feature install fails) before performing a non-interactive
`mvn -B -DskipTests package` build. This keeps Codespaces creation resilient and leaves the project
ready to execute the sample command above.
