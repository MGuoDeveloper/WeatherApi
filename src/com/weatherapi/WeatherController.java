package com.weatherapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.wsdl.*;

@Controller
public class WeatherController {
	
	@RequestMapping(value = "/weather/{zipcode}", method = RequestMethod.GET)
	public @ResponseBody WeatherInfo getShopInJSON(@PathVariable String zipcode) {
		WeatherConfiguration wc = new WeatherConfiguration();
		WeatherClient weatherClient = wc.weatherClient(wc.marshaller());
		GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipcode);
		WeatherInfo wi = weatherClient.printResponse(response);
		return wi;
	}
	
}
