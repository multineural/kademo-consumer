package net.multineural.kademo.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class TickerCache {

    Logger logger = LoggerFactory.getLogger(TickerCache.class);
    public static Integer MAX_CAPACITY = 100;

    private Queue<String[]> simpleCache = new ArrayBlockingQueue<>(MAX_CAPACITY);

    public int add(final String[] entry) {

        if (simpleCache.size() == MAX_CAPACITY) {
            final String[] throwAway = simpleCache.remove();
            logger.debug("MAX_CAPACITY reached, removing value: " + throwAway[1]);
        }
        simpleCache.add(entry);

        return simpleCache.size();
    }


    public List<String[]> liquidateCache() {

        final List<String[]> data = new ArrayList<>();

        simpleCache.forEach(entry -> {
            data.add(entry);
        });

        logger.debug("clearing cache, entry count: " + simpleCache.size());
        simpleCache.clear();

        return data;
    }

}
