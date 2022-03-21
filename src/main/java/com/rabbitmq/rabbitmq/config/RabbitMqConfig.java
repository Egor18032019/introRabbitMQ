package com.rabbitmq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rabbitmq.rabbitmq.utils.CONST.EXCHANGE_NAME;
import static com.rabbitmq.rabbitmq.utils.CONST.QUEUE_NAME;

@Configuration
public class RabbitMqConfig {
    /*
    Я создал bean-компонент Queue,
    который создаст очередь с именем запуска приложения q.test-queueon.
    первый аргумент — это имя очереди ( q.test-queue ),
    а второй аргумент — это параметр durable,
    для которого установлено значение false,
    что означает, что эта очередь не переживет перезапуск RabbitMQ
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
    /*
        Я создал bean-компонент org.springframework.amqp.core.
        DirectExchange, который будет создавать прямой обмен при запуске приложения.
        Первый аргумент — это имя обменика,
        Второй аргумент — это параметр durable, для которого установлено значение false,
         что означает, что этот обмен не переживет перезапуск RabbitMQ.
        Третий аргумент — параметр автоматического удаления, установленный в false, что означает,
        что этот обмен не будет удален, когда последняя очередь закончит его использовать.
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME, false, false);
    }
    /*
    Наконец, я привязал QUEUE_NAME к EXCHANGE_NAME ,
    где имя очереди QUEUE_NAME используется в качестве ключа маршрутизации.
     */
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).withQueueName();
    }

}