# openweather-test


This project consists of cucumber test written for the below application: 

https://github.com/buildit/acceptance-testing

The application is cloned to my git desktop, later deployed and build in the local and the application is running in the below URL: 

http://localhost:3000/

Cloned in git-desktop and ran the npm install and build from terminal


Pre-requisites: 

Homebrew installed
Node installed
Eclipse Installed 
Cucumber Plugin installed
Chrome and firefox for running test
Chrome Driver

Chrome plugin for Gherkin syntax check: 
**Tidy Gherkin



Steps for building the project in Eclipse

1.	Created Maven Project
2.	Add the required dependency in the POM file as below:

3.	All the required tests related java class files are written under src/test/java
a.	Org.openweather.features (cucumber feature file is added with scenarios)
b.	Org.openweather.selenium (DriverManager.Java and HomePageObjects.java)
c.	Org.openweather.stepdefinitions (RunCukeTest.java and WeatherMapBaseFunctions.java)
4.	Cucumber feature files are run as below:

once it is run you will get all the pending definition functions created which is copy pasted to your step definition file.

5.	After completing the test, we need to run the test as Run As Maven Test, once this is done all the tests will be run and the reports are generated. 
6.	Once the tests are created, later the reports are stored in target in the below formats
a.	HTML
b.	JSON
c.	Junit


Background work: 

The acceptance criteria and the details of the project are analyzed initially. After this task I derived at 5 user stores and those acceptance criteria. These details are recorded in a different file named “user stories and Background work”
