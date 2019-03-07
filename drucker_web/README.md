# Drucker Web

This directory is the web server and frontend for the Drucker tool implemented using Spring framework and managed by Gradle.

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

## Deployment

We plan to migrate the entire project to a docker system.

## Built With

* [Spring Framework](https://spring.io) - The web framework used
* [Gradle](https://gradle.org) - Dependency Management

## Authors

* **Tianrui Zhang** - *Initial work* - [Email](mailto:tianrui.zhang@duke.edu)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
