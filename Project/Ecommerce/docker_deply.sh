mvn clean package -P test

docker build -t ecommerce-server .
docker image tag ecommerce-server:latest javaethio/ecommerce-server:latest
docker image push javaethio/ecommerce-server:latest
