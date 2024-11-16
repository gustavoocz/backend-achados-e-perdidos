# Use the official Maven image to build the application
FROM maven:4.0-openjdk-21 as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the src folder into the container
COPY pom.xml .
COPY src /app/src

# Build the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK 21 image to run the application
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the build image
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]
