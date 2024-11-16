# Use uma imagem oficial do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo jar da aplicação para o container
COPY --from=build /target/backend-achados-e-perdidos-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação Java
ENTRYPOINT ["java", "-jar", "app.jar"]

# Exponha a porta que a aplicação vai rodar (se necessário)
EXPOSE 8080

