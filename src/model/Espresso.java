package model;

import java.io.Serializable;

public class Espresso implements Coffee, Serializable {

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double getCost() {
		return 3.00;
	}

}
