Showroom Management System

This project is a Spring Boot application for managing car showrooms and cars, built using Spring Data JPA, Spring Boot, and PostgresSQL. The application includes entities for managing car showrooms and cars, with dynamic filtering, pagination, and sorting features, as well as database migrations managed with Liquibase.

Table of Contents

Project Overview
Features
Technologies
Getting Started
Database Setup
Running the Application
API Endpoints
Liquibase Migrations
Troubleshooting
Contributing
License
Project Overview
This application provides a backend API for managing showrooms and cars. You can perform CRUD operations on car and showroom entities, as well as filter, paginate, and sort lists of cars and showrooms.

Features
Showroom Management: Create, read, update, and delete showrooms.
Car Management: Manage cars associated with specific showrooms.
Dynamic Filtering: Filter cars and showrooms based on different criteria.
Pagination and Sorting: Efficiently manage large datasets with pagination and sorting.
Database Migration with Liquibase: Automated database version control.
Technologies
Java 17
Spring Boot 3.4
Spring Data JPA
Liquibase for database migrations
PostgresSQL as the database
Maven for dependency management
Getting Started
Prerequisites
Java 17 or later
Maven 3.8 or later
PostgresSQL database server
Clone the Repository
bash
Copy code
git clone https://github.com/your-username/showroom-management-system.git
cd showroom-management-system
Database Setup
Create a PostgresSQL database for the application.

Configure the database connection in application.yml:

yaml
Copy code
spring:
datasource:
url: jdbc:postgresql://localhost:5432/your_database
username: your_username
password: your_password
jpa:
hibernate:
ddl-auto: none
show-sql: true
Liquibase Setup: Liquibase will automatically manage database migrations. Refer to the db/changelog folder for the changelog files.

Running the Application
You can run the application using Maven:

bash
Copy code
mvn spring-boot:run
Or by building the JAR file and running it:

bash
Copy code
mvn clean install
java -jar target/showroom-management-system-0.0.1-SNAPSHOT.jar
API Endpoints
Showrooms
GET /showrooms - Get all showrooms (supports pagination, filtering, and sorting)
GET /showrooms/{id} - Get a specific showroom by ID
POST /showrooms - Create a new showroom
PATCH /showrooms/{id} - Update specific fields in a showroom
DELETE /showrooms/{id} - Soft delete a showroom
Cars
GET /cars - Get all cars with showroom details (supports pagination, filtering, and sorting)
GET /cars/{id} - Get a specific car by ID
POST /cars - Create a new car under a showroom
PATCH /cars/{id} - Update specific fields in a car
DELETE /cars/{id} - Soft delete a car
Liquibase Migrations
This project uses Liquibase for database migrations. Migrations are defined in the db/changelog folder.

Initial Setup: Liquibase will automatically apply migrations when the application starts.
Creating a New Migration: To create a new migration, add a new SQL or XML file in db/changelog and reference it in the master changelog file.
Example changelog-master.xml entry:

xml
Copy code
<changeSet id="1" author="yourname">
<sqlFile path="db/changelog/db-changelog.sql" relativeToChangelogFile="true"/>
</changeSet>
Troubleshooting
Database Connection Issues: Ensure the PostgresSQL database is running, and your connection details in application.yml are correct.
Liquibase Issues: If Liquibase fails to apply migrations, check the logs for errors and make sure your changelog files are correctly formatted.
Contributing
Contributions are welcome! Please fork the repository and open a pull request with your changes.
