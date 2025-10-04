# Use official Maven image with OpenJDK 8 pre-installed
# This provides a clean, minimal, and reliable base with both Java and Maven
FROM maven:3.9-eclipse-temurin-8

# Install git (required for GitHub Codespaces)
RUN apt-get update && \
    apt-get install -y --no-install-recommends git && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /workspace

# Default command
CMD ["/bin/bash"]
