# Demo API REST application using Java Spring Boot Framework and Bootstrap
It contains a Spring Boot back-end with many endpoints. A calculator, a Nasa image viewer using an API Rest, a contact form and a collection of beers using an API Rest.

## API Rest
There is a PostMan collection file exported in root folder. You can import to easily testing beers and library API.

### Beers
#### Swagger documentation: 
* http://localhost:8080/doc/beers.html
#### Endpoints
* http://localhost:8080/api/v1/beers/
* http://localhost:8080/api/v1/pubs/
* http://localhost:8080/api/v1/purchases/

### Library
#### Swagger documentation: 
* http://localhost:8080/doc/library.html
#### Endpoints
* http://localhost:8080/api/v1/books/
* http://localhost:8080/api/v1/readers/
* http://localhost:8080/api/v1/transaction/
* http://localhost:8080/api/v1/libraries/

## API
### Endpoints
* http://localhost:8080/greeting?nombre=Ferran&&edad=28
* http://localhost:8080/customers
* http://localhost:8080/calculator?operation=5*2
* http://localhost:8080/astropic -> optional date search: http://localhost:8080/astropic?date=2021-11-01
* http://localhost:8080/beers
* http://localhost:8080/form

## How to run in Windows
Install scoop or cholocatey in Windows to easily the process.

### Instalar OpenJDK:
* scoop install openjdk17
* choco install openjdk17

to verify use command: javac --version

### Install Maven
* scoop install maven
* choco install maven

to verify use command: mvn --version

## Run:
* Execute this order in root project folder -> .\mvnw spring-boot:run
* Maven cleaning -> mvn clean