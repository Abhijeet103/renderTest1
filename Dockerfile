# Use official OpenJDK 17 as base image
FROM openjdk:17-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/your-application.jar

# Define entry point to run your application
ENTRYPOINT ["java", "-jar", "your-application.jar"]
