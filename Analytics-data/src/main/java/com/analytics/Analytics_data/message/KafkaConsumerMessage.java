package com.analytics.Analytics_data.message;

import com.analytics.Analytics_data.dto.CarPostDTO;
import com.analytics.Analytics_data.service.PostAnalyticsService;
import com.typesafe.scalalogging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@SuppressWarnings("ALL")
@Component
public class KafkaConsumerMessage {

    private final Logger LOG = Logger.apply(LoggerFactory.getLogger(KafkaConsumerMessage.class));

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listenning(@Payload CarPostDTO carPost){

        System.out.println("CAR STORE -> Recebendo Postagem e informações dos carros" + carPost);
        LOG.toString();
        postAnalyticsService.saveDataAnalytics(carPost);

    }



}
