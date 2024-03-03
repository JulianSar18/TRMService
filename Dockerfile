FROM openjdk:17-jdk-alpine
ARG JAR_FILE=src/resources/*.jar
COPY ${JAR_FILE} bot.jar
ENTRYPOINT ["java","-jar","/bot.jar"]