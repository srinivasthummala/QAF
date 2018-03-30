package com.orbitz.bean;

public class FlightsBean {

	String flightName;
	String originDestination;
	String price;
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getOriDes() {
		return originDestination;
	}
	public void setOriDes(String originDestination) {
		this.originDestination = originDestination;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public void info() {
		System.out.println(flightName + ":" + ":" + originDestination + ":" + price);
	}

}
