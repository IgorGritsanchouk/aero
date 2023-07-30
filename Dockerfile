FROM openjdk:17-jdk-slim
ADD ./target/aero-0.0.1-SNAPSHOT.jar aero.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "aero.jar"]