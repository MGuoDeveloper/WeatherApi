package com.weatherapi;

import java.util.ArrayList;

public class WeatherInfo {

	String city;
	String state;
	ArrayList<Weather> weathers;

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(ArrayList<Weather> weathers) {
		this.weathers = weathers;
	}

	public WeatherInfo(String city, String state, ArrayList<Weather> weathers) {
		super();
		this.city = city;
		this.state = state;
		this.weathers = weathers;
	}

	public WeatherInfo() {
	}

}
