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

# Second stage: Run the application using a minimal JDK image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

## Copy the wait-for-it.sh script into the container
#COPY wait-for-it.sh /app/wait-for-it.sh
#
## Make the wait-for-it.sh script executable
#RUN chmod +x /app/wait-for-it.sh


# Copy the built jar file from the previous stage
COPY --from=build /app/target/service1-0.0.1-SNAPSHOT.jar service1.jar

# Expose the port on which the service will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "service1.jar"]
