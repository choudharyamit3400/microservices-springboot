This is a  work in progress  microservice architecture that could be followed to learn SpingBoot Cloud based Microservices at one place .
There is ongoing work to add  a lot of other capabilities and modules needed to create a real world application like system.
Below mentioned modules & patterns  are used to create these micro services .

Spring Cloud 
1. Sping Cloud
2. Sping Cloud Apigateway
3. Sping Cloud Config
4. Service Cloud Service Registry with Netflix Eureka 
5. Spring Cloud Bus with Rabbit Mq
6. Distributed Tracing with Sleuth
7. Distirbuted log monitoring & analysis with Zipkin
8. API documentation with openAPIDoc with  Swagger UI
9. Spring Boot Starter
10. Spring Test Suite 
11. MySql with CRUD repository 
12. Fault Tolerance and Fallback strategy --> Circuit Breaker & Retry with Ressilence4j (Hystrix is depreciated )
13. Load Balancing by Spring Cloud Default Gateway 

CI CD 
1. AWS ECS & Fargate - In progress
2. Docker  - In progress
3. AWS EKS - In pipeline
4. Auto Scalling -in pipeline
5. GitHub Actions - in prgress

Security: --> in pipeline 
1.Securing Rest Endpoints
2.Securing actuator Endpoints
3.Applying Governing policies at api gateway
4.STS 
  a. OIDC  flow 
  b. OUATH 
5.JWT token grant  & validation 


Async Micro Service  Communication -- In pipeline
1. Event driven Micro Service communication (SNS--> Lambda , SQS-> Lambda, SNS->SQS->Lambda) -- in pipeline
2. SQS polling for batch updates- in pipeline






![Spring Cloud Architecture](https://github.com/choudharyamit3400/microservices-springboot/blob/main/architecture.png)

CI CD Architecure with GitHub workflows 

<img width="785" alt="image" src="https://github.com/user-attachments/assets/52a51956-a312-48ee-b6f8-ee92529a177a">

General Docker flow for your understanding 

<img width="671" alt="image" src="https://github.com/user-attachments/assets/9a60b5aa-3fa3-4a8f-a982-f502693ce7d1">

Steps to Docerize an SpringBoot Application 

<img width="706" alt="image" src="https://github.com/user-attachments/assets/820e8e3b-ba44-4c98-8331-79d4bfba2b78">


This Readme file is a work in progress and will get updated after every  pending item is finished and checked in to this repository 


