ARG MVN_VERSION=3.8.6
ARG JDK_VERSION=11
ARG MAVEN_TOOL_CHAIN_CACHE

FROM maven:${MVN_VERSION}-jdk-${JDK_VERSION}-slim as MAVEN_TOOL_CHAIN_CACHE
WORKDIR /build
COPY pom.xml .
COPY src ./src/
COPY appointments-api ./appointments-api/
COPY doctor-api ./doctor-api/
COPY patient-api ./patient-api/

RUN mvn dependency:go-offline
RUN mvn clean package --quiet -DskipTests --batch-mode --fail-fast --no-transfer-progress

FROM public.ecr.aws/lambda/java:11
# Copy function code and runtime dependencies from Maven layout
#COPY target/classes ${LAMBDA_TASK_ROOT}
#COPY target/dependency/* ${LAMBDA_TASK_ROOT}/lib/

COPY --from=MAVEN_TOOL_CHAIN_CACHE /build/doctor-api/target/ ${LAMBDA_TASK_ROOT}

#COPY --from=MAVEN_TOOL_CHAIN_CACHE --chown=nonroot:nonroot /build/target/ /
#COPY --from=MAVEN_TOOL_CHAIN_CACHE /build/doctor-api/target/ /
EXPOSE 9092

ENV _JAVA_OPTIONS "-XX:MinRAMPercentage=60.0 -XX:MaxRAMPercentage=90.0 \
-Djava.security.egd=file:/dev/./urandom \
-Djava.awt.headless=true -Dfile.encoding=UTF-8 \
-Dspring.output.ansi.enabled=ALWAYS \
-Dspring.profiles.active=default"

#ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD ["com.automationfraternity.StreamLambdaHandler::handleRequest"]
