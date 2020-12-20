package model;

import java.io.Serializable;

public class Sandwich implements MenuItem, Serializable {

	@Override
	public String getDescription() {
		return "sandwich";
	}

	@Override
	public double getCost() {
		return 3.25;
	}

}
