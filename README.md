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
- Define predicates and Filters
- Integrates with Spring Cloud Discovery Client (Load Balancing)
  Integration with Service Discovery: Spring Cloud Gateway integrates with service discovery systems like 
  Eureka, allowing it to automatically route requests to available instances of a service, with client-side 
  load balancing via Spring Cloud LoadBalancer.
- Security
  Authentication and Authorization: Spring Cloud Gateway can be integrated with Spring Security to handle     
  authentication and authorization at the gateway level. This centralizes security concerns and simplifies 
  the implementation of security across microservices.
- Resilience and Fault Tolerance
  Circuit Breakers: You can integrate Spring Cloud Gateway with resilience libraries like Resilience4J to apply circuit breakers, timeouts, retries, and bulkhead patterns to routes, improving the resilience of your system.
- Path Rewriting

### 7. What is Resilience4J?

### 8. Build the Docker
run the Maven command to build docker
`./mvnw spring-boot:build-image -DskipTests` <br>
it is a convenient way to build a Docker image for your Spring Boot application using the built-in support provided by Spring Boot. This command leverages Cloud Native Buildpacks to create a Docker image without needing a `Dockerfile`.

if you use this command to build docker image, then when you want to use it in other devices/networks, you have to tag this docker image into your docker hub; otherwise, this local docker image can’t be accessed.
### !format matters, use space instead of tabs

### 9. Deploy
First, create a FREE AWS accout
-1. Create a VPC
-2. Create EC2
- Before creating EC2, I will upload SSH key to AWS. This will let me to connect to my EC2 instance later via SSH. <br>
   1.  **Create Security Group ** (to block ports I don’t need) <br>
        To access my instance, I need the port 22 for an SSH connection and the port 8080 as the default port of my Spring Boot application.  <br>
        On the other way, I have no restrictions for the outgoing connections. I let my instance to connect to any external port, all the internet. <br>
    The insurance type will impact on the cost of my instance. I want to stay on the free tier, so I choose the t2.micro. <br>

2. **install Java** (Java —version to check if it’s downloaded) <br>
download file on local machine(mac) to EC2 <br>
3. **get your own ssh key**(remember to go to the file to see the key` <br>cat ~/.ssh/id_rsa.pub`<br>
4. **Launch an EC2 Instance**: If you haven’t already, launch an EC2 instance with an appropriate Amazon Machine Image (AMI) such as Amazon Linux 2 or Ubuntu.<br>
5. **Connect to Your EC2 Instance**: Use SSH to connect to your instance.
  `ssh -i your-key.pem ec2-user@your-ec2-instance-ip`<br>
6. **install Docker**
  `sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -aG docker ec2-user`<br>
7. **Install Docker Compose**:
    ```bash
    sudo curl -L "<https://github.com/docker/compose/releases/download/$>(curl -s <https://api.github.com/repos/docker/compose/releases/latest> | grep tag_name | cut -d '"' -f 4)/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose
    ```
    Verify Docker Compose installation:
    ```bash
    docker-compose --version
    ```
8. **Use SCP to Transfer Files**:<br> If you have a local directory with your applications and docker-compose.yaml, use scp to transfer it to your EC2 instance.<br>
***error happens:
Warning: Identity file /home/ec2-user/Users/caipeng/.ssh/id_rsa not accessible: No such file or directory.<br>
Solutions: <br>
Need to copy local project to EC2<br>
`scp -i your-key.pem -r /path/to/your/folder ec2-user@your-ec2-instance-ip:/home/ec2-user/r`<br>
9. **Deploy Using Docker Compose**
 **Navigate to the Directory**:
    
    ```bash
    cd /home/ec2-user/your-folder
    
    ```
    
10. **Start Your Applications**:
    ```
    bash
    docker-compose up -d
    ```
    This will start all the services defined in your `docker-compose.yaml` in detached mode.
11. **Verify Deployment**
 **Check Running Containers**:<br>
 `docker ps`

**Your application should run succefully on EC2!**

### 10. CI/CD for later use
Here comes S3 bucket(Simple Storage Service): (where to upload all the new versions)<br>
when a new version of the application is ready, is tested and packaged, I want to be automatically deployed in a new EC2 instance.<br>

I will use User Data Script in EC2 instance<br>
I will add a script which will download the new version of the application and start it.<br>
e.g.: So at the end of my pipeline, when my package is created, I will upload it to S3. Then start EC2 instance<br>
The bucket name must be unique all around the world.<br>

So, create a download script: (which downloads the latest version from S3 and start the application)<br>
<img width="477" alt="Screenshot 2024-08-01 at 10 59 51 PM" src="https://github.com/user-attachments/assets/d7065a9d-df87-4841-b717-a58bdffb8aba">

use ASW command(AWS-cli)<br>
`#!/bin/bash
cd /home/ec2-user
aws s3 cp s3://my-bucket/demo-0.0.1-SNAPTHOT.jar.
java -jar demo-0.0.1-SNAPTHOT.jar`<br>
give this authority<br>
`chmod +x startup.sh`<br>

compile the project to obtain a new package:<br>
`mvn clean package`<br>

upload package to S3:<br>
`aws s3 cp target/demo-0.0.1-SNAPTHOT.jar  s3://my-bucket/demo-0.0.1-SNAPTHOT.jar `

### Variables
IMAGE_ID="ami-0abcdef1234567890"  # Replace with your AMI ID<br>
INSTANCE_TYPE="t2.micro"           # Replace with your instance type<br>
KEY_NAME="your-key-pair"           # Replace with your key pair name<br>
SECURITY_GROUP="sg-0123456789abcdef0"  # Replace with your security group ID<br>
SUBNET_ID="subnet-0abc1234"        # Replace with your subnet ID<br>
COUNT=1                           # Number of instances to launch<br>

### Launch the EC2 instance
  `aws ec2 run-instances --image-id {your AMI ID} --instance-type {your instance type} --key-name {key pair name} \
    --security-group-ids {your security group ID} --subnet-id {your subnet ID} --count {count you want to initialize} \
    --user-data {place the startup.sh is} --associate-public-ip-address {}`

  Finally, from CI/CD runner, I’ve packaged my application, uploaded it to S3, and started a new EC2 instance


