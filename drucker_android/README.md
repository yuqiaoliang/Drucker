# Drucker Andriod

This directory is the android for the Drucker.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

```
Android Studio
You can download the software from https://developer.android.com/studio
```

### Installing

After installing Android Studio, you can open the project by the following instructions:

Clone the repository to local computer

```
git clone git@gitlab.oit.duke.edu:ECE651_S19/drucker.git
```

Open Android Studio and import project from:

```
drucker/drucker_android
```

Click Import from an existing Android Studio project and choose build.gradle, accept all default options and navigate to the Gradle window. Click the run button on the upper-right corner to start the project. 

## Tests the App

Before running the project, it's recommended that your Android Studio version is 3.2.1(or higher) for software compatibility reasons.

In Android Studio, click the app module in the Project window and then select Run > Run (or click Run button in the toolbar).

If it is your first time to use an emulator:

```
 In the Select Deployment Target window, click Create New Virtual Device.

In the Select Hardware screen, select a phone device, such as Pixel, and then click Next.

In the System Image screen, select the version with the highest API level. If you don't have that version installed, a Download link is shown, so click that and complete the download.

Click Next.

On the Android Virtual Device (AVD) screen, leave all the settings alone and click Finish.

Back in the Select Deployment Target dialog, select the device you just created and click OK.
```

Android Studio installs the app on the emulator and starts it. You should now see "TESTApp" displayed on the top of the front page.

You will also see two text bar empty with hints

```
"username" and "password"

```

You can input the username and password in the two fields and click login. 

Both fields are required, and if either is missing, the system will prompt a toast message with

```
"Username and password are required."
```

If you fail to login, the system will display a prompt with 

```
"Wrong username or password"
```

and a button label with 

```
"Retry"
```

You can retry the username or password.

If you successfully log in, you will see the main user page with a welcome message on the top and four buttons named

```
"Message Box", "Practice Guide", "Training", and "Decision"
```

If you press the button, the app will jump to the corresponding page.

For local testing, we created two JSON objects for success/fail login respectively(given by two url). Each JSON object includes a username and a validation field(the same as retrieved from server).

The defalt url is fail login. To test successful login behavior, use the first url in loginActivity.java(around line 77) and comment the line below for fail url.

## Deployment

Now the system is test with Nexus 5X API 28 and Nexus 4 API 23.


## Authors

* **Yueying Wu** - *Initial work* - [Email](yueying.wu@duke.edu)


## License

This project is licensed under the MIT License - see the [LICENSE](drucker_web/LICENSE) file for details

