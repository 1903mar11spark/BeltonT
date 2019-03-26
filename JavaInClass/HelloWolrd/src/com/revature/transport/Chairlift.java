package com.revature.transport;

public class Chairlift extends Vehicle{

	public Chairlift() {
		super();
	
	}

	public Chairlift(double lengthInMeters, int gondolaCount) {
		super();
		this.lengthInMeters = lengthInMeters;
		this.gondolaCount = gondolaCount;
	}

	private double lengthInMeters;
	private int gondolaCount;
	
	@Override
	public void move() {
		System.out.println("chairLift is Moving");
		
	}

	public double getLengthInMeters() {
		return lengthInMeters;
	}

	public void setLengthInMeters(double lengthInMeters) {
		this.lengthInMeters = lengthInMeters;
	}

	public int getGondolaCount() {
		return gondolaCount;
	}

	public void setGondolaCount(int gondolaCount) {
		this.gondolaCount = gondolaCount;
	}

	@Override
	public String toString() {
		return "ChairLift [lengthInMeters=" + lengthInMeters + ", gondolaCount=" + gondolaCount + "]";
	}
}
