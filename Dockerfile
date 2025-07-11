FROM openjdk:17-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -DskipTests

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build target/*.jar todoapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "todoapp.jar"]