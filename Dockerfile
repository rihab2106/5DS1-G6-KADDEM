FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/devops-1.0.jar test-docker.jar
ENTRYPOINT ["java","-jar","/test-docker.jar"]