# Appium
Appium-selenium 3.0 API for Mobile Automation Testing

![appium](https://user-images.githubusercontent.com/24494133/42090141-d006b1c2-7bbd-11e8-9647-b751c9f7c986.png)

### Latest android version android 9.0 pie api level28
older-android version android 8.1 oreo level 27 </br>
appium java client 7.0-dec 27 2018 </br>
appium gui desktop-1.10 </br>
Xcode -10 </br>
latest version of iOS - iOS 12. </br>
# ADB Commands
1)adb devices

2)adb shell

dumpsys window windows | grep -E 'CurrentFocus'

3)adb tcpip 5555

4)adb connect 192.168.0.101
(*ip of wifi of mobile) 



--------------------------------------------

emulator -avd kitkat



--------------------------------------------



adb install "D:\software\testing software\MOBILE TESTING\APKS\HTML5testWebView.apk"

chrome://inspect/#devices

# AndroidStudio emulator
![avd settings](https://user-images.githubusercontent.com/24494133/42304144-68bd9b46-8042-11e8-99a6-5cd42b342882.PNG)
# Appium Architecture
![appiumarchitecture](https://user-images.githubusercontent.com/24494133/43879019-8efea5be-9bbf-11e8-9264-dcef7e7fab1e.png)

### Locators
AccessibilityId- content-desc </br>
AndroidUIAutomator -text </br>
driver.findElementByAndroidUIAutomator("new UiSelector().text(\"i accept adds\")").click() </br>
ClassName -class </br>
CssSelector </br>
Id- ResourceId  </br>
LinkText </br>
Name </br>
PartialLinkText </br>
TagName </br>
XPath- driver.findElementByXPath("//ClassName[@content-desc='content-desc']").click()

