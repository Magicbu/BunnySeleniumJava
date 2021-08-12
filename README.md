# BunnySeleniumJava
This is selenium with Java assignment


Softwares or Java Libraries required:
1. Eclipse IDE (latest version)
2. Java JDK 8
3. TestNG Eclipse plug-in
4. chromedriver.exe [verion 91.0]
5. selenium-server-standalone-3.141.59.jar
6. testng-6.14.3.jar
7. commons-io-2.8.0.jar

Note: all the mentioned above jars already downloaded and copied to "lib" folder and also build path has been set.

Total 5 test scenarios have been automated
1. validateSuccessfullLogin
2. validateLogin_WithWrongPassword
3. validateLogin_ForLockedOutUser
4. validateLogin_UserNameAsBlank
5. validateLogin_PasswordAsBlank


Steps to Import and Execute Tests:
1. Import the project into Eclipse IDE
2. Right click on "aequilibriumLoginTests.xml" file and select the option Run As - TestNG Suite

TestNG test reports can be found under ./test-output folder and screenshots of failed tests can be found under ./test-output/screenshots folder once the test execution completed
