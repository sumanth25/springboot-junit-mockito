# Springboot Junit5 Mockito
This repo is intended to demonstrate how one can use Junit5 & Mockito in a springboot project for writing unit test cases and achieving 100% code coverage. 

Note: Code quality is a different metric and is not automatically improved by writing unit testcases or having 100% code coverage.

## Main Features

* Standard Project Structure - model, repository, service, dto, controller...
* Mockito - Mock framework using annotations @Mock, @InjectMocks
* Junit5 - Unit testing framework for Java
* Lombok - Reduce boilerplate code for model/data objects
* Code Coverage - 100% achieved with all test cases. Verified with Coverage plugin of IntelliJ

### Prerequisites

What things you need to install before starting

* JDK 1.8
* IntelliJ Community Edition (https://www.jetbrains.com/idea/download/#section=windows) & Embedded Maven
* Coverage for Java Plugin - IntelliJ
* Git Client - (https://git-scm.com/)

## Getting Started

These instructions will help you to get your project up and running on your local machine for development and testing purposes. The application is build on top of Spring Boot (https://spring.io/projects/spring-boot) providing a runtime container. 

## Learning Resources

* Mockito - (https://www.youtube.com/watch?v=d2KwvXQgQx4&t=3644s)
* Mockito for REST Web Services - (https://www.youtube.com/watch?v=RbZvXCAtMus)
* Mockito Annotations - (https://www.youtube.com/watch?v=2dpUw0WQqAs)
* Mocking Final and Static Methods - (https://www.youtube.com/watch?v=0gCNMml0or0)
* Mock with Junit and Spring - (https://www.youtube.com/watch?v=eqRF4xHoGck)
* Spy vs Mock - (https://www.youtube.com/watch?v=FLwGdJIRNmc)

## How to use git ##

All sources are available as public at https://github.com/sumanth25/springboot-junit-mockito
To use git to get repository contents run the following git command:

```
#!bash
git clone https://github.com/sumanth25/springboot-junit-mockito.git
```

## How to use IntelliJ Coverage Plugin ##

Install Coverage Plugin if not present by default by searching for Code Coverage for Java in File->Settings->Plugins
Use the below commands to see coverage report:

```
* On Intellij click on java under src/test/java
* Right-click and select Run with coverage
* Check complete report on Coverage tab which opens on the right.
```

## Ports and URL's

|     Application       |     Port          |     URL     |
| ------------- | ------------- | ------------------------ |
| Currency Exchange Service | 8000  | (http://localhost:8000/currency-exchange/from/USD/to/INR/) |

## Deployment

* Use jenkins job or batch scripts to automate start/stop. You can manually start it with java -jar currency-conversion-service 0.0.1.jar. 


## Authors

* **Sumanth Sudeendra**  - *Initial work* - (https://github.com/sumanth25/springboot-junit-mockito)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Acknowledgments

* Thank You In28Minutes! - (https://github.com/in28minutes/MockitoTutorialForBeginners)
