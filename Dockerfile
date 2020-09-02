FROM gradle:6.5.0-jdk11 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -info

FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
COPY --from=build /home/gradle/src/safekeeping.runner/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]