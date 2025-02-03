
FROM openjdk:17-jdk-alpine


WORKDIR /app


COPY target/foodDelivery-0.0.1-SNAPSHOT.jar foodDelivery.jar


EXPOSE 8080


CMD ["java", "-jar", "foodDelivery.jar"]