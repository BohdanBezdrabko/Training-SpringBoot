### 
# Library System

This project is a training exercise to learn Spring Boot by building a RESTful API for managing a library’s collection of books. The application connects to MongoDB for data storage and includes basic CRUD operations for book records.

## Project Features

- **Add a New Book**
- **View All Books**
- **Get Book Details by ID**
- **Update Book Information**
- **Delete a Book**
- **Filter Books by Status** (Available, Checked Out, Reserved)

## Tech Stack

- **Java 21**
- **Spring Boot** (for API development)
- **MongoDB** (for data storage)
- **Gradle** (for building the project)

## API Endpoints

| Method | Endpoint                     | Description              |
| ------ | -----------------------------| ------------------------ |
| POST   | `/api/books`                 | Add a new book           |
| GET    | `/api/books`                 | Get all books            |
| GET    | `/api/books/{id}`            | Get a book by ID         |
| PUT    | `/api/books/{id}`            | Update book details      |
| DELETE | `/api/books/{id}`            | Delete a book by ID      |
| GET    | `/api/books/status/{status}` | Find books by status     |

## Running the Project

### Prerequisites
- **Java 21**
- **MongoDB** (local instance or MongoDB Atlas account)
- **Docker** (to containerize and run the app)

### Steps

1. **Clone the Repository**:
   Navigate to your project folder after cloning.

2. **Set Up MongoDB**:
   Ensure MongoDB is running on `localhost:27017`. If using a remote MongoDB instance, update the connection details in `application.properties`.

3. **Build and Run with Docker**:
   ```bash
   ./gradlew build
   docker-compose up
   ```

   Once running, the API will be available at `http://localhost:8080/api/books`.

---
