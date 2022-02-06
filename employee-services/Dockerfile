FROM adoptopenjdk/openjdk11 as builder
EXPOSE 8085
WORKDIR employee-services
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employee-services.jar
RUN java -Djarmode=layertools -jar employee-services.jar extract

FROM adoptopenjdk/openjdk11
WORKDIR employee-services
COPY --from=builder employee-services/dependencies/ ./
COPY --from=builder employee-services/spring-boot-loader/ ./
COPY --from=builder employee-services/snapshot-dependencies/ ./
COPY --from=builder employee-services/application/ ./
ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]