FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/5DS1-G6-KADDEM-1.0.jar 5ds1-g6-kaddem-1.0.jar
ENTRYPOINT ["java","-jar","/5ds1-g6-kaddem-1.0.jar"]