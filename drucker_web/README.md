# Drucker Web

This directory is the web server and frontend for the Drucker tool implemented using Spring framework and managed by Gradle. The database is built in MySQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- JDK version 1.8
- IntelliJ IDEA (recommended)


### Installing

If you are using IntelliJ IDEA, this guide should work for you regardless of your platform.

Clone the repository to local computer

```
git clone git@gitlab.oit.duke.edu:ECE651_S19/drucker.git
```

Open IntelliJ and import project from:

```
drucker/drucker_web
```

Follow through the instructions and add click **Import Gradle Project**, accept all default options and navigate to the Gradle window. In Tasks->Application, double click BootRun to start the server.

## Test the App

Now that the web site is running, visit http://localhost:8080/greeting, where you see:

```
"Hello, World!"
```

Provide a `name` query string parameter with http://localhost:8080/greeting?name=User. Notice how the message changes from "Hello, World!" to "Hello, User!":

```
"Hello, User!"
```

This change demonstrates that the {RequestParam}[`@RequestParam`] arrangement in `GreetingController` is working as expected. The `name` parameter has been given a default value of "World", but can always be explicitly overridden through the query string.

Below are the sample users we have in the database. This Account API will validate an incoming username and password pair with the stored values in the database and return a string containing the password validation result (either 'true' or 'false') to the front end and Android side.

 | username   |      password      |
|----------|:-------------:|
| testuser1 |  00000000 |
| testuser2 |  11111111 |
| testuser3 |  22222222 |
| testuser4 |  33333333 |
| testuser5 |  44444444 |

Below are the sample URLs we have in the database. This URL API will be given a type name (either 'pdf' or 'video') and return an arraylist consisting of all the pdf links or video links we have in the database for the use of training module and best practices module.
 | id   |      type      |      url      |
 |----------|:-------------:|:-------------:|
 | 1 |  pdf |  https://www.druckerandfalk.com/sites/default/files/RTD%20Apartment%20Article.pdf |
  | 2 |  video |  https://www.druckerandfalk.com/gallery    |

## Deployment

Currently, this application is binded to Duke Virtual Computing Manager for remote database access. It shall work normally 24-7. If not, please double check with Rui Sun - [Email](mailto:rui.sun585@duke.edu). 
For future advancement of the system, we plan to migrate the entire project to a docker system.

## Built With

* [Spring Framework](https://spring.io) - The web framework used
* [Gradle](https://gradle.org) - Dependency Management

## Authors

* **Tianrui Zhang** - *Initial work* - [Email](mailto:tianrui.zhang@duke.edu)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
