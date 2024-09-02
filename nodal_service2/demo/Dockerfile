# First stage: Build the application using Maven
FROM maven:3.8.5-openjdk-8 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and project files to the container
COPY pom.xml .

# Copy the rest of the application source code to the container
COPY src ./src

# Build the application
RUN mvn clean install

# Second stage: Use a minimal JDK image to run the application
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the build artifact from the previous stage
COPY --from=build /app/target/service2-0.0.1-SNAPSHOT.jar service2.jar

# Set the environment variable to run the service on port 8082
ENV SERVER_PORT=8082
# Expose the port on which the service will run
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "service2.jar"]
