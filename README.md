# BookMyShow Backend Project README

## Overview

This repository contains the backend design implementation of BookMyShow using the Spring Boot framework. The entire codebase is written in Java and utilizes various technologies and tools for seamless functionality. The key components of the project include MySQL as the database, JPA/Hibernate as the Object-Relational Mapping (ORM) tool, Lombok for logging, Starter Web dependencies for web-related functionality, and Swagger UI for enhancing API documentation.

## Project Structure

The project is organized into different layers to maintain a clean and scalable architecture. The layers include:

1. **Model Layers:**
    - Movie
    - User
    - Ticket
    - Theatre
    - Shows
    - Theatre Seats
    - Show Seats

   All these model layers are related through Many-to-One relationships, ensuring a structured and efficient data model.

2. **Controller Layer:**
   All APIs are implemented in their respective controller layers. These controllers handle incoming requests and manage the flow of data between the client and the service layer.

3. **Service Layer:**
   Business logic is encapsulated within the service layer. This separation ensures that the business rules are maintained independently of the API layer, promoting modularity and maintainability.

4. **Repository Layer:**
   The database connectivity is established through the repository layer, which utilizes JPA/Hibernate to interact with the MySQL database. Each model layer has its corresponding repository for data access.

5. **DTO (Data Transfer Object):**
   Request and Response DTOs are used to facilitate communication between the service layer and the repository layer. Converters are employed to transform DTOs into entities and vice versa, ensuring a clear and standardized data exchange process.

## Dependencies

The project relies on the following dependencies:

- Spring Boot Starter Web
- MySQL Database
- JPA/Hibernate
- Lombok
- Swagger UI
- POSTMAN for API testing

## API Documentation

Swagger UI has been integrated to enhance the documentation and visualization of the RESTful APIs. The documentation provides details about the available endpoints, request parameters, and response structures.

## Testing

APIs can be tested using POSTMAN, covering various HTTP methods such as POST, GET, PUT, and DELETE. This ensures thorough testing and validation of the implemented functionalities.

## How to Run

To run the project locally, ensure that you have the necessary dependencies installed and configured. Additionally, set up the MySQL database with appropriate configurations. Then, execute the Spring Boot application.

```bash
./mvnw spring-boot:run
```

The application will start, and you can access the APIs via the provided Swagger UI documentation.

## Conclusion

This backend project aims to provide a robust foundation for BookMyShow, incorporating industry best practices and technologies. Contributions and improvements are welcome to enhance the functionality and maintainability of the codebase.
