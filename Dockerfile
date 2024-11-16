# Etapa de build
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install maven -y
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jre-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]