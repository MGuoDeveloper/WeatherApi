package com.weatherapi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hello.wsdl.Forecast;
import hello.wsdl.ForecastReturn;
import hello.wsdl.GetCityForecastByZIP;
import hello.wsdl.GetCityForecastByZIPResponse;
import hello.wsdl.Temp;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WeatherClient extends WebServiceGatewaySupport {

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {

		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://wsf.cdyne.com/WeatherWS/Weather.asmx", request,
						new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

		return response;
	}

	public WeatherInfo printResponse(GetCityForecastByZIPResponse response) {

		ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

		WeatherInfo wInfo = new WeatherInfo();

		if (forecastReturn.isSuccess()) {

			wInfo.setCity(forecastReturn.getCity());
			wInfo.setState(forecastReturn.getState());
			ArrayList<Weather> weathers = new ArrayList<>();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {
				
				Temp temperature = forecast.getTemperatures();
				Weather weather = new Weather(format.format(forecast.getDate().toGregorianCalendar().getTime()),
						forecast.getDesciption(), Integer.parseInt(temperature.getMorningLow()),
						Integer.parseInt(temperature.getDaytimeHigh()));
				weathers.add(weather);
			}
			wInfo.setWeathers(weathers);
		} else {
			System.out.println("No forecast received");
		}
		return wInfo;
	}

}