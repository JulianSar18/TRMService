FROM openjdk:17-jdk-alpine
COPY "./out/artifacts/bot_jar/bot.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]