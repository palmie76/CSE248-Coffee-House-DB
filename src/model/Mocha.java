package model;

import java.io.Serializable;

public class Mocha extends AddInsDecorator implements Serializable {

	public Mocha(Coffee coffee) {
		super(coffee);
	}
	
	public String getDescription() {
		return coffee.getDescription() + ", mocha";
	}
	
	public double getCost() {
		return coffee.getCost() + 1.00;
	}

}
