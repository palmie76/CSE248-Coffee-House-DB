package model;

import java.io.Serializable;

public class HouseBlend implements Coffee, Serializable {

	@Override
	public String getDescription() {
		return "House Blend brew";
	}

	@Override
	public double getCost() {
		return 2.00;
	}

}
