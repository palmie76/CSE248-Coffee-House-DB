package model;

import java.io.Serializable;

public class SoyMilk extends AddInsDecorator implements Serializable {
	
	public SoyMilk(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return coffee.getDescription() + ", soy milk";
	}
	
	public double getCost() {
		return coffee.getCost() + 0.75;
	}

}
