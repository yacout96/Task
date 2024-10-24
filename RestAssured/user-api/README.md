## User API Testing with RestAssured

This project provides a framework for testing the User API using RestAssured. It utilizes a POM like design pattern. The Project uses Maven, Java, JUnit and Eclipse IDE to support the framework. 

**Project Structure:**

- `src/main/java/com.yacout.user_api`:
    - `BaseRequest.java`: Base class for API requests with common functionalities.
    - `LoginRequest.java`: Extends `BaseRequest` for login functionality.
    - `PingRequest.java`: Extends `BaseRequest` for ping functionality.
    - `WhoAmIRequest.java`: Extends `BaseRequest` for whoami endpoint functionality.
- `src/main/resources`:
    - `APIConstants.java`: Contains external values like URLs, usernames, passwords, and error messages.
- `src/test/java/com.yacout.user_api`:
    - `APITest.java`: Contains JUnit test cases for API interactions.

**Features:**

  - Send POST requests to multiple endpoints
  - Send GET request to multiple endpoints

**Usage:**

The project tests can be run using JUnit, by running either single or all tests.
  - Single Test: Right click on test name >> Run As >> JUnit Test
  - All Tests: Right click on class >> Run As >> JUnit Test

**Prerequisites:**

  - Java installed
  - Rest-Assured 
  - Eclipse IDE (Or Similar)
  - Check POM.xml for versions

**Contribution:**

Feel free to fork the repository and contribute improvements or add new features. Consider following the existing coding style and conventions within the code.



**Author:**

Yacout
