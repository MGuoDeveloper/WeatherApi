package com.weatherapi;

public class Weather {

	String date;
	String desc;
	int low;
	int high;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public Weather() {
	}

	public Weather(String date, String desc, int low, int high) {
		super();
		this.date = date;
		this.desc = desc;
		this.low = low;
		this.high = high;
	}

}
