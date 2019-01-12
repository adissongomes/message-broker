package br.com.adisson.queue.messaging;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    private AmqpTemplate amqpTemplate;

    public MessagingConfiguration(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
        init(amqpAdmin);
    }

    private void init(AmqpAdmin amqpAdmin) {
        TopicExchange exchange = new TopicExchange("sample-exchange");
        Queue queueA = new Queue("queue-a");
        Queue queueB = new Queue("queue-b");

        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(queueA);
        amqpAdmin.declareQueue(queueB);
        amqpAdmin.declareBinding(BindingBuilder.bind(queueA).to(exchange).with("route.#" ));
        amqpAdmin.declareBinding(BindingBuilder.bind(queueB).to(exchange).with("route.*" ));
    }

    public void send(String message) {
        amqpTemplate.convertAndSend("queue-a", message);
    }

    public void sendToExchange(String message) {
        amqpTemplate.convertAndSend("sample-exchange", "simple", message);
    }


}
