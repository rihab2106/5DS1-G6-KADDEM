#FROM openjdk:11
#EXPOSE 8089
#ADD ./target/5DS1-G6-KADDEM-1.0.jar 5ds1-g6-kaddem-1.0.jar
#ENTRYPOINT ["java","-jar","/5ds1-g6-kaddem-1.0.jar"]
FROM openjdk:8
EXPOSE 8089
ADD target/devops-integration.jar devops-integration.jar
ENTRYPOINT ["java","-jar","/devops-integration.jar"]