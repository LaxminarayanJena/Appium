
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





