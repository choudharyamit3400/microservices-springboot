This is a  work in progress  microservice architecture that could be followed to learn SpingBoot Cloud based Microservices at one place .
This  is  an ongoing work  and would be updated with a lot of other capabilities and modules  required  to create a real world application like system.
Below mentioned modules & patterns  are used to create these micro services .

Please discard indentation and formatting  of this readme file as its not as per the standard what we generally have . 
This readme is intended  for my personal use as  quick refer doc for any module .
Once all the modules are covered then it would be updated accordingly 

Spring  
1. Sping Cloud
2. Sping Cloud Apigateway
3. Sping Cloud Config
4. Service Cloud Service Registry with Netflix Eureka 
5. Spring Cloud Bus with Rabbit Mq
6. Distributed Tracing with Sleuth
7. Distirbuted log monitoring & analysis with Zipkin
8. API documentation with openAPIDoc with  Swagger UI-- In progress
9. Spring Boot Starter
10. Spring Test Suite 
12. Fault Tolerance and Fallback strategy --> Circuit Breaker & Retry with Ressilence4j (Hystrix is depreciated )
13. Load Balancing by Spring Cloud Default Gateway (Ribbon is depreceated with Spring Boot 3)
14. Global Exeption Hanlders -- In progress

Others
1. Lombok --> to provide getter , setters  & constrcutors
2. ModelMapper --> to map entity beans to DTO
3. DTOs --> to abstract internal properties of Entities
4. MySql with CRUD repository

CI CD 
1. AWS ECS & Fargate - In progress
2. Docker  - In progress
3. AWS EKS - In pipeline
4. Auto Scalling -in pipeline
5. GitHub Actions - in prgress

User Authentication and Authorization
1. STS
2. user password encoder and decoder
3. JWT token grant  & validation
4. OAUTH with OIDC & PKCE (Proff Key for Code Exchange)
5. Social Login
6. Federated Login (Ping & OKta )
7. AWS Cognito based User Authentication
8. AWS IAM role based user Authorization
   
Security: --> in pipeline 
1. Securing Rest Endpoints
2. Securing actuator Endpoints
3. Applying Governing policies at api gateway

React Web Application : would be created in another repository  --> in pipeline
 1. User Registration
 2. Employee Registration
 3. Admin Profiles
 4. Web App security 
 5. Token Auto refresh
    



Async Micro Service  Communication -- In pipeline
1. Event driven Micro Service communication (SNS--> Lambda , SQS-> Lambda, SNS->SQS->Lambda) -- in pipeline
2. SQS polling for batch updates- in pipeline
3. Async communication withe RabbitMq
4. Async communication with Apache Kafka


Migration to DGS Federation (GraphQL)--> In pipeline
1. Rest Endpoint would be migrated to GraphQl
2. Graph and SubGraph would be created
3. Single Endpoint would be exposed






![Spring Cloud Architecture](https://github.com/choudharyamit3400/microservices-springboot/blob/main/architecture.png)

Circuit Breaker Pattern 

![image](https://github.com/user-attachments/assets/20b9d72c-06fb-4430-aafa-1b7585298439)

confgi-server repo   should look something like 

![image](https://github.com/user-attachments/assets/6bd1dc4e-8d52-4050-b9de-0b87e841ccf5)


Config Refersh Acrhitecture with Kafka 


![image](https://github.com/user-attachments/assets/22d44ddd-e490-4acc-a418-852a09d8edec)

Config Refresh Architecture with RabbitMq
![image](https://github.com/user-attachments/assets/dd1adf2c-5334-4f52-a1f1-0ede607f6fca)

Config Auto Refresh  by GitHub Actions on Merge to Main with RabbitMq

![image](https://github.com/user-attachments/assets/97bd47a8-d61d-4eb2-85de-3aaad3817128)

Distributed Tracing by Spring Cloud Sleuth and ZipKin

![image](https://github.com/user-attachments/assets/9f3d5ff6-5df7-4824-8efb-733021da0088)

Zipkin DashBoard

![image](https://github.com/user-attachments/assets/54949ecb-d1d2-4c1b-af49-739330555440)

Micro Service Communication Methods 

![image](https://github.com/user-attachments/assets/a6cb034a-c228-4999-a79a-c5655be150c2)

Asyncronous Micro Service Communication

![image](https://github.com/user-attachments/assets/120d0651-e19c-4ed6-8962-1ecbe54bd18a)


CI CD Architecure with GitHub workflows 

<img width="785" alt="image" src="https://github.com/user-attachments/assets/52a51956-a312-48ee-b6f8-ee92529a177a">

General Docker flow for your understanding 

<img width="671" alt="image" src="https://github.com/user-attachments/assets/9a60b5aa-3fa3-4a8f-a982-f502693ce7d1">

Steps to Dockerize an SpringBoot Application 

<img width="706" alt="image" src="https://github.com/user-attachments/assets/820e8e3b-ba44-4c98-8331-79d4bfba2b78">


This Readme file is a work in progress and will get updated after every  pending item is finished and checked in to this repository


Steps to setup and run these micro services. 
1. download zipkin.jar from [here](https://zipkin.io/pages/quickstart) , start it by using command "java -jar filename" , it would start at port 9411 and can be access as http://127.0.0.1:9411/
2. create 3 databses department_db , employee_db & organization_db in mysql database (you can use any other database just dont forget to use the correct dependecy and db configuration in application.properties )
3. install docker desktop and run a local image of rabbitMq  by using commnad  "docker run --rm -it -p 5672:5672 {rabbitmqImagename that  you have installed in docker desktop}"
4. always Start Service Registry first -- it will start at  port 8761
5. then start config server --> it would need an additional github repo by name config-server and this repo should have {servicename}.prperties file , it would start on port 8888
6. then start apigateway - it would  start at port 9191 , if you add any new resource in your services then it should be configured in apigateway's application.properties
7. then start department service , it would start at port 8080
8. then start organization service , it would start at port 8083
9. then start employee service , it would start at port 8081


