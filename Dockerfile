# Use Maven with JDK 21 for the build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# Use lightweight JDK 21 for runtime
FROM eclipse-temurin:21-jdk   

WORKDIR /app
COPY --from=build /app/target/Job-Portal-0.0.1-SNAPSHOT.jar Job-Portal.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","Job-Portal.jar"]
