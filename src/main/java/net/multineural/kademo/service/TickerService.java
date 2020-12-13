package net.multineural.kademo.service;

import net.multineural.kademo.data.TickerCache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerService {

    private TickerCache dataCache;

    public TickerService(final TickerCache dataCache) {
        this.dataCache = dataCache;
    }

    public List<String[]> getData() {
        return dataCache.liquidateCache();
    }



}
