"# introRabbitMQ" 
Начал изучать RabbitMQ
- docker pull rabbitmq
- docker run -d --name intro-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
5672 — это стандартный порт RabbitMQ, который будет отображаться как 5672 на вашем компьютере.
15672 — это порт, используемый подключаемым модулем управления RabbitMQ, 
docker start intro-rabbit


  