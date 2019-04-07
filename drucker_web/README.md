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

Below are the URLs we have in the database given by our client. This URL API will be given a type name (either 'pdf' or 'video') and return an arraylist consisting of all the pdf links or video links we have in the database for the use of decision model module and best practices module.

| id   |      type      |      url      |
|----------|:-------------:|:-------------:|
| 1 |  pdf |  https://drive.google.com/file/d/18iGcdDR7IpSGe0ofKiPk_xgYuBvVY5ZZ/view?usp=sharing |
| 2 |  video |  https://www.druckerandfalk.com/gallery    |
| 3 |  pdf |  https://drive.google.com/file/d/1Vii_EELBf_XG19S0RKlF1rqkzjTwSqSZ/view?usp=sharing |
| 4 |  pdf |  https://drive.google.com/file/d/11o4j2eP2jU6Oa6YDSBS8tJVn4ELuAn4A/view?usp=sharing |
| 5 |  pdf |  https://images.forrent.com/imgs/fr/propertyFiles/433/912/999/05_11710588780449818.pdf |

Below is the decision model module. This Decision Model API will be given and return an arraylist consisting of all the output from the requested service model.
**Sub-modules: Lightning Retrofit Model**
Input parameters:

| Name   |      Input parameter      | 
|----------|:-------------:|
|ExcelAnalysis() xxx|new ExcelAnalysis()|
|Electricity Rate|x1|
|Tax Rate|x2|
|Minimum Acceptable Return|x3|
|\- Current Bulb \-|
|Fixture Type|s1|
|Number of Bulbs|x4|
|Price|x5|
|Wattage|x6|
|Lumens|x7|
|Lifespan|x8|
|Hours used per day (Weekday)|x9|
|Hours used per day (Weekend)|x10|
|\- Replacement Bulb \-|
|Fixture Type|s2|
|Number of Bulbs|x11|
|Price|x12|
|Wattage|x13|
|Lumens|x14|
|Lifespan|x15|
|Hours used per day (Weekday)|x16|
|Hours used per day (Weekend)|x17|
|Rebates|x18|

Outputs (in order):

| Name   |      Output parameter      | 
|----------|:-------------:|
|Escalting Rate: |3% (fixed)|
|NPV|arraylist[0]|
|IRR|arraylist[1]|
|Simple Payback|arraylist[2]|

**Sub-modules: Water Faucet Retrofit Model**
Input parameters:

| Name   |      Input parameter      | 
|----------|:-------------:|
|Water Cost|y1|
|Tax Rate|y2|
|Minimum Acceptable Return|y3|
|\- Current Fixture \-|
|Fixture Type|s1|
|Number of Fixture|y4|
|Price|y5|
|Flow Rate|y6|
|Estimated hours used per day|y7|
|\- Replacement Fixture \-|
|Fixture Type|s2|
|Number of Fixtures|y8|
|Price|y9|
|Flow Rate|y10|
|Estimated hours used per day|y11|
|Rebates|y12|

Outputs (in order):

| Name   |      Output parameter      | 
|----------|:-------------:|
|NPV|arraylist[0]|
|IRR|arraylist[1]|
|Payback Period|arraylist[2]|


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
