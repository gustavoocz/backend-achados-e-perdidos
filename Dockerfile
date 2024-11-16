# Etapa de build usando Maven
FROM maven:3.9-openjdk-21 as build
WORKDIR /app
COPY . /app
RUN mvn clean install

# Etapa de execução com OpenJDK
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/backend-achados-e-perdidos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
