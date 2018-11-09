# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="admin@sensorialsports.com"
LABEL evaluation.version="1.0"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/sensorial-evaluation-queue-0.0.1-SNAPSHOT

# Add the application's jar to the container
ADD ${JAR_FILE} evaluation.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/evaluation.jar"]