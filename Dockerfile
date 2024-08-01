FROM ubuntu:latest

LABEL authors="evaldas"

RUN apt-get update &&  \
    apt-get install -y openjdk-21-jdk maven

WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn clean package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]