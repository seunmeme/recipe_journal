FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim

VOLUME /tmp

EXPOSE 9000

ADD target/recipes-journal-0.0.1-SNAPSHOT.jar recipes-journal-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "recipes-journal-0.0.1-SNAPSHOT.jar"]