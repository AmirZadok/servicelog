#FROM openjdk:8-jdk-alpine
#WORKDIR /app
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#USER node
#ENV PORT=80
#EXPOSE 80
#ENTRYPOINT ["java","-jar","/app.jar"]
# syntax=docker/dockerfile:1

# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]