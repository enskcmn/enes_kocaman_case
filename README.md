# Web Automation Project

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven

## Project Structure
- Page Object Model (POM) design pattern is used
- Tests are written without any BDD framework
- Browser type is parametrically configurable

Browser can be changed via TestNG parameter.  
If no parameter is provided, tests run on **Chrome** by default.

## How to Run Tests
```bash
mvn clean test
