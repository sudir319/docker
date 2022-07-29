package com.cg.ce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ce.entities.CurrencyExchange;
import com.cg.ce.services.CurrencyExchangeService;

@RestController
@RequestMapping("/currency_exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService exchangeService;
	
	@GetMapping("/get_exchange_value/{from}/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
		return exchangeService.getExchangeValue(from, to);
	}
}
