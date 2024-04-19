# Library Management System 

Entities:
● Book: Includes attributes like ID, title, author, publication year, ISBN, etc.
● Patron: Contains details like ID, name, contact information, etc.
● Borrowing Record: Tracks the association between books and patrons,
including borrowing and return dates.

API Endpoints:
●  RESTful endpoints to handle the following operations:
● Book management endpoints:
● GET /api/books: Retrieve a list of all books.
● GET /api/books/{id}: Retrieve details of a specific book by ID.
● POST /api/books: Add a new book to the library.
● PUT /api/books/{id}: Update an existing book's information.
● DELETE /api/books/{id}: Remove a book from the library.
● Patron management endpoints:
● GET /api/patrons: Retrieve a list of all patrons.
● GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
● POST /api/patrons: Add a new patron to the system.
● PUT /api/patrons/{id}: Update an existing patron's information.
● DELETE /api/patrons/{id}: Remove a patron from the system.
● Borrowing endpoints:
● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to
borrow a book.

● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.

Data Storage:
● Use an appropriate database ( MySQL ) to persist book, patron, and borrowing record details.
●  relationships between entities (e.g., one-to-many between books and borrowing records).

Validation and Error Handling:
●  input validation for API requests (e.g., validating required fields, data formats, etc.).
● Handle exceptions gracefully and return appropriate HTTP status codes and error messages.

Security ():
●  basic authentication .

Aspects ():
● logging using Aspect-Oriented Programming (AOP) to log method calls, exceptions, and performance metrics of certain operations like book additions, updates, and patron transactions.

Caching ():
● Utilize Spring's caching mechanisms to cache frequently accessed data, such as book details or patron information, to improve system performance.

Transaction Management:
● Implement declarative transaction management using Spring's @Transactional annotation to ensure data integrity during critical operations.

Testing:
●  unit tests to validate the functionality of API endpoints.
● Use testing frameworks like JUnit, Mockito, or SpringBootTest for testing.

----------------------------------------------------------------------------

#### How RUN PROJECT

1- BE sure that you install JDK
2- RUN Jar file 
3-open localhost and follow API.json (this file has clear explain for how use and when)


------------------------------------------------------------------------------
#### Authentication 

● auth : non 
● if you need to open auth (open pom file and un hash security dependancy)
● your auth route will be on all route 
● auth type : basic auth 
● user : admin
● password : 123
● if u want to edit user or pass from applecation.prop


------------------------------------------------------------------------------------------------------

