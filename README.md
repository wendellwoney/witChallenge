# WIT Recruitment Challenge - JAVA Developer
Este challenge tem como objectivo a avaliação de Java developers candidatos à WIT. Este challenge pretende avaliar
as capacidades dos candidatos em desenvolver uma tarefa num espaço de tempo definido.

## Clone Project

```sh
git clone https://github.com/wendellwoney/witChallenge.git
```

## Folder Structure

    .
    ├── calculator         # Structure responsible for calculating the operations sent by the rest
    ├── queue              # Structure responsible for connecting and sending messages to rabbitmq
    ├── rest               # Structure responsible for exposing the endpoints to perform operations
    ├── docker-compose.yml # Docker RabbitMq
    └── ...

## Dependencies
* Spring 2.6.9
* Java Version 17
* Swagger 2
* Logback
* Lombok

## Configuring Project
rest.properties
```
api.path=/rest                                             *API PATH*
server.port=8080                                           *SERVER PORT*
spring.rabbitmq.listener.direct.prefetch=5                 *RABBITMQ PREFETCH*
spring.rabbitmq.listener.type=direct                       *RABBITMQ TYPE LISTENER*
request.timer.wait.response=1000                           *TIMER FOR WAIT RESULT*
springfox.documentation.swagger-ui.base-url=/documentation *UI BASE SWAGGER*
```

queue.properties
```
spring.rabbitmq.host=localhost     *RABBITMQ HOST*
spring.rabbitmq.port=5672          *RABBITMQ PORT*
spring.rabbitmq.username=admin     *RABBITMQ USER*
spring.rabbitmq.password=123456    *RABBITMQ PASSWORD*

rabbitmq.exchange=witchallenge     *RABBITMQ EXCHANGE*
rabbitmq.queue.operation=operation *RABBITMQ QUEUE OPERATION*
rabbitmq.queue.result=result       *RABBITMQ QUEUE RESULT*
```

calculator.properties
```
server.port=8081                           *SERVER PORT*
spring.rabbitmq.listener.direct.prefetch=2 *RABBITMQ PREFETCH*
spring.rabbitmq.listener.type=direct       *RABBITMQ TYPE LISTENER*
arbitrary.precission=5                     *ARBITRATY PRECISSION* 
arbitrary.scale=4                          *ARBITRATY SCALE* 
``` 

docker-compose.yml
```dockerfile
services:
  rabbitmq:
    image: rabbitmq:3-management
    container_name: rabbitmq
    restart: always
    ports:
      - 5672:5672
      - 15672:15672
    volumes:
      - ./mqdata:/var/lib/rabbitmq/
    environment:
      - RABBITMQ_DEFAULT_USER=admin
      - RABBITMQ_DEFAULT_PASS=123456
```

## Run Project
* Acess folder rest and run *com.wendellwoney.rest.RestApplication*
  * The aplication will start on port 8080: http:localhost:8080
* Acess folder rest and run *com.wendellwoney.calculator.CalculatorApplication*
  * The aplication will start on port 8081: http:localhost:8081
* Run RabbitMQ
  * docker-compose up -d


## Api Documentation
```
http://localhost:8080/documentation/swagger-ui/index.html#/Operations
```