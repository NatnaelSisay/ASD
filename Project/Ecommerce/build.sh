# make sure mysql is running, look at application-*.properties for reference
#docker container kill $(docker ps -aq)
docker run -e POSTGRES_PASSWORD=examplepassword -p 5432:5432 -d postgres

mvn clean package -P prod

docker build -t ecommerce-server .

# push the image to the registry
#docker tag ecommerce-server:latest javaethio/ecommerce-server:latest
#docker push javaethio/ecommerce-server:latest
#
#docker-compose up -d --build
