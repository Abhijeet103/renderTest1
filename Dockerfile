FROM mongo:latest


RUN sudo systemctl start mongod
# Create the MongoDB data directory (might not be necessary as the mongo image takes care of this)
RUN mkdir -p /data/db

# Expose the default MongoDB port
EXPOSE 27017

# Use a second stage to copy the Spring Boot application
FROM openjdk:17-oracle as application

# Set working directory for Spring Boot app
WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Define command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
