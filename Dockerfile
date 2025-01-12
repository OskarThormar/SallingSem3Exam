# Brug Maven til at bygge projektet med Java 21
FROM maven:3.9.4-eclipse-temurin AS build
WORKDIR /app

# Kopier pom.xml og src ind i containeren
COPY pom.xml .
COPY src ./src

# Download afhængigheder og byg applikationen uden at køre tests
RUN mvn clean package -Dmaven.test.skip=true


# Brug en letvægts Java 21-runtime
FROM eclipse-temurin:21-jre
WORKDIR /app

# Kopier den færdige JAR-fil fra build-stadiet
COPY --from=build /app/target/*.jar app.jar

# Eksponer port 8080
EXPOSE 8080

# Start applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]
