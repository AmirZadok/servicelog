FROM openjdk:8-jdk-alpine

ENV PORT=80
EXPOSE 80
RUN mkdir /logs
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["/bin/sh"]
ENTRYPOINT ["java","-jar","/app.jar"]
