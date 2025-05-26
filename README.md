# Learn01 - Spring Boot Application

A Spring Boot application implementing CRUD operations with MySQL database and modern features including caching, circuit breaker, and rate limiting.

## Key Features

- **CRUD Operations**: Complete implementation of Create, Read, Update, Delete for User entity
- **Caching**: Performance optimization using Spring Cache
- **Error Handling**: Comprehensive error handling with custom exceptions
- **Environment Variables**: Secure configuration using environment variables
- **Rate Limiting**: Request throttling to prevent abuse
- **Circuit Breaker**: Resilience implementation for fault tolerance

## Technology Stack

- Java 17
- Spring Boot 3.2.3
- MySQL Database
- Spring Data JPA
- Spring Cache
- Resilience4j
- Bucket4j
- Lombok

## Project Structure

```
src/main/java/id/val/learn01/
├── config/          # Application configuration
├── controller/      # REST controllers
├── model/          # Entity classes
├── repository/     # Data access layer
├── service/        # Business logic
├── exception/      # Custom exceptions
├── annotation/     # Custom annotations
└── aspect/         # AOP aspects
```

## Getting Started

1. Clone the repository:
   ```bash
   git clone [repository-url]
   cd learn01
   ```

2. Create `.env` file from template:
   ```bash
   cp .env.example .env
   ```

3. Configure environment variables in `.env`:
   ```properties
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=learn01
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   SERVER_PORT=8080
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

### User Management

- `GET /api/users` - Retrieve all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Caching

The application uses Spring Cache with two main caches:
- `users`: Cache for the complete user list
- `userById`: Cache for individual users by ID

## Error Handling

The application implements custom exceptions:
- `ResourceNotFoundException`: When requested resource is not found
- `IllegalArgumentException`: When input validation fails

## Rate Limiting

Rate limiting is implemented using Bucket4j with default configuration:
- 100 requests per 60 seconds

## Circuit Breaker

Circuit breaker pattern is implemented using Resilience4j to enhance application resilience.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



