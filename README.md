# Product Service

This is a product service built with **Java Spring Boot** as the backend, **MySQL** as the persistent database, **Redis** for caching, and **AWS S3** for image storage. The service allows users to create and retrieve all products with pagination.

## Architecture

### Technologies
- **Backend**: Java Spring Boot
- **Database**: MySQL
- **Caching**: Redis
- **Storage**: AWS S3 (for product images)
- **Containerization**: Docker

### Key Functionalities
- **Get All Products**: Returns paginated results of all products.
- **Save Product**: Saves a product along with its image to AWS S3.

### Caching
- Utilizes Redis to cache the results of the `getAllProducts` method, improving response times for frequently accessed data.

## Running the Application

To run the application, follow these steps:
1. **Pull the docker image**:
    - docker pull sonofcars/product-spring-app:v1.0.1
2. **Run Docker Compose:**:
    - docker-compose up

## Testing
Open Postman and import the workspace for testing the product service:  
[Navigate to Postman Workspace](https://www.postman.com/sonofcars/product-service-sonofcars/request/3ykl2gq/localhost-8090-products)

Enjoy my Ever Never Best Wundebar Product-Service project!

## POSTMAN
![Postman](https://github.com/HasanKarslioglu/auth-service/blob/master/images/Postman.png?raw=true)
![Postman](https://github.com/HasanKarslioglu/auth-service/blob/master/images/Postman2.png?raw=true)
## MYSQL
![Mysql](https://github.com/HasanKarslioglu/auth-service/blob/master/images/Mysql.png?raw=true)
## REDIS
![Redis](https://github.com/HasanKarslioglu/auth-service/blob/master/images/Redis.png?raw=true)
## AWS S3
![AwsS3](https://github.com/HasanKarslioglu/auth-service/blob/master/images/S3.png?raw=true)

