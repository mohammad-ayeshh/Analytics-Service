FROM openjdk:17-jdk

VOLUME /tmp

ARG JAR_FILE=target/Analytics-Service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
