FROM maven:alpine as builder

COPY ./src /usr/src/app/src
COPY ./pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package


FROM openjdk:alpine

RUN mkdir /app
COPY --from=builder /usr/src/app/target/theater-backend-0.0.1-SNAPSHOT.jar /app/theater-backend.jar

CMD ["java", "-jar", "/app/theater-backend.jar"]