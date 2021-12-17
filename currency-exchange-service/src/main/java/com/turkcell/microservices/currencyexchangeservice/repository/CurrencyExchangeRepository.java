package com.turkcell.microservices.currencyexchangeservice.repository;

import com.turkcell.microservices.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange getByFromAndTo(String from, String to);
}
