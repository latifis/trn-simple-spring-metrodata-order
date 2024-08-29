package com.acc.orderservice.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener implements StreamListener<String, ObjectRecord<String, String>> {

    @Override
    public void onMessage(ObjectRecord<String, String> message) {
        log.info("Received Message on : {}", message);
    }
}
