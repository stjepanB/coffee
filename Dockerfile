FROM openjdk:11-jdk-slim
RUN apt-get update
RUN apt-get install -y curl

RUN groupadd normalgroup
RUN useradd -G normalgroup normaluser
USER normaluser:normalgroup

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]