FROM eclipse-temurin:21-jdk-jammy

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY target/backend-achados-e-perdidos-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação usa
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]