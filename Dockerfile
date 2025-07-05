FROM maven:3.9.9-amazoncorretto-17 AS BUILD
WORKDIR /cine_connecta
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM maven:3.9.9-amazoncorretto-17 AS RUN
WORKDIR /cine_connecta
COPY --from=BUILD /cine_connecta/target/*.jar ./cine-connecta.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cine-connecta.jar"]

