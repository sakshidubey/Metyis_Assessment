
# PVH B2B

This repository contains regression test cases of login flow for the PVH B2B module. It is developed by using Cucumber and Selenium. It also generate HTML report at the end of the execution.
	
	Framework Architecture and Improvments: https://excalidraw.com/#json=4Q0N_TgREPXE7B9_nT5Fq,jfpGyw4PUS7HmaL_Hkyufw
	
## Framework Description

1. It is using BDD approach so that anyone can understand the intent of tests and also have tagging facility to separate our feature execution based on different tags (sanity, regression, etc)

2. It is based on Page Object Model where we can store locators in different classes based on page like (LoginPage class which consists login specific locators)

3. JUnit4 is being used for running tests and creating assertions in tests.

4. It uses different properties file based on execution environment, and @Before hook loads the respective properties file based on environment variable value.

5. It uses pico-container library for dependency injection.

For more, please refer the above link.


## Installation (pre-requisites)

    1. JDK 1.8+ (make sure Java class path is set)
    2. Maven (make sure .m2 class path is set)
    3. Browser either Chrome or Firefox (Latest version)
    
## Framework Setup

    1. git clone https://github.com/sakshidubey/Metyis_Assessment.git
    2. git checkout master
    3. git pull
    
## Running Tests

To run tests, run the following command

  mvn clean install -DskipTests
  mvn test -Denvironment=environment -Dbrowser=browser_name

To run all regression test features on specific browser, use browser_name can be one of following, but make sure that latest browser version is present :

    - firefox
    - chrome

This framework used environment variable value to pick properties file for the execution, which consists information based on environment like URL etc, environment can be one of following :

    - prod (For now, only this environment is configured)
    - dev

Example :  "mvn test -Denvironment=prod -Dbrowser=firefox"


## Execution Report

At the end of the execution, the HTML report will be available on the following path :

    {/ExtentReports/SparkReport_/Reports/Spark.html}

1. For now, screenshots are attached for every steps(Either it is pass or fail).We  can update this functionality just for failure steps.

2. Reports are generated based on timestamp.