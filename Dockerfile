# Etapa de build
FROM maven:3.8-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jre-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]