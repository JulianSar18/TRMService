FROM openjdk:17-jdk-alpine
COPY ./src/resources/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]