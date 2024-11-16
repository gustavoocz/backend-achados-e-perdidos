# Etapa de build
FROM amazoncorretto:21 AS build
WORKDIR /app
COPY . .
RUN yum install maven -y
RUN mvn clean package -DskipTests

# Etapa de execução
FROM amazoncorretto:21
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]