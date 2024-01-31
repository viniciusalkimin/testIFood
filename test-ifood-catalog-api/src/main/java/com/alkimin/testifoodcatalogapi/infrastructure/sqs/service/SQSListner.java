package com.alkimin.testifoodcatalogapi.infrastructure.sqs.service;

import com.alkimin.testifoodcatalogapi.application.catalog.usecase.ProcessarCatalog;
import com.alkimin.testifoodcatalogapi.infrastructure.sqs.dto.CatalogPublishedRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Component
@Slf4j
public class SQSListner {

    private ProcessarCatalog processarCatalog;

    @SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(@NotificationMessage CatalogPublishedRecord message) {
        log.info("SQS Message Received : {}", message);
        processarCatalog.execute(message.ownerId());
    }
}
