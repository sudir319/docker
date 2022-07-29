package com.cg.ce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cg.ce.entities.CurrencyExchange;
import com.cg.ce.entities.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	public CurrencyExchange getExchangeValue(String from, String to) {
		Optional<CurrencyExchange> exchangeOptional = repository.findByFromAndTo(from, to);
		CurrencyExchange exchange = exchangeOptional.orElse(new CurrencyExchange());
		exchange.setExchangePort(Integer.parseInt(env.getProperty("local.server.port")));
		
		return exchange;
	}
}
