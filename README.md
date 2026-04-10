**AGMS - Automated Greenhouse Management System**
A cloud-native, microservices-based system designed to enhance crop yield and efficiently manage greenhouse environments using real-time IoT data and automated decision-making.
**content:**
  Executive Summary
  Structural Design & Technical Framework
  Hardware & Software Prerequisites
  Core Service Ecosystem
  Deployment & API Validation
**Executive Summary**
The AGMS provides a sophisticated interface for supervising greenhouse climates. By integrating with third-party IoT networks, it monitors vital signs like heat and moisture levels in real-time. An integrated Logic Engine evaluates these metrics against predefined thresholds, automatically activating climate control hardware (like ventilation or irrigation) to keep the environment within ideal parameters.

**Structural Design & Technical Framework**
The system utilizes a Microservices Architecture, ensuring each component can scale independently and remains highly resilient.

🛠 Integrated Technologies
Core Framework: Spring Boot (Java 17+)

Service Registry: Spring Cloud Netflix Eureka

Centralized Entry: Spring Cloud Gateway

Dynamic Configuration: Spring Cloud Config

Service Interaction: OpenFeign (Declarative REST Client)

Identity Management: JWT-based Security

Persistence Layer: Spring Data JPA

**Hardware & Software Prerequisites**
To ensure a smooth deployment, your environment should meet the following specifications:

Memory (RAM): 8GB minimum; 16GB is ideal for full-stack performance.

Development Kit: JDK 17 or more recent.

Performance Tuning: On machines with constrained resources, it is recommended to adjust JVM heap sizes for each service during startup.

**Core Service Ecosystem**
Infrastructure Tier
Service Discovery (eureka-server): The phonebook for all services (Port: 8761).

Config Hub (config-server): Manages settings across the environment (Port: 8888).

Security Gateway (api-gateway): Filters all traffic and handles authentication (Port: 8080).

Operational Tier
Logic Engine (automation-service): The "brain" that issues commands based on sensor data (Port: 8083).

Spatial Manager (zone-service): Configures greenhouse sectors and links new IoT hardware (Port: 8081).

Telemetry Fetcher (sensor-service): Polls external IoT providers every 10 seconds for new data (Port: 8082).

Plant Lifecycle (crop-service): Tracks crop varieties, health status, and growth cycles (Port: 8084).
<img width="1600" height="748" alt="image" src="https://github.com/user-attachments/assets/e27573b1-cb73-4408-ae28-8ef19acddff1" />

  
