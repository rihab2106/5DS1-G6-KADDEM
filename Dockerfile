# Use a specific version of OpenJDK as the base image
FROM openjdk:11

# Expose the port that your Java application listens on
EXPOSE 8082

# Copy your application JAR file into the Docker image
ADD target/kaddem-1.0.jar /kaddem-devops-1.0.jar

# Define the command to run your Java application when the container starts
ENTRYPOINT ["java", "-jar", "/kaddem-devops-1.0.jar"]
