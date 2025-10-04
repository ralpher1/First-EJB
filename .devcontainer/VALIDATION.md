# Container Setup Validation

This document describes how to validate the devcontainer setup.

## Prerequisites
- GitHub Codespaces OR
- VS Code with Dev Containers extension

## Steps to Validate

1. **Open in Codespace/Dev Container**
   - Open this repository in GitHub Codespaces or VS Code Dev Containers
   - The container will automatically build using the Dockerfile in `.devcontainer/`

2. **Wait for Post-Create Command**
   - The `postCreateCommand` will automatically run:
     - Verify Java version (should show Java 8)
     - Verify Maven version (should show Maven 3.9.x)
     - Build the project with `mvn clean package -DskipTests`

3. **Verify Environment**
   ```bash
   java -version
   # Expected: openjdk version "1.8.x" or "8.x"
   
   mvn -version
   # Expected: Apache Maven 3.9.x
   ```

4. **Run the Sample Application**
   ```bash
   mvn -q compile exec:java -Dexec.mainClass=com.antonromanov.ejb.MessageClient
   ```
   
   Expected output should show:
   - Initial data with "Hello, World from EJB!" message
   - Creation of a new message
   - Update of the message
   - List after update showing both messages
   - List after delete showing only the original message

## Expected Container Setup
- **Base Image**: `maven:3.9-eclipse-temurin-8`
- **Java Version**: OpenJDK 8 (Eclipse Temurin)
- **Maven Version**: 3.9.x
- **Git**: Installed
- **Working Directory**: `/workspace`

## Troubleshooting

### Maven not found
If Maven is not found, verify the container was built from the Dockerfile:
```bash
which mvn
# Should return: /usr/bin/mvn or /usr/share/maven/bin/mvn
```

### Java version mismatch
This project requires Java 8. Check:
```bash
java -version
# Should show version 1.8.x or 8.x
```

### Build failures
If the build fails, try:
```bash
mvn clean install -U
```

## Success Criteria
✅ Container builds successfully  
✅ Java 8 is available  
✅ Maven 3.9+ is available  
✅ Git is available  
✅ Project builds without errors  
✅ Sample application runs and shows CRUD operations  
