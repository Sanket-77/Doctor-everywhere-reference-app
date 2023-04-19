echo "===============>START BUILDING THE APP==============="
echo "===============>Docker Login to AWS ECR==============="
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 318134353397.dkr.ecr.us-east-1.amazonaws.com
echo "===============>Docker Build Appointments==============="
docker build -f appointments.Dockerfile -t 318134353397.dkr.ecr.us-east-1.amazonaws.com/appointments-api:latest .
echo "===============>Docker Build Doctor API==============="
docker build -f doctor-api.Dockerfile -t 318134353397.dkr.ecr.us-east-1.amazonaws.com/doctor-api:latest .
echo "===============>Docker Build Patient API==============="
docker build -f patient-api.Dockerfile -t 318134353397.dkr.ecr.us-east-1.amazonaws.com/patient-api:latest .
echo "===============>Docker Push Appointments==============="
docker push 318134353397.dkr.ecr.us-east-1.amazonaws.com/appointments-api:latest
echo "===============>Docker Push Doctor==============="
docker push 318134353397.dkr.ecr.us-east-1.amazonaws.com/doctor-api:latest
echo "===============>Docker Push Patient==============="
docker push 318134353397.dkr.ecr.us-east-1.amazonaws.com/patient-api:latest
echo "===============>ALL DONE==============="
