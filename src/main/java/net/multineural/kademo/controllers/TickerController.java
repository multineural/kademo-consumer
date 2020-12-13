package net.multineural.kademo.controllers;

import net.multineural.kademo.service.TickerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TickerController {

    private TickerService tickerService;

    public TickerController(final TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping(value = "/dia_test", produces = {"application/json"})
    public List<String[]> getTickerValues() {
        return tickerService.getData();
    }

}
