FROM maven:3.8.6-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-ea-10-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build ./app/target/*.jar ./backend-achados-e-perdidos-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT java -jar backend-achados-e-perdidos-0.0.1-SNAPSHOT.jar.jar

