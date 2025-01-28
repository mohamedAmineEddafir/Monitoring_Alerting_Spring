# Monitoring and Alerting Spring Boot Application

A Spring Boot application for monitoring and alerting system built with Java 21 and Spring Boot 3.4.1.

## Technologies Used

- Java 21
- Spring Boot 3.4.1
- Spring Data JPA
- PostgreSQL
- H2 Database (for testing)
- Project Lombok
- Docker Compose
- iText PDF (v5.5.13.3)
- Spring Boot Validation

## Prerequisites

- JDK 21
- Maven
- Docker (for running with Docker Compose)
- PostgreSQL

## Project Structure

```
Monitoring_Alerting_Spring/
├── src/
│   ├── main/
│   │   ├── java/         # Java source files
│   │   │   ├── controller
│   │   │   ├── DTO
│   │   │   ├── models
│   │   │   ├── repository
│   │   │   ├── service
│   │   │   │   ├── impl
│   │   └── resources/    # Application properties and resources
│   └── test/             # Test files
├── .mvn/                 # Maven wrapper directory
├── .gitignore           # Git ignore file
├── .gitattributes       # Git attributes file
├── mvnw                 # Maven wrapper script (Unix)
├── mvnw.cmd             # Maven wrapper script (Windows)
├── pom.xml              # Project dependencies and build configuration
└── README.md            # Project documentation
```

## Features

- Spring Boot web application setup
- Database integration with PostgreSQL
- Data validation
- PDF generation capability using iText
- Docker compose support for containerization
- Comprehensive test setup with H2 database

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/mohamedAmineEddafir/Monitoring_Alerting_Spring.git
```

2. Navigate to the project directory:
```bash
cd Monitoring_Alerting_Spring
```

3. Build the project:
```bash
./mvnw clean install
```

4. Run the application:
```bash
./mvnw spring-boot:run
```

## Docker Support

The application includes Docker Compose support. To run using Docker:

```bash
docker-compose up
```

## Testing

The project uses H2 in-memory database for testing. Run tests using:

```bash
./mvnw test
```

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- PostgreSQL Driver
- H2 Database (Test)
- Project Lombok
- iText PDF
- Spring Boot Docker Compose

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Author

- Mohamed Amine Eddafir

## License

This project is licensed under the MIT License - see the LICENSE file for details
```

This README.md provides:
1. A clear overview of the project
2. Technologies and dependencies used
3. Project structure
4. Setup instructions
5. Docker support information
6. Testing instructions
7. Contribution guidelines
8. Author information

The content is based on the project's pom.xml file and repository structure. You can customize it further by:
1. Adding specific configuration instructions
2. Including API documentation
3. Adding more detailed usage examples
4. Including troubleshooting sections
5. Adding badges for build status, code coverage, etc.
