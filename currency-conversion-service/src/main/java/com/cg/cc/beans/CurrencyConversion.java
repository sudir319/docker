package com.cg.cc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CurrencyConversion {
	public Long id;
	public String from;
	public String to;
	public Double exchangeValue;
	public Double conversionValue;
	public int exchangePort;
	public int conversionPort;
}
