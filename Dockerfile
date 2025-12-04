FROM openjdk:21-ea-1-jdk-slim

LABEL author=stanleyvladimir2005@gmail.com

COPY "./build/libs/mediappbd-backend-0.0.1-SNAPSHOT.jar" "app.jar"

ENTRYPOINT ["java", "-jar", "/app.jar"]