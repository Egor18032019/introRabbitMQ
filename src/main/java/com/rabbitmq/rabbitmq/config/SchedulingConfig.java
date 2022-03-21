package com.rabbitmq.rabbitmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
// можно добавить @EnableScheduling в основной класс приложения Spring Boot — результат будет таким же
/* или
@EnableAutoConfiguration
@ComponentScan
@Import(RabbitConfiguration.class)
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
}