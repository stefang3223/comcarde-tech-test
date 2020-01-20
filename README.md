# Comcarde Stock Checker
Made by Stefan Gladkov

## Summary
The project implements a simple REST service that generates advise on what products 
have to be purchase based on a number of rules in the Database. The service is implemented
using Java 8 to filter out products and apply to business logic(rules) and uses an in-memory
database (h2) to persist the advice for future reference. The service also uses the Lombok
library in order to make the code less verbose.

## Assumptions
It is ASSUMED that when there are adhoc orders on products, the system should recommend stock to
both fulfill the order and still have the minimum amount after.

### Database Design
There are 4 tables in the database.
* The main **PRODUCT** table holds all the products in the database and their current quantity
* The **RULE** table holds all the validation rules(min stock/active) for the products.
* The **ADHOC_ORDER** table holds all the orders associated to a given product
* The **PRODUCT_LOG** table holds all the historic advice given to the client

## Dependencies
* Requires Java8
* Requires Maven3

## How to run
```
# To build & run tests
mvn clean install

# To Run
mvn spring-boot:run
```

# To test
By default, the project runs on localhost:8080, after running it, 
you can use your browser and navigate to [THIS LINK](http://localhost:8080/api/product/status)

To explore the in-memory database, you can navigate to [THIS LINK](http://localhost:8080/h2-console)

# Future extensions
Given more time, it would probably be useful to have resources and repositories to do CRUD operations on products, rules and orders.
