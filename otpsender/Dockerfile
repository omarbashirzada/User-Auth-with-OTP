FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/otpsender-*.jar /app/otpsender.jar

RUN ["chmod", "+x", "/app/otpsender.jar"]

CMD ["java", "-jar", "/app/otpsender.jar"]