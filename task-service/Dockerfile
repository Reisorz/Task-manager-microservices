# BUILD APPLICATION AND CREAT ROOT DIR
FROM maven:3.9.2-eclipse-temurin-21 AS build
WORKDIR /app

# COPY DEPENDENCIES FILE (pom.xml) AND THEN THE REST OF THE CODE
COPY pom.xml .
COPY src ./src

# COMPILE AND PACK THE APPLICATION
RUN mvn clean package -DskipTests



# FINAL IMAGE
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# COPY THE CREATED JAR AND RENAMES IT
COPY --from=build /app/target/*.jar app.jar

# PORT
EXPOSE 8082

# STARTS APPLICATION
ENTRYPOINT ["java", "-jar", "app.jar"]
