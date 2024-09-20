# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
ADD ./target/biblioteca-0.0.1-SNAPSHOT.jar biblioteca.jar
ENTRYPOINT ["java", "-jar", "/biblioteca.jar"]