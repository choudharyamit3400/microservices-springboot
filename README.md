<div id="header" align="center">
  <img src="https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExbm9yZ2ZxdTl1MGxmeWNodXM4bnYwOHNrM2E0d2NmNXV2MzdsdHU4OCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9dHM/O2PhyxtkFwCtUO6nen/giphy.gif" width="100"/>
</div>

<div id="badges" style="align-content: center">
 <a href="https://www.linkedin.com/in/amitkumarusa/"> <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/></a>
  
<a href="https://www.youtube.com/@DontKnowHowToCode">
    <img src="https://img.shields.io/badge/YouTube-red?style=for-the-badge&logo=youtube&logoColor=white" alt="Youtube Badge"/>
  </a>
  <a href="https://x.com/choudharyamit34"><img src="https://img.shields.io/badge/Twitter-blue?style=for-the-badge&logo=twitter&logoColor=white" 
alt="Twitter Badge"/></a>
</div>
<img src="https://komarev.com/ghpvc/?username=choudharyamit3400&style=flat-square&color=blue" alt=""/>

<h1>
  hey there
  <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"/>
</h1>

<div align="center">
  <img src="https://media.giphy.com/media/dWesBcTLavkZuG35MI/giphy.gif" width="600" height="300"/>
</div>

---

### :technologist: About Me :

I am a Full Stack Developer <img src="https://media.giphy.com/media/WUlplcMpOCEmTGBtBW/giphy.gif" width="30"> from Sterling , Virginia.

- :telescope: I’m working as a Software Engineer and contributing to frontend and backend for building web applications.

- :seedling: Exploring Technical Content Writing.

- :zap: In my free time, I solve problems on GeeksforGeeks and read tech articles.

- :mailbox:How to reach me: [![Linkedin Badge](https://img.shields.io/badge/Amit%20Kumar-blue?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/amitkumarusa/)

This is a  work in progress  microservice architecture that could be followed to learn SpringBoot Cloud based Microservices at one place .
There is ongoing work to add  a lot of other capabilities and modules needed to create a real world application like system.


Please discard indentation and formatting  of this readme file as its not as per the standard what we generally have . 
This readme is intended  for my personal use as  quick refer doc for any module .
Once all the modules are covered then it would be updated accordingly 

Below-mentioned modules & patterns  are used to create these microservices .

### Spring Cloud
1. Spring Cloud
2. Spring Cloud Api-gateway
3. Spring Cloud Config
4. Service Cloud Service Registry with Netflix Eureka 
5. Spring Cloud Bus with Rabbit Mq
6. Distributed Tracing with Sleuth
7. Distributed log monitoring & analysis with Zipkin
8. API documentation with openAPIDoc with  Swagger UI-- In progress
9. Spring Boot Starter
10. Spring Test Suite 
11. Fault Tolerance and Fallback strategy --> Circuit Breaker & Retry with Resilience4j (Hystrix is depreciated )
12. Load Balancing by Spring Cloud Default Gateway (Ribbon is deprecated with Spring Boot 3)
13. Global Exception Handlers -- In progress

### Others
1. Lombok --> to provide getter , setters  & constructors
2. ModelMapper --> to map entity beans to DTO--> In progress
3. DTOs --> to abstract internal properties of Entities
4. MySql with CRUD repository
5. Docker Desktop
6. RabbitMq instance (You can run it from Docker Desktop)

### CI CD 
1. AWS ECS & Fargate - In progress
2. Docker  - In progress
3. AWS EKS - In pipeline
4. Auto Scaling -in pipeline
5. GitHub Actions - in progress

### User Authentication and Authorization
1. STS
2. user password encoder and decoder
3. JWT token grant  & validation
4. OAUTH with OIDC & PKCE (Proof Key for Code Exchange)
5. Social Login
6. Federated Login (Ping & OKta )
7. AWS Cognito based User Authentication
8. AWS IAM role based user Authorization
   
### Security: --> in pipeline 
1. Securing Rest Endpoints
2. Securing actuator Endpoints
3. Applying Governing policies at api gateway

### React Web Application : would be created in another repository  --> in pipeline
 1. User Registration
 2. Employee Registration
 3. Admin Profiles
 4. Web App security 
 5. Token Auto refresh
    



### Async Micro Service  Communication -- In pipeline
1. Event driven Micro Service communication (SNS--> Lambda , SQS-> Lambda, SNS->SQS->Lambda) -- in pipeline
2. SQS polling for batch updates-in pipeline
3. Async communication withe RabbitMq
4. Async communication with Apache Kafka


#### Migration to DGS Federation (GraphQL)--> In pipeline
1. Rest Endpoint would be migrated to GraphQl
2. Graph and SubGraph would be created
3. Single Endpoint would be exposed


This Readme file is a work in progress and will get updated after every  in progress/pending  item is finished and checked in to this repository


### Steps to set up and run these microservices. 
1. Download zipkin.jar from [here](https://zipkin.io/pages/quickstart) , start it by using command "java -jar filename" , it would start at port 
   9411 and can be access as http://127.0.0.1:9411/
2. Create 3 databases department_db , employee_db & organization_db in mysql database (you can use any other database just dont forget to use the 
   correct dependency and db configuration in application.properties )
3. Install docker desktop and run a local image of rabbitMq  by using command  "docker run --rm -it -p 5672:5672 {rabbitmqImagename that  you have 
   installed in docker desktop}"
4. Always Start Service Registry first -- it will start at  port 8761
5. Then start config server --> it would need an additional GitHub repo by name config-server and this repo should have {servicename}.prperties 
   file , it would start on port 8888
6. Then start api gateway - it would  start at port 9191 , if you add any new resource in your services then it should be configured in 
   api gateway's application.properties
7. Then start department service , it would start at port 8080
8. Then start organization service , it would start at port 8083
9. Then start employee service , it would start at port 8081

Once all Services started then you can hit individual endpoints of your services or can use apigateway 

To test you should  first create an Organisation  & Department 

Department: http://localhost:8080/api/departments
type:post 
```json
{
"departmentName": "IT",
"departmentDescription": "InformationTechnology",
"departmentCode": "IT001"
}
```

Organization: http://localhost:8083/api/organizations
type : post

request: 
```json 
{
    "organizationName": "Google",
    "organizationDescription": "Google ",
    "organizationCode": "GOOGLE001"
}
```

Then create Employee: http://localhost:8081/api/employees
type : post 

```json
{
    "firstName": "amit",
    "lastName": "Kumar",
    "email": "amitkumar@gmail.com",
    "departmentCode": "IT001",
    "organizationCode": "GOOGLE001"
}

```
to retrieve employee : do a  get for  http://localhost:8081/api/employees/{empId}

* If your setup is correct then you can use api gateway endpoint to execute above operations .

to use api gateway  endpoint  format should be
http://localhost:9191{path configured in application gateway's properties file}{param for the service}
eg: employee service is configured as 
```env
spring.cloud.gateway.routes[0].id=EMPLOYEE-SERVICE
spring.cloud.gateway.routes[0].uri=lb://EMPLOYEE-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/employees/**
```
notice predicate of the route its /api/employees/
so our  APi Gateway endpoint to call employee service to get employee details would be 

[http://localhost:9191/api/employees/{empId}]
 
type get 
eg: [http://localhost:9191/api/employees/8]

if you run into  any issue then please reach to me on [Linkedin](https://www.linkedin.com/in/amitkumarusa/) or you can email me at amit.kumar.
usa35@gmail.com


