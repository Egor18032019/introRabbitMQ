package com.rabbitmq.rabbitmq.producer;

import com.rabbitmq.rabbitmq.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static com.rabbitmq.rabbitmq.utils.CONST.EXCHANGE_NAME;
import static com.rabbitmq.rabbitmq.utils.CONST.QUEUE_NAME;


@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;
//    каждые 5 секунду новое сообщение будет отправляться на обменик EXCHANGE_NAME с ключом маршрутизации QUEUE_NAME
    @Scheduled(fixedDelay = 5000)
    public void sendMessage() {
        Message msg = new Message();
        msg.setMsg("Message from " + LocalDateTime.now());
//        rabbitTemplate.convertAndSend(EXCHANGE_NAME, QUEUE_NAME, msg);
        //можно не указывать обменик если уже забиндили его в RabbitMqConfig
        rabbitTemplate.convertAndSend(QUEUE_NAME, msg);
        log.info("Message with id [{}] send to [{}] exchange with routing key [{}]", msg.getId(), EXCHANGE_NAME, QUEUE_NAME);
    }

}