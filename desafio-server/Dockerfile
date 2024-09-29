#imagem do jdk
FROM openjdk:21-jdk-slim

WORKDIR /app
#copia o jar gerado pelo maven
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


