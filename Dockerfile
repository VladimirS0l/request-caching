FROM openjdk:17
WORKDIR /opt
COPY build/libs/*.jar request-caching.jar
CMD ["java", "-jar", "request-caching.jar"]
