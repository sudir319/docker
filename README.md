# docker
Download docker-compose.yml to a directory and run "docker-compose up" in the same directory
To test the currency conversion, use below links
  1. http://localhost:8080/currency_exchange/get_exchange_value/USD/INR : To fetch the exchange rates from mysql database
  2. http://localhost:8081/currency_conversion/get_conversion_value/USD/INR/10.25 : To fetch the exchange rates from above url, calculate the exchange value for the given amount(10.25)

# applications
mysql-docker-image folder contains initial script and along with the Dockerfile that can be used to build the custom mysql image with the initial data.
currency-exchange-service has the logic to connect to mysql server and fetch the exchange rates.
currency-conversion-service has the logic to connect to currency-exchange-service and fetch the rate and calucate the exchange value for the given amount.

When testing these spring applications inside IDE, the application.properties must be changed to point to localhost instead of docker-mysql and currency-exchange-service, considering the docker-mysql container is running inside the docker

# building images

cd <path to>/mysql-docker-image
  docker build -f Dockerfile -t docker_mysql .


cd ../currency-exchange-service 
  mvn clean install package -DskipTests=true 
  docker build -f Dockerfile -t currency_exchange_service .


cd ../currency-conversion-service 
  mvn clean install package -DskipTests=true 
  docker build -f Dockerfile -t currency_conversion_service .
