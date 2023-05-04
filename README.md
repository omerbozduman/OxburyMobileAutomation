Oxbury Testing Exercise / Instructions Codes and Tests Prepared by: Omer BOZDUMAN

Software Development in Test / Electrical&Electronic Engineer

omer.bozduman@yahoo.com

https://www.linkedin.com/in/omer-bozduman/

Build Tool: Maven

Dependencies : Appium , Cucumber J-Unit, Cucumber Java 

Plugins : maven-cucumber-reporting , maven-surefire-plugin

Test Framework: Cucumber BBD (with Junit Assertions)

BBC News Android App :  bbc_news/AppFiles/bbc.mobile.news.uk_6.2.41-6024105_minAPI21(arm64-v8a,armeabi,armeabi-v7a,mips,mips64,x86,x86_64)(nodpi)_apkmirror.com.apk

Device : Android

System Requirements: Java 19 + SDK Test RUN

Framework Model : POM(Page Object Model).Each page/tab has own Feature, Step Definitions, Identifiers and Action directories. 
There is a separate CommonAction class and all action classes are child of this class.(Inheritance). This class has all common methods.

Note-1: To run all Scenarios, use @smoke tag in the CukesRunner class. Also run all test cases from Maven verify.

Note-2: I execute and assert my test cases by using JUnit. I use @Before tag for  and I use @After tag close the session in Hooks class.

Note-3: BBC News app keeps the user as logged in after first login 
therefore before run the @login tag(Scenario: As a user I should be able to login my BBC News account) then run the @smoke tag.

Note-4: I use maven-cucumber-reporting plugin for Cucumber reports. To generate Cucumber report, execute related task's tag by using maven verify.