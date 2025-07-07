#start with a base image containing java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="arun"

# 3. Set working directory inside the container
WORKDIR /app

# Add the application's jar to the image
COPY target/accounts-v1.jar accounts-v1.jar

# execute the application
ENTRYPOINT ["java", "-jar", "accounts-v1.jar"]