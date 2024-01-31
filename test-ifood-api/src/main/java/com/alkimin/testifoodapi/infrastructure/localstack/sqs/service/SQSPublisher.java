package com.alkimin.testifoodapi.infrastructure.localstack.sqs.service;


import com.alkimin.testifoodapi.infrastructure.category.dto.CatalogPublishRecord;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class SQSPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSPublisher.class);

    private AmazonSQS amazonSQS;
    private ObjectMapper objectMapper;

    private static final String QUEUE_URL = "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/catalog_emit.fifo";

    public void publishEvent(CatalogPublishRecord catalogPublish) {
        try {
            var message = objectMapper.valueToTree(catalogPublish);
            var sendMessageRequest = new SendMessageRequest().withQueueUrl(QUEUE_URL)
                    .withMessageBody(objectMapper.writeValueAsString(message))
                    .withMessageDeduplicationId(UUID.randomUUID().toString())
                    .withMessageGroupId("Catalog");

            amazonSQS.sendMessage(sendMessageRequest);
            LOGGER.info("Event has been published in SQS.");
        } catch (JsonProcessingException e) {
            LOGGER.error("JsonProcessingException e : {} and stacktrace : {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception ocurred while pushing event to sqs : {} and stacktrace ; {}", e.getMessage(), e);
        }

    }
}
