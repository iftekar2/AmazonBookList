FROM amazoncorretto:17-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/amazonbooklist_spring-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]