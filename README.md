# Online Currency_Converter
**Spring Boot-based Microservices**

## Project Intro

Currency_Converter is a Spring Boot-based microservices app, offering a robust, scalable distributed system with high-performance concurrency and comprehensive CI/CD integration. Each microservice operates with its own dedicated database, ensuring data isolation and consistency. **Eureka** is employed for dynamic service discovery, while **RabbitMQ** ensures reliable and asynchronous messaging between services.

External requests are managed by **Spring Cloud Gateway**, providing intelligent routing and load balancing. **Zipkin** is integrated for distributed tracing, offering deep insights into the system's performance and latency. **Spring Cloud Config** centralizes the management of configuration properties across the microservices, enhancing consistency and flexibility. 

To ensure resilience, **Resilience4J** introduces fault tolerance patterns, such as circuit breakers and rate limiters, safeguarding against cascading failures. **Spring Security** is implemented to provide robust authentication and authorization mechanisms, protecting sensitive exchange operations.

The application is containerized using **Docker** and deployed on **AWS** for scalable orchestration and management.

Docker Hub Repository: [docker](https://hub.docker.com/repository/docker/cici000/online_converter/general)

## Tech Involved
Programming and Frameworks: Java, Spring Boot, Spring MVC, Microservice <br>
Tools and Test: SQL, Hibernate, JPA, Actuator, Docker, RabbitMQ, Eureka, API Gateway, Resilience4J, Github, Zipkin, Postman, Micrometer, OpenTelemetry, AWS, EC2


## PrePared
Spring Boot ready: https://start.spring.io/<br>
Recommendations:<br>
Use latest version of Java<br>
Remember: Spring Boot 3+ works only with Java 17+<br>

Java Ready: <br>
Windows - https://www.youtube.com/watch?v=I0SBRWVS0ok<br>
Linux - https://www.youtube.com/watch?v=mHvFpyHK97A<br>
Mac - https://www.youtube.com/watch?v=U3kTdMPlgsY<br>

IDE ready:
Intellij IDEA or Eclipse

## Ports
| Application                      |    Port             |
|----------------------------------|---------------------|
| Spring Cloud Config Server       | 8888                |
| Currency Exchange Service        | 8000, 8001, 8002, ..|
| Currency Conversion Service      | 8100, 8101, 8102, ..|
| Eureka Naming Server             | 8761                |
| API Gateway Server               | 8765                |
| Zipkin Distributed Tracing Server| 9411                |
| To Be Continued                  | ...                 |

## TakeAways
### 1. Why using Microservice architecture?
#### Scalability
Independent Scaling: Each service can be scaled independently based on its specific needs, improving resource utilization.<br>
e.g.: We can scale up/down based on our needs.<br>
#### Flexibility in Technology Stack
Technology Diversity: Different microservices can be developed using different programming languages, databases, or frameworks, allowing teams to choose the best tool for each job.<br>
e.g.: We can have one microservice wrote in Python, one in Java, other one in C++.<br>
#### Resilience and Fault Isolation
Isolation: If one service fails, it doesn’t necessarily bring down the entire application, as microservices are isolated.<br>
e.g.: We can debug the one we want.<be>

<img width="467" alt="Screenshot 2024-08-01 at 3 57 14 PM" src="https://github.com/user-attachments/assets/85eaddf2-81fe-4720-83b0-4cc53d737011">

We just need to care about each service's logics


### 2. Why creating a Spring Cloud Config Server?
To create a place to put all the configurations for all the microservices' environments in a Git repository, as a centralized location, also can be exposed to all the microservices, for later better management and easy maintenance.
For better git control, we could create a git-localconfig-repo folder to store our configurations.<br>
e.g.: I created different environments for limits-service:<br>
<img width="300" alt="Screenshot 2024-08-01 at 5 13 27 PM" src="https://github.com/user-attachments/assets/aec288ea-b182-49a4-bb48-e606e41df6ae"><br>
Later we can write the configurations in the Spring Cloud Config Server's application.properties(here I'm using this, application.yaml might differ):<br>
`spring.cloud.config.server.git.uri=file:///{absolute file path for 'git-localconfig-repo folder'}`<br>
Then when you make changes to the configurations locally later, you can git this.


### 3. Why Zipkin? How to use it?
Distributed Tracing: 
To trace a request across multiple components, and from its initiation to its completion, making it easier to pinpoint failures and understand the reasons behind them. By implementing distributed tracing, we gain insights into why a request failed and potentially identify when it failed.

Prerequisite: Download Zipkin first<br>

Add(this line of code in each application.properties in the application you want to trace), then you can trace<br>
`management.tracing.sampling.probability=1.0` 

**! You have to run Zipkin while running your application<br>**
make sure docker is running zipKin!<br>
`docker run -p 9411:9411 openzipkin/zipkin`

### 4. Why Eureka(Naming Server here)? How to use it?
**Registration and Discovery**
All the services would registered with Eureka.
<img width="472" alt="Screenshot 2024-08-01 at 4 19 15 PM" src="https://github.com/user-attachments/assets/831b358f-509a-4dec-a82e-7a5907a7328a">

To dynamically check the available ports right now, and also better for us to look up.
<img width="1224" alt="Screenshot 2024-07-25 at 11 17 46 PM" src="https://github.com/user-attachments/assets/4b7b3182-e737-404a-97b6-db20862abeac">

### 5. How's the communication between data and service?
Created data.sql file to put the data we want, and then write the configurations in the application.properties by adding:<br>
<img width="394" alt="Screenshot 2024-08-01 at 4 41 54 PM" src="https://github.com/user-attachments/assets/1b1c2824-b37f-488d-8496-ad54af712c55"> <br>
It enables the logging of SQL statements generated by Hibernate to the console. <br>
And sets up an in-memory H2 database named testdb. The database exists only while the application is running and is destroyed when the application stops. This is ideal for testing or development environments, but all data is lost when the application shuts down. It defers the initialization of the DataSource until after the JPA EntityManagerFactory is created and initialized. This enables the H2 database console, allowing you to access a web-based interface to interact with the database. 

### 6. What is Spring Cloud Gateway?
features:
- match routes on any requested attribute
- define Predicates and Filters
- Integrates with Spring Cloud Discovery Client (Load Balancing)
- Path Rewriting


