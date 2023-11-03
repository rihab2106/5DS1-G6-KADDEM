FROM openjdk:11
EXPOSE 8089
ADD ./target/5BI6-G3-Kaddem-1.0.jar 5bi6-g3-kaddem-1.0.jar
ENTRYPOINT ["java","-jar","/5bi6-g3-kaddem-1.0.jar"]