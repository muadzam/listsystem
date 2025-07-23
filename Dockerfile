# Use official Java runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set application JAR filename (optional, adjust to your actual jar name)
ARG JAR_FILE=target/*.jar

# Copy the jar file to the container
COPY ${JAR_FILE} app.jar

# Expose port (change if your app runs on different port)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
