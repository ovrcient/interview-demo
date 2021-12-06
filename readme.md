# Homework

Back End Java Developer

## Homework Requisites

- All candidates who are a fit for this role will be required to do a homework problem before any interviews.
- This will be the basis for the first client interview.
- Your solution must be coded in Java and use Spring Boot.

## Problem Statement

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent
over $50 in each transaction.

Source: <del>```e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points```<del>

Proposal: ```e.g. a $120 purchase = 2x$20 + 1x$70 = 110 points```

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer
per month and total.

## Instructions & Usage

```shell
# Download code from repository
git clone https://github.com/rodrigoieh/pub-interview-demo

# Execute
mvn spring-boot:run

# If mvn is not installed in local environment 
mvnw spring-boot:run
```

## Endpoints

### Development Toolkit

- [H2 Datastore][endpoint-h2]
- [Swagger UI][endpoint-swagger-gui]
- [Swagger API Docs][endpoint-swagger]
- [Spring Actuator][endpoint-actuator]

### API

- [customers][api-customer]
- [transactions][api-transaction]
- [rewards][api-reward]

## To-do

### Technical Notes and Architecture

- [x] Code your solution in Java and Spring.
- [x] Make up a data set to best demonstrate your solution.
- [x] Use OOP concepts as much as possible when designing classes.
- [x] Swagger/OpenAPI (Optional) - helps communicate the contract in a better way.
- [x] Document all response codes expected.
- [x] The REST API should be sending the appropriate code and not always 200.
- [ ] Functional Programming constructs of Java 8 as appropriate.
- [ ] Generic exception handler for un-anticipated exceptions.
- [ ] Assume that the client will look at your commit history, so it should reflect a good project progression.

### Additional Requirements

- [ ] Follow standard best practices for structuring the code.
- [x] Prepare and provide Test Data along with the code.
- [ ] Both positive and negative unit test cases for all operations – to be run as part of the build process.
- [x] Implement RestAPI’s for all CRUD operations – in this case – creating/updating transactions, calculating and
  providing reward information for a User. (Java Backend/Full Stack).
- [ ] Consistent error handling and reporting of all failures including unexpected error conditions.
- [x] Use of appropriate logging levels, framework.
- [ ] Reward calculation logic should be accurate.
- [x] Readme file is mandatory – must contain the steps required to build and run/test the code
- [x] The solution must be checked into GitHub (provide a public GitHub url).

### Submission

- [x] Check solution into GitHub.
- [x] Send email with the public GitHub URL.

### Extras

- [x] Maven enabled project, for dependencies and plugins management.
- [x] Maven wrapper enabled, runs in standalone mode and does not require mvn installed and configured in testing
  machine for evaluation. Command ```mvn -N io.takari:maven:wrapper```
- [x] Spring actuator for management and monitoring (health, loggers, beans, *)

---

<!--
Version:   1.0.0
Update:    06/12/2021
Contact:   rodrigoerazo@gmail.com
Developer: Rodrigo Erazo Hermosilla
-->

[//]: <> (Endpoints: API)

[api-customer]: http://localhost:8080/api/customers

[api-transaction]: http://localhost:8080/api/transactions

[api-reward]:  http://localhost:8080/api/rewards

[//]: <> (Endpoints: Toolkit)

[endpoint-h2]:  http://localhost:8080/h2

[endpoint-swagger]: http://localhost:8080/api/v2/api-docs

[endpoint-swagger-gui]: http://localhost:8080/api/swagger-ui.html

[endpoint-actuator]: http://localhost:9000/actuator

[endpoint-actuator-auditevents]: http://localhost:9000/actuator/auditevents

[endpoint-actuator-autoconfig]: http://localhost:9000/actuator/autoconfig

[endpoint-actuator-beans]: http://localhost:9000/actuator/beans

[endpoint-actuator-configprops]: http://localhost:9000/actuator/configprops

[endpoint-actuator-dump]: http://localhost:9000/actuator/dump

[endpoint-actuator-env]: http://localhost:9000/actuator/env

[endpoint-actuator-flyway]: http://localhost:9000/actuator/flyway

[endpoint-actuator-health]: http://localhost:9000/actuator/health

[endpoint-actuator-info]: http://localhost:9000/actuator/info

[endpoint-actuator-loggers]: http://localhost:9000/actuator/loggers

[endpoint-actuator-liquibase]: http://localhost:9000/actuator/liquibase

[endpoint-actuator-metrics]: http://localhost:9000/actuator/metrics

[endpoint-actuator-mappings]: http://localhost:9000/actuator/mappings

[endpoint-actuator-shutdown]: http://localhost:9000/actuator/shutdown

[endpoint-actuator-trace]: http://localhost:9000/actuator/trace
