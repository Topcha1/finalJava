# Java Booking Api 

## Overview
This Spring Boot API allows for efficient hotel registration, room management, and booking functionalities

## Prerequisites
Before running this project, ensure the following steps are completed:

1. **MySQL Setup**:
    - Ensure MySQL is running.
    - Configure the port and database name in the `application.properties` file.

2. **Database Initialization**:
    - Execute the SQL table creation scripts located in the project root (`create-tables.sql`).

3. **Application Configuration**:
    - The project runs on port `8080` by default, but this can be changed in `application.properties`.

4. **Spring Boot Admin**:
    - If monitoring via Spring Boot Admin is desired, start the Spring Boot Admin server.
    - Configure the Spring Boot Admin URL in the application properties of the client project.

## Running the Project
To run the project, use the following command in the root directory:

```bash
./mvnw spring-boot:run
```
