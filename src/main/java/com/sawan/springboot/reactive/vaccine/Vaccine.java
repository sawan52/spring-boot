package com.sawan.springboot.reactive.vaccine;

public class Vaccine {

	private String name;
	private boolean delivered;

	Vaccine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

}
