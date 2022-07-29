package com.cg.cc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.cc.beans.CurrencyConversion;

@FeignClient(name="${currency-exchange-url}", url="${currency-exchange-url}")
public interface FeignProxy {
	@GetMapping("/currency_exchange/get_exchange_value/{from}/{to}")
	public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);
}
