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
| Ric       |  00000000 |
| Piyush    |  11111111 |
| Honglin   |  22222222 |
| Mengting  |  33333333 |
| Sihao     |  44444444 |

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
|Simple Payback period (year)|arraylist[2]|

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
|Escalting Rate: |3% (fixed)|
|NPV|arraylist[0]|
|IRR|arraylist[1]|
|Payback Period period (year)|arraylist[2]|


Below are the message board attributes we have in the database. This forum is responsive for internal communications. It will display all the posts with comments and is supportive of adding new posts and comments.

Post details:

| pID   |      username      |      time      |      cnum      |      title     |     content     |     shortcontent     |
|----------|:-------------:|:-------------:|:-------------:|:-------------:|:-------------:|:-------------:|
|1|Ric|2019-04-18 11:29:33|3|First post|Welcome to the first post of Drucker Message Board from Ric!|NULL|
|2|Ric|2019-04-18 11:29:38|5|New hire training guide|To all: please guide new hires through training guides and they shall be able to complete the quiz.|NULL|
|3|Mengting|2019-04-18 11:29:43|1|Working from home today|Bad weather. Feel free to work from home today.|NULL|
|4|Honglin|2019-04-18 11:23:52|0|Model updates|Lightning and water plumbing model need to be updated soon. Watch out for details.|NULL|
|5|Piyush|2019-04-18 11:29:49|2|Please help update documents|I have finalized all the documents for internal use. Calling tech team to add them.|NULL|


Comment details:

| postID   |      username      |      time      |     content     |     shortcontent     |
|----------|:-------------:|:-------------:|:-------------:|:-------------:|
|1|Rui|2019-04-16 19:41:48|Hello from Drucker server team!|NULL|
|1|Chong|2019-04-16 19:42:43|Hello from Drucker client team!|NULL|
|1|Minghui|2019-04-16 19:43:20|Hello from Drucker Android team!|NULL|
|2|Tianrui|2019-04-16 19:56:17|Understood.|NULL|
|2|Yueying|2019-04-16 19:57:41|Sure. I'll keep track of that.|NULL|
|2|Yijie|2019-04-16 19:58:22|Well received. Thanks.|NULL|
|2|Yuqiao|2019-04-16 19:59:55|How do they feel about that?|NULL|
|2|Yijie|2019-04-16 20:00:26|They are doing really well.|NULL|
|3|Honglin|2019-04-16 20:04:27|Me too.|NULL|
|5|Yifan|2019-04-16 20:14:00|I will add the first part.|NULL|
|5|Xiaohuan|2019-04-16 20:14:22|I will add the second part.|NULL|


## Special Note When testing Decision Tool
When using decision tool, you need to hit 'Add More' every time when you add new data into the form. For authentication reasons, you will be asked to input your username and password again.


## Deployment

Currently, this application is binded to Duke Virtual Computing Manager for remote database access. It shall work normally 24-7. If not, please double check with Rui Sun - [Email](mailto:rui.sun585@duke.edu). 
For future advancement of the system, we plan to migrate the entire project to a docker system.

## Built With

* [Spring Framework](https://spring.io) - The web framework used
* [Gradle](https://gradle.org) - Dependency Management

## Authors

* **Tianrui Zhang** - *Initial work* - [Email](mailto:tianrui.zhang@duke.edu)
* **Chong Xu**
* **Yifan Xiao**
* **Rui Sun**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
