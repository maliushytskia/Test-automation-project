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
- [Setting up machine to run GUI autotests](#setting-up-machine-to-run-gui-autotests)
- [How to run tests](#how-to-run-tests)
- [Reports](#reports)
- [CI Process](#ci-process)

# Requirements
- [Java](https://www.oracle.com/pl/java/technologies/downloads/#java21) programming language to be installed on machine - 21v
- [Docker](https://docs.docker.com/desktop/) to run CI/CD via Jenkins

# Quick start
1. Download project or clone the git repository;
2. Install all required packages and dependencies with Maven
```sh
mvn clean install
```
Now all required dependencies should be stored in project and it makes it possible to go to set up.

# Difference between API and GUI autotests
While API autotests use only HTTP client to interact with application, GUI autotests is a simulation of user actions with the application interface.

* To run **ui** test set execute in console:
```sh
mvn test -Dgroups="ui"
```

* To run **api** test set execute in console:
```sh
mvn test -Dgroups="api"
```

# CI Process
