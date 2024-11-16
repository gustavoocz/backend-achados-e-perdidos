# Etapa de build
FROM ubuntu:latest AS build
WORKDIR /app
RUN apt-get update
RUN apt-get install openjdk-17-jdk maven -y
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]