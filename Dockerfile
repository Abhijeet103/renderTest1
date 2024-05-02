# Use Ubuntu as the base image
FROM ubuntu:latest

# Set environment variables for Java and Maven versions
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV MAVEN_HOME /usr/share/maven
ENV PATH "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"

# Install OpenJDK 17, Maven, and MongoDB
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven mongodb && \
    rm -rf /var/lib/apt/lists/*

# Ensure MongoDB is set up and running
RUN mkdir -p /data/db
RUN mongod --fork --logpath /var/log/mongod.log

# Copy the Spring Boot application files into the container
COPY . /app
WORKDIR /app

# Build the application using Maven
RUN mvn clean install

# Expose the port on which the web server is listening
EXPOSE 8080

# Run the built JAR file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
