# Currency_Exchanger
Spring Boot-based microservices

## Project Intro

Currency_Exchanger is a Spring Boot-based microservices app designed for online currency exchange services, offering a robust, scalable distributed system with high-performance concurrency and comprehensive CI/CD integration. Each microservice operates with its own dedicated database, ensuring data isolation and consistency. **Eureka** is employed for dynamic service discovery, while **RabbitMQ** ensures reliable and asynchronous messaging between services.

External requests are managed by **Spring Cloud Gateway**, providing intelligent routing and load balancing. **Zipkin** is integrated for distributed tracing, offering deep insights into the system's performance and latency. **Spring Cloud Config** centralizes the management of configuration properties across the microservices, enhancing consistency and flexibility.

To ensure resilience, **Resilience4J** introduces fault tolerance patterns, such as circuit breakers and rate limiters, safeguarding against cascading failures. **Spring Security** is implemented to provide robust authentication and authorization mechanisms, protecting sensitive exchange operations.

The application is containerized using **Docker** and deployed on **Kubernetes** for scalable orchestration and management. Advanced deployment strategies, such as blue-green deployments and canary releases, are utilized to minimize downtime and ensure smooth updates. Prometheus and Grafana are integrated for monitoring, allowing for real-time tracking of system health and performance metrics.

Currency_Exchanger efficiently streamlines the currency exchange process, offering a secure, scalable, and resilient solution for modern financial services.

Docker Hub Repository: [docker](https://hub.docker.com/repository/docker/cici000/online_converter/general)

## Tech Involved
Programming and Frameworks: Java, Spring Boot, Spring MVC, Microservice <br>
Tools and Test: SQL, JPA, Hibernate, Actuator, Docker, Kubernetes, RabbitMQ, Eureka, API Gateway, Resilience4J, Github, Zipkin, Postman, Micrometer, OpenTelemetry, AWS, EC2



## PrePared
