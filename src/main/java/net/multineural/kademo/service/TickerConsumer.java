package net.multineural.kademo.service;

import net.multineural.kademo.data.TickerCache;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerConsumer {

    Logger logger = LoggerFactory.getLogger(TickerConsumer.class);

    private TickerCache dataCache;

    public TickerConsumer(final TickerCache dataCache) {
        this.dataCache = dataCache;
    }

    @KafkaListener(topics = "${multineural.consumer.topics}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload final ConsumerRecord<String, String> record) {

        logger.debug("recieved " + record);

        final String[] entry = new String[2];
        entry[0] = record.key();
        entry[1] = record.value();

        dataCache.add(entry);

    }



}
