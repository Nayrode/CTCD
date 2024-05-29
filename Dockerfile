FROM openjdk:17 as ctcd-api
COPY . .
WORKDIR .
RUN ./gradlew assemble
ENTRYPOINT ["java", "-jar", "./build/libs/ctcd-0.0.1-SNAPSHOT.jar"]