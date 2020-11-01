package com.aws.sqs.sub;

import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonSubscriber {

    @SqsListener(value = "${cloud.aws.sqs.queue.url}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessageSentFromQueue(Person person) {
        System.out.println("\n\nMessage Recieved from queue: " + person);
    }

    @SqsListener(value = "${cloud.aws.sqs.topic.queue.url}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessageSentFromTopic(@NotificationMessage Person person) {
        System.out.println("\n\nMessage Recieved from topic: " + person);
    }

}
