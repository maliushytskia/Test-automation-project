# Ecommerce-playground.lambdatest.io - test automation framework

Project to run GUI / API tests in Java / Selenium stack

# Features
- Simple set up
- Supports BDD format
- Built-in report
- CI/CD integration

# Table of content:
- [Requirements](#requirements)
- [Quick start](#quick-start)
- [Difference between API and GUI autotests](#difference-between-api-and-gui-autotests)
- [How to run tests](#how-to-run-tests)
- [Reports](#reports)
- [CI Process](#ci-process)
- [Used technologies](#used-technologies)

# Requirements
- [Java](https://www.oracle.com/pl/java/technologies/downloads/#java21) programming language to be installed on machine - 21v
- Set up Java environment variables for Java to run tests locally
- [Docker](https://docs.docker.com/desktop/) to run CI/CD via Jenkins
- Docker image can be built using Dockerfile located in the root of the project or downloaded from [Docker repository](https://hub.docker.com/r/vegarduss/ubuntu_jenkins_chrome_allure)

# Quick start
1. Download project or clone the git repository;
2. Install all required dependencies with Maven
```sh
mvn clean install
```
3. Download Docker image from Docker repository or make image yourself from Dockerfile using the following command from project root folder:
```
docker build -t ubuntu_jenkins_chrome_allure - to create Docker Image
```
```
docker run -d -p 8080:8080 -p 50000:50000 --name jenkins_allure ubuntu_jenkins_chrome_allure - to run Docker container using created of downloaded Docker image
```
4. Now Jenkins is available locally in browser via  "http://localhost:8080" address
5. No get initial Jenkins password run:
```sh
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

Now all required dependencies should be stored in project and it makes it possible to go to set up.

# How to run tests
While API autotests use only HTTP client to interact with application, GUI autotests is a simulation of user actions with the application interface.

* To run **ui** test set execute in console:
```sh
mvn test -Dgroups="ui"
```

* To run **api** test set execute in console:
```sh
mvn test -Dgroups="api"
```

* To run **all** tests execute in console:
```sh
mvn test
```

* To run **UI** tests in different browsers in console:
```sh
mvn test -Dbrowser=firefox -Dgroups="ui"
```
Available browsers to set:
- Chrome;
- Firefox;
- Edge.

* To run **UI** tests in headless mode in console:
```sh
mvn test -Dbrowser=chrome -Dheadless=true -Dgroups="ui"
```
Test suite to be run without browser opening where tests interact directly with DOM tree 

Also tests can be run via development shell functionality and via Jenkins pipeline

# CI Process
Autotests are not triggered each time when commit is made into the project. This is done because of no need.
Instead of it, trigger works from Jenkins pipeline.

Jenkins configuration is available in Docker Container locally.

# Reports
Command ```mvn allure:serve``` is actually generates HTML report right after test run ```mvn clean test```.
Or it can be automatically generated in Jenkins pipeline after test run.

Screenshots are generated automatically for failed UI tests in **artifacts** package.

Logging is implemented using **Log4J**. A Log file is stored in the project **artifacts** folder.

# Used technologies
- Java 21
- Maven
- Selenium
- Cucumber
- JUnit5 Jupiter
- Rest Assured
- Allure Report
- Jenkins
- Docker
- Log4J

