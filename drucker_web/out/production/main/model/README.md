# Drucker Server and Database

This directory is the server and database for the Drucker project using MySQL database and Spring framework.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

We use Duke Virtual Computing Manager as the platform for drucker team server side MySQL database. It shall work normally 24-7. Please make sure it is running before you proceed. 
If not, please double check with Rui Sun - [Email](mailto:rui.sun585@duke.edu). See deployment for future advancement of the system.


### Installing

The following instructions should work for any Java IDEs.

Clone the repository to local computer

```
git clone git@gitlab.oit.duke.edu:ECE651_S19/drucker.git
```

Open the Java IDE and import project from:

```
drucker/drucker_web
```

Note that the inclusion of mysql-connector-java-5.1.38.jar and json-simple-1.1.1.jar in the directory should not be removed to ensure Java JDBC is able to connect to MySQL and perform SQL queries.

## Test the App
Below are the sample users we have in the database. This API will validate an incoming username and password pair with the stored values in the database and return a JSON object containing the information requested from front end and Android. Currently, it contains the requesting username and a boolean indication.

 | username   |      password      |
|----------|:-------------:|
| testuser1 |  00000000 |
| testuser2 |  11111111 |
| testuser3 |  22222222 |
| testuser4 |  33333333 |
| testuser5 |  44444444 |


## Deployment

The current deployment of Java - MySQL connection is based on accessing external database with protocols. As we migrate to the Docker container later, this application shall not be binded to remote machines.


## Authors

* **Rui Sun** - *Initial work* - [Email](mailto:rui.sun585@duke.edu)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.