<h1 align="center">SHORTENER SERVICE </h1>
<h3 align="center">

![Spring Boot](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/maven-%230074C1.svg?style=for-the-badge&logo=apache-maven&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DC382D.svg?style=for-the-badge&logo=redis&logoColor=white)
![MongoDB](https://img.shields.io/badge/mongodb-%234EA94B.svg?style=for-the-badge&logo=mongodb&logoColor=white)

</h3>
<br>

# Description 📢

The Shortener Service is a RESTful API that provides functionality for shortening URLs. It uses Spring Boot, Java, Maven, Redis, and MongoDB to build a robust and scalable application. Based on the ports and adapters pattern, the application exposes a set of RESTful endpoints for creating and redirecting URLs. The service also uses a Redis cache to store the shortened URLs and a MongoDB database to store the URLs. Some clean code practices are used, such as separation of concerns, dependency injection, and the use of interfaces, screaming architecture, and the use of the repository pattern.
<br>

# Deployment 🚀

| Environment         | URL                                  |
|-----------------|:-------------------------------------|
| Local           | https://localhost:8080               |
| Production      | https://shortener-service-jke8.onrender.com  |
 

<br>

# Project structure 📋

```
src/                                        Source code of the project
├─ main/                                    Main package of the application
│   ├─ java/com/shortener                   Java package of the application
│   │   ├─ application/                     Application layer
│   │   ├─ domain/                          Domain layer
│   │   ├─ infrastructure/                  Infrastructure layer
│   │   │   ├─ api                          Controllers, responses and exception handlers
│   │   │   ├─ id                           ID generator
│   │   │   ├─ peresistence                 Repository implementation for MongoDB and entities
│   │   │   └─ web                          Web configuration (Cors, Security, etc.)
│   │   └─ Main                             Main class of the application
│   └─ resources/                           Resources of the application
├─ test/                                    Test package of the application
│   ├─ java/com/shortener                   Java package of the application
│   │   ├─ application/                     Application Layer tests
│   │   ├─ domain/                          Domain Layer tests
│   │   ├─ domain/                          Domain Layer tests
│   └─ resources/                           Resources of the application
├─ Dockerfile                               Configuration file of Docker
└─ pom.xml                                  Configuration file of Maven
```
<br>

# Scripts 📌

| Task                                      | Description                                                                        |
|--------------------------------------------|----------------------------------------------------------------------------------------|
| `mvn install`                              | Install the dependencies of the project                                             |
| `mvn test`                                 | Run the tests of the project                                                        |
| `mvn package`                              | Create the build of the project                                                      |
| `mvn spring-boot:run`                      | Start the application in development mode                                          |

<br>

**NOTE:** To run this application without Docker compose you need to pass .env variables to the run command.