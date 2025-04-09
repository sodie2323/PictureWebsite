package com.yupi.yupicturebackend.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(Object message) {
        rabbitTemplate.convertAndSend(MqConstant.BI_EXCHANGE_NAME, MqConstant.BI_ROUTING_KEY, message);
    }

}
