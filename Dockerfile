# Estágio de compilação
FROM maven:4.0.0-alpha-12-amazoncorretto-21 AS build
WORKDIR /app

# Copia apenas o pom.xml primeiro para cachear as dependências
COPY pom.xml .

# Download das dependências
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila a aplicação
RUN mvn clean package -DskipTests

# Estágio de execução
FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

# Cria um usuário não-root
RUN addgroup -S spring && adduser -S spring -G spring

# Copia o jar construído do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Define a propriedade para o usuário não-root
RUN chown spring:spring app.jar

# Muda para o usuário não-root
USER spring

# Adiciona configuração JVM para contêineres
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Define o ponto de entrada com opções Java configuráveis
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

# Expõe a porta padrão do Spring Boot
EXPOSE 8080