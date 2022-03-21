package com.rabbitmq.rabbitmq.consumer;

import com.rabbitmq.rabbitmq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.rabbitmq.rabbitmq.utils.CONST.QUEUE_NAME;


@Slf4j
@Service
public class Consumer {
/*
Consumer слушает очередь QUEUE_NAME
его обязанность — принять сообщение из очереди и зарегистрировать его
 */
    @RabbitListener(queues = {QUEUE_NAME})
    public void consume(Message message) {
        log.info("Received message [{}]", message);
    }

}