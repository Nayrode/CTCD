FROM gradle:latest AS build
WORKDIR /home/gradle/project
COPY . /home/gradle/project
RUN ./gradlew assemble

FROM openjdk:17-jdk-slim AS runtime
COPY --from=build /home/gradle/project/build/libs/ctcd-0.0.1-SNAPSHOT.jar /app/ctcd-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/ctcd-0.0.1-SNAPSHOT.jar"]