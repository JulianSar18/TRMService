FROM gradle:7.6-jdk  AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build --no-daemon

# actual container
FROM openjdk:17-jdk-alpine
RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/bot-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]