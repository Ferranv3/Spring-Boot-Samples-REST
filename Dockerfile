FROM maven as builder
COPY . /app
RUN cd /app && mvn package
FROM openjdk:11
COPY --from=builder /app/target/*.jar /opt/app.jar
CMD java -jar /opt/app.jar