package com.turkcell.microservices.currencyexchangeservice.controller;

import com.turkcell.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.turkcell.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    Environment environment;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange exchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.getByFromAndTo(from, to);
        if (currencyExchange == null)
            throw new RuntimeException("Currency not found!");

        String port = environment.getProperty("server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
