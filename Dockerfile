FROM java:8-jre
MAINTAINER AV

ADD ./target/forum-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/forum-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
