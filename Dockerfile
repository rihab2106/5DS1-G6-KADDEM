FROM openjdk:11
EXPOSE 8089
ADD ./target/kaddem-0.0.1-SNAPSHOT.jar 5DS1-G6-KADDEM-1.0.jar
ENTRYPOINT ["java","-jar","/5DS1-G6-KADDEM-1.0.jar"]