# Demo application using Java Spring Boot Framework and Bootstrap
It contains a Spring Boot back-end with many endpoints. A calculator, a Nasa image viewer using an API Rest, a contact form and a collection of beers using an API Rest.

## Endpoints
### API Rest
* http://localhost:8080/api/v1/library/books
* http://localhost:8080/api/v1/library/readers

### API
* http://localhost:8080/greeting?nombre=Ferran&&edad=28
* http://localhost:8080/customers
* http://localhost:8080/calculator?operation=5*2
* http://localhost:8080/astropic -> optional date search: http://localhost:8080/astropic?date=2021-11-01
* http://localhost:8080/beers
* http://localhost:8080/form

## Windows
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