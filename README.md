<div align="center">
  <h1>🚀 Library Management System </h1>
</div>


## 📄 Description

This Library Management System is designed to efficiently manage library resources including books, patrons, and borrowing records.


## 📦 Installation

Clone the Repository:
 - git clone https://github.com/mohamed775/Library-Management-System.git
Database Configuration:
 - Set up a MySQL database and configure the connection settings in application.properties.
Build and Run:
 - Build the project using Maven: mvn clean install.
 - Run the application using the generated JAR file: java -jar target/library-management-system.jar.
Access the Application:
 - Once the application is running, access it through the specified URL.
 - Use the provided API endpoints for managing books, patrons, and borrowing records.


## 🚀 Functionality

Validation and Error Handling :
 - Provides input validation for API requests.
Handles exceptions gracefully and returns appropriate HTTP status codes and error messages.

Security :
 - Basic authentication ensures secure access to the system.
 - Username: admin, Password: 123 (Editable in application.properties).
   
Aspects :
 - Logging implemented using Aspect-Oriented Programming (AOP) to log method calls, exceptions, and performance metrics.
   
Caching :
 - Utilizes Spring's caching mechanisms to cache frequently accessed data for improved system performance.
   
Transaction Management :
 - Declarative transaction management using Spring's @Transactional annotation ensures data integrity during critical operations.
   
Testing : 
 - Includes unit tests to validate the functionality of API endpoints.
Utilizes testing frameworks like JUnit, Mockito, or SpringBootTest for comprehensive testing.


## ![API Endpoint Icon](https://img.icons8.com/plasticine/100/000000/api-settings.png)

Book Management : 
 - GET /api/books: Retrieve a list of all books.
 - GET /api/books/{id}: Retrieve details of a specific book by ID.
 - POST /api/books: Add a new book to the library.
 - PUT /api/books/{id}: Update an existing book's information.
 - DELETE /api/books/{id}: Remove a book from the library.

Patron Management : 
 - GET /api/patrons: Retrieve a list of all patrons.
 - GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
 - POST /api/patrons: Add a new patron to the system.
 - PUT /api/patrons/{id}: Update an existing patron's information.
 - DELETE /api/patrons/{id}: Remove a patron from the system.

Borrowing :
 - POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
 - PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.



## ✨ Features

- Book Management: Add, update, and delete books in the library inventory.
- Patron Management: Manage patron details such as name, contact information, etc.
- Borrowing Records: Track borrowing and return of books by patrons.


## ✨ Technologies Used

- Java: Core programming language.
- Spring Boot: Framework for building robust Java applications.
- MySQL: Database management system for data storage.
- Spring Data JPA: Simplifies data access using the JPA specification.
- Spring Security: Provides authentication and authorization.


## 🤝 Contributing

- Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or features you'd like to see added to the project.


## 📝 License
---------------------------------------------------------
- This project is licensed under the MIT License.
---------------------------------------------------------


## 📬 Contact

- Feel free to customize this template according to your project's specific requirements and implementation details. Let me know if you need further assistance or have any questions!

