FROM public.ecr.aws/lambda/java:11

COPY doctor-api/target/classes ${LAMBDA_TASK_ROOT}
COPY doctor-api/target/dependency/* ${LAMBDA_TASK_ROOT}/lib/
CMD [ "com.automationfraternity.MyStreamHandler::handleRequest" ]
