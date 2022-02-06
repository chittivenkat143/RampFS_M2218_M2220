FROM adoptopenjdk/openjdk11 as builder
WORKDIR hcl-eureka-services
EXPOSE 8761
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hcl-eureka-services.jar
RUN java -Djarmode=layertools -jar hcl-eureka-services.jar extract

FROM adoptopenjdk/openjdk11
WORKDIR hcl-eureka-services
COPY --from=builder hcl-eureka-services/dependencies/ ./
COPY --from=builder hcl-eureka-services/spring-boot-loader/ ./
COPY --from=builder hcl-eureka-services/snapshot-dependencies/ ./
COPY --from=builder hcl-eureka-services/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
