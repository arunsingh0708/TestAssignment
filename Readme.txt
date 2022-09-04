Introduction
Automation is done using Selenium TestNG Framework (Maven Project)
Project Name-Task4
Package description
1. src/test/java/com.automation.pagelibrary.assignment-It consist of a program file
a. Homepage.java

The above file contain Page objects and application related functions.


2. src/test/java/com.automation.testcases.assignment
It consist of below program file
a. ShopClothes.java-It consist  test case  

3. src/test/java/com.automation.testutilities

It consist of below program file 
a. Testbase.java-This is responsible for initializing the WebDriver,maximize browser window,deletebrowser cookies,Load config.properties file etc.


How to Run
1. In IDE just right click on testng.xml file and click on Run as 'TestNG Suite' will invoke  tests
2. It can be executed from command line also using maven command- mvn test

Test report
1.It is a default TestNG report generated in test output folder(index.html,emailable-report.html)
2.If run using maven command (mvn test),report can be found in folder target\surefire-reports(index.html,emailable-report.html)




