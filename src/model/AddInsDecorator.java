package model;

import java.io.Serializable;

public abstract class AddInsDecorator implements Coffee, Serializable {
	protected Coffee coffee;
	
	public AddInsDecorator(Coffee c) {
		this.coffee = c;
	}
	
	public String getDescription() {
		return coffee.getDescription();
	}
	
	public double getCost() {
		return coffee.getCost();
	}
}
