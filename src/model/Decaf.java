package model;

import java.io.Serializable;

public class Decaf implements Coffee, Serializable {

	@Override
	public String getDescription() {
		return "Decaf brew";
	}

	@Override
	public double getCost() {
		return 2.50;
	}

}
