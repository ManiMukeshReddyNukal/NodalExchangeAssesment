# Nodal Exchange Microservices

This repository contains two microservices, **nodal_service1** and **nodal_service2**, built as part of a take-home assessment for Nodal Exchange. These microservices are designed to communicate with each other using RabbitMQ and are containerized using Docker.

## Overview

- **nodal_service1**: Built with Java 8 and Spring.
- **nodal_service2**: Built with Kotlin v1.9.
- **RabbitMQ**: Used for inter-service communication.
- **Docker**: All services, including RabbitMQ, are deployed using Docker containers.

## Prerequisites

Before running the services, ensure you have the following installed:

- **Docker**: [Installation Guide](https://docs.docker.com/get-docker/)
- **Docker Compose**: [Installation Guide](https://docs.docker.com/compose/install/)

## Getting Started

Follow these steps to run the microservices:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/nodal_exchange_microservices.git
   cd nodal_exchange_microservices


2. **Build and Run Services using Docker Compose**:

   The entire setup can be started using the docker-compose.yml file provided in the repository.

   ```bash
   docker-compose up --build
   ```
   
   This command will build the Docker images for nodal_service1, nodal_service2, and set up RabbitMQ. All services will be running in the Docker network defined by Docker Compose.

3. **Check Service Logs**:

   To verify the communication between the services, you can check the logs of each service:
   ```bash
   docker-compose logs nodal_service1
   docker-compose logs nodal_service2
   ```

   You should see the "ping" and "pong" messages being logged by each service.
4. **Access RabbitMQ Admin Console**:
   - Open your browser and go to http://localhost:15672 to access the RabbitMQ admin console.
   - Use the default credentials (username: guest, password: guest) to log in.
   - You can monitor the message routing and queue information here.

5. **Demo Video **:

   For a demonstration of the services in action, including the messages being sent and received and the RabbitMQ admin console, watch the [[demo video](https://github.com/ManiMukeshReddyNukal/NodalExchangeAssesment/blob/180dbe08f15241f62eaa5a89f6efdb0a3e5a6e20/nodalAssesment_demo_recording.mp4)] in this directory.
6. ** AI Usage**:
   - Used to generate skelton project structure 
   - Used to debug issues which came while deploying in docker container to understand how port forwarding works 
   - Used to write documentation
   - Used AI to figure out the dependency resolutions with the version mentioned in the requirement 
   - Used AI to understand docker deployment with the help of health check function 

   
