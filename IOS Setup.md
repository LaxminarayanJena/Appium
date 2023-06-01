
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
### 1.5. Xcode settings

```
 xcode-preferences-accounts- sign in with developer account

open webdriver agent folder- click webdriver agent lib-
automaticaly signin for all under target folder

select team and check provisioning profile and signing certificates filled

clean build and sign in succeded
 ```
  idevice_id –list.
  
  ## UDID 

- Rename the file extension of the IPA (iOS) or APP (macOS) file to .zip. </br>
- Extract the contents of the ZIP file.  </br>
- In the extracted files, navigate to the "Payload" folder.  </br>
- Right-click on the app's bundle (usually ending with .app extension) and select "Show Package Contents."  </br>
- Open the "Info.plist" file using a text editor.  </br>
- Look for a key named "CFBundleIdentifier." The value next to this key is the Bundle ID of the app.  </br>
















