package com.company;

class Beverage {
	private String size;
	private int glasses;
	private double price;

	Beverage(String size, int glasses) {
		this.size = size;
		this.glasses = glasses;
		this.price = 0;
	}

	public void setGlasses(int glasses) {
		this.glasses = glasses;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGlasses() {
		return glasses;
	}

	public String getSize() {
		return size;
	}

	public double getPrice() {
		return price;

	}

	@Override
	public String toString() {
		return String.format("%d %s Glass(es) of ", this.getGlasses(), this.getSize());
	}
}



