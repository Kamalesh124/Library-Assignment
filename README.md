# Library Management System

## Project Overview
This is a Spring Boot-based Library Management System that provides RESTful APIs for managing books.

## Deployment
🌐 Live Application: https://library-assignment-production.up.railway.app/

## Features
- Add new books
- Retrieve all books
- Get book by ID
- Get book by title
- Update book details
- Delete books

## API Endpoints

### Get All Books
- **URL:** `/books`
- **Method:** `GET`
- **Success Response:** 
  - Code: 200 OK
  - Content: List of all books

### Get Book by ID
- **URL:** `/book/id/{bookId}`
- **Method:** `GET`
- **Success Response:** 
  - Code: 200 OK
  - Content: Book details
- **Error Response:**
  - Code: 404 Not Found

### Get Book by Title
- **URL:** `/book/title/{title}`
- **Method:** `GET`
- **Success Response:** 
  - Code: 200 OK
  - Content: List of books matching title
- **Error Response:**
  - Code: 409 Conflict

### Add New Book
- **URL:** `/book/add`
- **Method:** `POST`
- **Request Body:** Book object
- **Success Response:** 
  - Code: 200 OK
  - Content: "Adding new book.."
- **Error Response:**
  - Code: 400 Bad Request

### Update Book
- **URL:** `/book/update/{bookId}`
- **Method:** `PUT`
- **Request Body:** Updated Book object
- **Success Response:** 
  - Code: 200 OK
  - Content: "Book updated.."
- **Error Response:**
  - Code: 400 Bad Request

### Delete Book
- **URL:** `/book/delete/{bookId}`
- **Method:** `DELETE`
- **Success Response:** 
  - Code: 200 OK
  - Content: "Book is deleted"
- **Error Response:**
  - Code: 400 Bad Request

## Setup Instructions

### Prerequisites
- Java 17
- Maven
- MySQL Database

### Local Development Setup
1. Clone the repository
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   ```

2. Configure Database
   - Create a MySQL database named `railway`
   - Update `application.properties` with your database credentials

3. Build the Project
   ```bash
   mvn clean install
   ```

4. Run the Application
   ```bash
   mvn spring-boot:run
   ```

### Environment Variables
- `MYSQL_HOST`: Database host
- `MYSQL_PORT`: Database port
- `MYSQL_DATABASE`: Database name
- `MYSQL_USERNAME`: Database username
- `MYSQL_PASSWORD`: Database password

## Deployment
Deployed on Railway with automatic CI/CD from the main branch.

## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Author
Kamalesh Chakraborty

## License
This project is open-source.
