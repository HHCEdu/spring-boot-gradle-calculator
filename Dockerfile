FROM openjdk:11-jre
COPY build/libs/spring-boot-gradle-calculator-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]