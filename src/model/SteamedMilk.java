package model;

import java.io.Serializable;

public class SteamedMilk extends AddInsDecorator implements Serializable {
	
	public SteamedMilk(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return coffee.getDescription() + ", steamed milk";
	}
	
	public double getCost() {
		return coffee.getCost() + 0.50;
	}

}
