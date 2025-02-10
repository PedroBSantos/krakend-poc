FROM maven:3.9.9-eclipse-temurin-23-alpine AS build
WORKDIR /app/
COPY . .
RUN mvn dependency:list install package -DskipTests

FROM eclipse-temurin:23.0.2_7-jre-alpine AS final
EXPOSE 8080
WORKDIR /app/
COPY --from=build /app/target/orders-0.0.1-SNAPSHOT.jar orders.jar
ENTRYPOINT exec java -jar orders.jar