FROM openjdk:11
EXPOSE 8089
COPY ./target/kadddem-0.0.1-SNAPSHOT.jar kadddem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","kadddem-0.0.1-SNAPSHOT.jar"]