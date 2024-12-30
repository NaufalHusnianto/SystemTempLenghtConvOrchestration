

# Temperature and Length Conversion Orchestration

This project is a Spring Boot microservices application that provides REST APIs to convert temperature and length measurements. The application utilizes Eureka for service discovery and a gateway server for centralized API routing.

## Teams
- Naufal Husnianto (K3522055)
- Paulus Titto Dermawan (K3522061)
- Septian Cesare Arden (K3522077) 

## Features

- Convert temperature between Celsius, Fahrenheit, Reamur, and Kelvin.
- Convert lengths between Meter, Inci, Kilometer.
- RESTful API endpoints for integration with other applications.
- Microservices architecture for scalability and fault tolerance.

## Requirements

- Java 17 or later
- Maven 3.8.1 or later
- Spring Boot 3.0 or later

## Microservices Overview

1. **Eureka Server**: Handles service discovery and registration.
2. **Gateway Server**: Routes client requests to appropriate microservices.
3. **Length Conversion Service (`LengthConvServer Instance 1`, `LengthConvServer Instance 2`)**: Provides APIs for length conversion.
4. **Temperature Conversion Service (`TemperatureConvServer Instance 1`, `TemperatureConvServer Instance 2`)**: Provides APIs for temperature conversion.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/NaufalHusnianto/SystemTempLenghtConvOrchestration.git
   cd SystemTempLenghtConvOrchestration
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Start the Eureka Server:
   ```bash
   cd EurekaServer
   mvn spring-boot:run
   ```

4. Start the Gateway Server:
   ```bash
   cd GateServer
   mvn spring-boot:run
   ```

5. Start the Length Conversion Services:
   ```bash
   cd LengthConvServer
   mvn spring-boot:run
   ```
   ```bash
   cd LengthConvServer Instance2
   cd LengthConvServer
   mvn spring-boot:run
   ```

6. Start the Temperature Conversion Services:
   ```bash
   cd TemperatureConvServer
   mvn spring-boot:run
   ```
   ```bash
   cd TemperatureConvServer2
   mvn spring-boot:run
   ```

## API Endpoints

### Gateway Server

The Gateway Server routes requests to the appropriate microservices based on the URL path. All requests should be made to the Gateway Server's base URL.

**Base URL:** `http://localhost:1001`

### Temperature Conversion

#### POST `/api/convert-temp`

Example convert temperature between Celsius, Fahrenheit, Reamur, and Kelvin.

**Request Body:**
```json
{
  "value": 100,
  "from": "Celsius",
  "to": "Fahrenheit"
}
```

**Response:**
```json
{
  "converted_value": 212.0,
  "message": "Conversion successful"
}
```

### Length Conversion

#### POST `/api/convert-length`

Example convert length between Meter, Inci, Kilometer.

**Request Body:**
```json
{
  "value": 5,
  "from": "Meters",
  "to": "Inci"
}
```

**Response:**
```json
{
  "converted_value": 16.4042,
  "message": "Successfull"
}
```

## Architecture

The application is built using a microservices architecture with the following components:

1. **Eureka Server**: Manages service registration and discovery.
2. **Gateway Server**: Centralized API gateway for routing and load balancing.
3. **Conversion Services**:
   - **Length Conversion Services**: Two instances (`LengthConvServer Instance 1`, `LengthConvServer Instance 2`) for load balancing and fault tolerance.
   - **Temperature Conversion Services**: Two instances (`TemperatureConvServer Instance 1`, `TemperatureConvServer Instance 2`) for load balancing and fault tolerance.

## Project Structure

```
├── EurekaServer
├── GateServer
├── LengthConvServer
├── LengthConvServer Instance2
	├── LengthConvServer
├── TemperatureConvServer
├── TemperatureConvServer2
└── Design.png
```

## Configuration

Each service has its own `application.properties` file for configuration. The Eureka Server and Gateway Server must be configured to communicate with the microservices.

Example `application.properties` for Eureka Server:
```properties
spring.application.name=EurekaServer
server.port=1100
```

Example `application.properties` for a Conversion Service:
```properties
spring.application.name=LengthConvServer
server.port=4000
eureka.client.service-url.defaultZone=http://${registry.host:localhost}:${registry.port:1100}/eureka/
```

Example `application.properties` for a Gateway Server:
```properties
spring.application.name=GateServer
server.port=1001
eureka.client.service-url.defaultZone=http://${registry.host:localhost}:${registry.port:1100}/eureka/
```
