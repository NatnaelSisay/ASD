# make sure mysql is running, look at application-*.properties for reference

mvn clean package -P prod

docker build -t ecommerce_server .

# push the image to the registry

docker-compose up -d --build
