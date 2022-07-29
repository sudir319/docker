package com.cg.cc.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.cc.beans.CurrencyConversion;
import com.cg.cc.feign.FeignProxy;

@Service
public class CurrencyConversionService {
	
	@Autowired
	private FeignProxy feignProxy;
	
	@Autowired
	private Environment env;
	
	public CurrencyConversion convertCurrency(String from, String to, Double amount) {
		CurrencyConversion conversion = getCurrencyExchangeFromFeign(from, to, amount);
		Double exchangeValue = conversion.getExchangeValue();
		
		Double conversionValue = BigDecimal.valueOf(exchangeValue).multiply(BigDecimal.valueOf(amount)).setScale(2, RoundingMode.HALF_UP).doubleValue();
		conversion.setConversionValue(conversionValue);
		
		conversion.setConversionPort(Integer.parseInt(env.getProperty("local.server.port")));

		
		return conversion;
	}

	private CurrencyConversion getCurrencyExchange(String from, String to, Double amount) {
		String url = "http://localhost:8080/currency_exchange/get_exchange_value/{from}/{to}";
		Map<String, String> mappings = new HashMap<>();
		mappings.put("from", from);
		mappings.put("to", to);
		RestTemplate template = new RestTemplate();
		ResponseEntity<CurrencyConversion> responseEntity = template.getForEntity(url, CurrencyConversion.class, mappings);
		CurrencyConversion currencyExchange = responseEntity.getBody();
		return currencyExchange;
	}
	
	private CurrencyConversion getCurrencyExchangeFromFeign(String from, String to, Double amount) {
		CurrencyConversion currencyExchange = feignProxy.getExchangeValue(from, to);
		return currencyExchange;
	}	
}
