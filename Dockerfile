FROM gradle:latest AS build
WORKDIR /app
COPY . .
RUN ./gradlew assemble --no-daemon

FROM openjdk:23-slim-bookworm AS runtime
COPY --from=build /app/build/libs/ctcd-0.0.1-SNAPSHOT.jar /app/ctcd-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/ctcd-0.0.1-SNAPSHOT.jar"]