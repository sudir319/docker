package com.cg.cc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cc.beans.CurrencyConversion;
import com.cg.cc.service.CurrencyConversionService;

@RestController
@RequestMapping("/currency_conversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService service;
	
	@GetMapping("/get_conversion_value/{from}/{to}/{amount}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable Double amount) {
		return service.convertCurrency(from, to, amount);
	}
}
