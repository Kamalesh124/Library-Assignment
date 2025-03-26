# Library Management System  

## Project Overview  
The **Library Management System** is a **Spring Boot** application that provides a RESTful API for managing books. Users can add, update, retrieve, and delete book records.  

## Deployment  
🌐 **Live Application:** https://library-assignment-production.up.railway.app/

## Features  
- Add new books  
- Retrieve all books  
- Get book by ID  
- Get book by title  
- Update book details  
- Delete books  
- Exit the application  

## API Endpoints  

### Get All Books  
- **URL:** `/books`  
- **Method:** `GET`  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** List of all books  

### Get Book by ID  
- **URL:** `/book/id/{bookId}`  
- **Method:** `GET`  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** Book details  
- **Error Response:**  
  - **Code:** `404 Not Found`  

### Get Book by Title  
- **URL:** `/book/title/{title}`  
- **Method:** `GET`  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** List of books matching the title  
- **Error Response:**  
  - **Code:** `409 Conflict`  

### Add New Book  
- **URL:** `/book/add`  
- **Method:** `POST`  
- **Request Body:** Book object  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** `"Adding new book..."`  
- **Error Response:**  
  - **Code:** `400 Bad Request`  

### Update Book  
- **URL:** `/book/update/{bookId}`  
- **Method:** `PUT`  
- **Request Body:** Updated Book object  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** `"Book updated..."`  
- **Error Response:**  
  - **Code:** `400 Bad Request`  

### Delete Book  
- **URL:** `/book/delete/{bookId}`  
- **Method:** `DELETE`  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** `"Book is deleted"`  
- **Error Response:**  
  - **Code:** `400 Bad Request`  

### Exit Application  
- **URL:** `/exit`  
- **Method:** `GET`  
- **Success Response:**  
  - **Code:** `200 OK`  
  - **Content:** `"Application is shutting down..."`  


## Setup Instructions  

### Prerequisites  
- **Java 17**  
- **Maven**  
- **MySQL Database**  

### Local Development Setup  

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/Kamalesh124/Library-Assignment.git
   cd Library-Assignment
   ```

2. **Configure Database**  
   - Create a MySQL database named `railway`  
   - Update `application.properties` with your database credentials  

3. **Build the Project**  
   ```bash
   mvn clean install
   ```

4. **Run the Application**  
   ```bash
   mvn spring-boot:run
   ```

## Deployment  
Deployed on **Railway** with automatic CI/CD from the main branch.  

## Technologies Used  
- **Spring Boot**  
- **Spring Data JPA**  
- **MySQL**  
- **Lombok**  
- **Maven**  

## Author  
**Kamalesh Chakraborty**  




