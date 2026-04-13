🌿** AGMS: Automated Greenhouse Management System**
A cloud-native, microservices-driven ecosystem engineered for yield optimization and autonomous climate regulation.

📑 **Table of Contents**
Project Summary

Architecture & Tech Stack

System Prerequisites

Microservices Infrastructure

API Operations & Testing

 **01.** **Overview**
The Automated Greenhouse Management System (AGMS) is an intelligent platform designed to synchronize environmental variables with plant biology. By integrating Real-Time IoT Telemetry with a Custom Logic Engine, the system eliminates manual oversight. It monitors critical data points such as ambient temperature and humidity, triggering hardware responses (e.g., ventilation systems) to sustain a perfect growth environment.

🛠 **02.** **Architecture & Tech Stack**
This project follows a decoupled Microservices Architecture to ensure high availability, fault tolerance, and independent scaling.

Backend Core: Spring Boot (Java 17)

Discovery: Spring Cloud Netflix Eureka

Gateway: Spring Cloud Gateway (Single Entry Point)

Configuration: Spring Cloud Config Server

Inter-Service: OpenFeign (Declarative REST Client)

Security: JWT Authentication (Edge-level Security)

Persistence: Spring Data JPA (Relational Database)

💻 **03. System Requirements**
RAM: 8GB Minimum (16GB Recommended for full cluster)

Environment: JDK 17 or higher

Optimization: For machines with limited memory, it is recommended to set -Xmx heap limits on individual service containers.

💻 **04. Microservices Breakdown**
Infrastructure Tier
eureka-server (Port: 8761): The central registry for service discovery.

config-server (Port: 8888): Externalized configuration management.

api-gateway (Port: 8080): Unified routing and JWT security enforcement.

Domain Tier
automation-service (Port: 8083): The "Brain" of the system. Evaluates thresholds and issues hardware commands.

zone-service (Port: 8081): Manages physical sectors and IoT device registration.

sensor-service (Port: 8082): Telemetry engine; polls external IoT data every 10 seconds.

crop-service (Port: 8084): Tracks plant inventory, health, and growth cycles.

💻 **05. API Operations & End-to-End Flow**
Use the provided AGMS_Postman_Collection.json to validate the system.

Identity: Execute Auth: Login Admin to retrieve your JWT Bearer Token.

Authorize: Apply this token to the Authorization Header of all subsequent calls.

Configure: Use Zone: Create Zone to define environment limits and sync IoT devices.

Initialize: Create a crop lifecycle via Crop: Create Crop Batch.

Stress Test: Use Simulate Sensor Data to inject "Extreme Heat" and bypass polling delays.

Audit: Fetch Automation: Get Logs to verify the logic engine triggered TURN_FAN_ON.

<img width="1600" height="748" alt="image" src="https://github.com/user-attachments/assets/e27573b1-cb73-4408-ae28-8ef19acddff1" />

  
