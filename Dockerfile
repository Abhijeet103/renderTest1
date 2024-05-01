conver this docker file to use mongo db in the above way  : # Use official OpenJDK 17 as base image
FROM openjdk:17-oracle

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Define entry point to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
