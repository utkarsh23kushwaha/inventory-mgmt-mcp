# Inventory Management Project

This project demonstrates how to build an MCP (Model Context Protocol) server using Spring Boot and Spring AI, exposing backend capabilities to LLMs in a structured and plug-and-play manner.

The application is based on a simple inventory management system with SQLite, where service layer methods are exposed as MCP tools using annotations like @McpTool, enabling natural language interaction with the system.

## Prerequisites
- **Java 17** or higher (JDK)
- **Maven 3.6+**
- (Optional) IDE like IntelliJ IDEA or VS Code

## Project Structure
- `src/main/java/com/inventorymgmt/mcp/` - Main application code
- `src/main/resources/` - Configuration files
- `pom.xml` - Maven build configuration

## How to Run

1. **Clone the repository** (if not already done):
   ```sh
   git clone <repo-url>
   cd inventory-mgmt-mcp
   ```

2. **Build the project using Maven:**
   ```sh
   mvn clean install
   ```

3. **Run the Spring Boot application:**
   ```sh
   mvn spring-boot:run
   ```
   Or, run the generated JAR file:
   ```sh
   java -jar target/mcp-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application:**
   - The MCP Server will be available at `http://localhost:8181/` by default.



## Additional Notes
- Configuration can be modified in `src/main/resources/application.properties`.

### Available Values

#### Location
The following values are available for `Location`:

- Warehouse A
- Warehouse B
- Warehouse C
- Warehouse D
- Warehouse E
- Office Store

#### Material Type
The following values are available for `MaterialType`:

- CONSTRUCTION
- HARDWARE
- ELECTRICAL
- PLUMBING
- CHEMICAL
- PACKAGING
- OFFICE
- MISC