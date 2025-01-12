# Trin 1: Brug Maven med Java 21 til at bygge projektet
FROM maven:3.8.4-openjdk-21 AS build
WORKDIR /app

# Kopier kun pom.xml først for at cache afhængigheder
COPY pom.xml .

# Download afhængigheder og cache dem
RUN mvn dependency:go-offline -DskipTests

# Kopier resten af koden ind i containeren
COPY src ./src

# Byg applikationen
RUN mvn clean package -DskipTests

# Trin 2: Brug en letvægts Java 21-image til at køre appen
FROM openjdk:21-jdk-slim
WORKDIR /app

# Kopier den færdige JAR-fil fra build-stadiet
COPY --from=build /app/target/*.jar app.jar

# Eksponer port 8080
EXPOSE 8080

# Start applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]
