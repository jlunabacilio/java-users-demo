# java-users-demo Backend
This repository contains a Java users demo application. It showcases the implementation of a simple users management using Java programming language.

## Features
- Add new users to the user management app - Available
- View the list of users - Available
- Edit status of existing users - To be implemented
- Remove users - To be implemented

## Getting Started
To get started with the Java users demo, follow these steps:

1. Clone the repository: `git clone https://github.com/jluabacilio/java-users-demo.git`
2. Open the project in your Visual Studio Code (suggested).
3. Use GitHub Copilot to build UsersController.java
3. Once created, build and run the application.

## Tools and versions required
- Java 17.0.11
- Maven 3.6.3
- Use Visual Studio code and next plugins:
  - Extension Pack for Java
  - GitHub Copilot
  - GitHub Copilot Chat

## How to create UsersController.java
Idea of UsersController.java is to be responsible for handling HTTP requests related to Users objects.

### Creating UsersController.java using GitHub Copilot
1. Create UsersController.java file in src/main/java/com/demo

2. Copy and paste next libraries:
```java
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
```

3. Type next prompt after libraries: `//generate a rest controller with th path of /`, this line will trigger suggestions code from GitHub Copilot, clic tab up to get:
```java
@RestController
@RequestMapping("/")
@Validated
```

4. In public class UsersController, start typing next code line: ` private final UsersRepository repository;` and start pressing tab to see suggestions of GitHub Copilot.

5. Add next line as comment: `//generate a get method with the path of /users` and tab to accept suggestiong from GitHub Copilot and fix as required.

6. Try it also for get method using ids`//generate a get method with the path of /users/{id}` and post method to create new users`//generate a post method with the path of /users`.

### Creating tests using GitHub Copilot

1. Uncomment libraries in UsersControllerTest.java from src/test/java/com/demo
2. In `public class UsersControllerTest` start typing: `@Autowired` and press tab for the suggestions given by GitHub Copilot
3. To get GitHub Copilot suggestions on test, type `//create the test for the POST endpoint of users controller` and start pressing tab as required.
4. Run test directly from Visual Studio Code or running `mvn test` command.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.

## Contact
If you have any questions or need further assistance, feel free to contact me at josea.luna@softtek.com or david.rodriguezh@softtek.com.
