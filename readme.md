# **Game of Life**

This project implements **Conway's Game of Life** using Spring Boot. It provides a REST API to initialize the game, fetch the current state, and generate the next generation of the game grid. The project includes a Swagger UI for API documentation, Actuator endpoints for monitoring, and an H2 in-memory database for storage.

## **Table of Contents**
- [Getting Started](#getting-started)
- [API Design](#api-design)
- [Entity Relationship Design](#entity-relationship-design)
- [H2 Console](#h2-console)
- [Swagger UI](#swagger-ui)
- [Actuator Endpoints](#actuator-endpoints)
- [Error Handling](#error-handling)

## Getting Started

### Prerequisites
- Java 17
- Maven

### **Build and Run**

1. Clone the repository:
   git clone <repository-url>
   cd game-of-life
2. mvn clean install
3. mvn spring-boot:run

##**API Design**

Endpoints

	•	POST /game-of-life/start: Initializes the game with a grid of a given size and starts the Glider pattern.
	•	Request Parameter: size (default: 25)
	•	Response: Returns the initialized grid.
Example:
curl -X POST "http://localhost:8080/game-of-life/start?size=25"


	•	GET /game-of-life/current-state: Retrieves the current state of the game grid.
	•	Response: Returns the current grid state (alive and dead cells).
Example:
curl -X GET "http://localhost:8080/game-of-life/current-state"

	•	GET /game-of-life/next-generation: Generates the next generation based on the current state and Game of Life rules.
	•	Response: Returns the updated grid.
Example:
curl -X GET "http://localhost:8080/game-of-life/next-generation"

##**Entity Relationship Design**

Entities:

	1.	GameGrid
	•	Represents the grid of the game. It contains a 2D array of Cell objects.
	•	Fields:
	•	grid: 2D array of Cell objects.
	•	size: The size of the grid.
	2.	Cell
	•	Represents a single cell in the game grid.
	•	Fields:
	•	alive: Boolean value to represent whether the cell is alive (true) or dead (false).

Relationships:

	•	A GameGrid contains many Cell objects, forming a composition relationship.
	•	Each Cell is part of the grid and represents its state (alive or dead).

##**H2 Console**

The application uses an in-memory H2 database to store the game state. You can access the H2 database console at:

	•	URL: http://localhost:8080/h2-console
	•	JDBC URL: jdbc:h2:mem:testdb
	•	Username: sa
	•	Password: password

To log in, use the default credentials provided in the application.properties file.


##**Swagger UI**

You can access the Swagger UI for API documentation at:

	•	URL: http://localhost:8080/swagger-ui.html

This will display the interactive API documentation where you can test the endpoints directly.

##**Actuator Endpoints**

The project includes Spring Boot Actuator for monitoring the application. The following endpoints are exposed:

	•	Health: http://localhost:8080/actuator/health
	•	Shows the health status of the application.
	•	Info: http://localhost:8080/actuator/info
	•	Provides basic information about the application.
	•	Metrics: http://localhost:8080/actuator/metrics
	•	Shows various metrics, including JVM stats, memory, and request counts.

Other Actuator endpoints such as loggers, env, heapdump, and threaddump are also available.

##**Error Handling**
The application includes a global error handler for managing exceptions and providing meaningful error messages. Here are the handled exceptions:

	•	GameNotFoundException: Thrown when the game grid is not initialized.
	•	Response: Returns a 404 Not Found status with a message.

If any unexpected errors occur, a generic 500 Internal Server Error response is returned with a message indicating an unexpected error.