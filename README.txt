## Starting the application
# To create the Jar file
$ mvn clean package
# To start the application using port 8181
$ java -jar target/*.jar  --server.port=8181

## Starting the DB
$ mongod  --dbpath /opt/orbitz/db

