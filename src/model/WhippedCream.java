package model;

import java.io.Serializable;

public class WhippedCream extends AddInsDecorator implements Serializable {

	public WhippedCream(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return coffee.getDescription() + ", whipped cream";
	}
	
	public double getCost() {
		return coffee.getCost() + 0.50;
	}

}
