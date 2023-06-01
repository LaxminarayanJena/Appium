
# IOS Setup
https://www.swtestacademy.com/ios-testing-appium-java/

### 1.1. Homebrew Installation
```
In order to install and update the required packages easily, we should install HomeBrew and enable it.

/usr/bin/ruby -e “$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)”

brew -v command 
```

### 1.2. Node.js Installation
```
 brew install node
 node -v 
 ```
 
 ### 1.3. Appium Installation
```
 npm install -g appium 
npm install appium@1.7.2
 appium -v
 appium -server started (0.0.0.0:4723)
 ```
 
  ### 1.4. Installation and Settings of Required Packages for iOS Testing
```
1.4.1.  brew install libimobiledevice- In order to run our tests on real devices

1.4.2. brew install ios-deploy -To deploy our apps to our devices by using ios-deploy.

1.4.3. brew install carthage -Decentralized dependency manager for Cocoa

1.4.4. Install WebDriverAgent opens the apps when it is downloaded to the device. It is a WebDriver server application which let us control iOS devices remotely. We can integrate it with XCTest.framework and run the commands on the device. WebDriverAgent is developed at Facebook for end-to-end testing. In order to install it, we should to the below steps:

Go to https://github.com/facebook/WebDriverAgent address and download the WebDriverAgent project to your MacBook. Double-click the file which has .zip extension and extract its content. Then open the terminal and execute below command:

cd /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/

Then, you need to write "open ."  and hit the enter key.
Copy the WebDriverAgent folder to appium-xcuitest-driver window.
 open cmd in same directory 
cd WebDriverAgent
mkdir -p Resources/WebDriverAgent.bundle
./Scripts/bootstrap.sh

On appium-xcuitest-driver window, click the WebDriverAgent folder and open the WebDriverAgent.xcodeproj folder with XCode.

 ```
## Tech Stack

**Framework:** Cucumber With PageObject Model Design 

**Language:** Java

## Framework Capabilities

- Cross browser testing support. </br>
- Added browserstack support for CrossBrowser testing. </br>
- Running tests in docker containers selenium grid. </br>
- Rest Api and GraphQL testing support powered by RestAssured. </br>
- Visual regression testing using percy.io. </br>
- Accessibility testing using axe-selenium. </br>
- Stubbed api testing using WireMock. </br>
- Database testing support. </br>

## Screenshots
![Report](https://user-images.githubusercontent.com/92700205/216805111-90ffd88e-364d-4679-8dd9-c5014ad6cbc7.png)

## Authors

- [@LaxminarayanJena](https://github.com/laxminarayanJena)


## Feedback

If you have any feedback, please reach out to us at 
Repo owner or admin (v_laxminarayan.jena@jsw.in)
Other community or team contact


## Run Locally

Clone the project

```bash
  git clone https://github.com/JSWOne/jsw_msme_Automation
```

Go to the project directory

```bash
  cd jsw_msme_Automation
```

Install dependencies

```bash
  mvn install 
```

Start the project

```bash
  mvn clean test
```





