package model;

import java.io.Serializable;

public class DarkRoast implements Coffee, Serializable {

	@Override
	public String getDescription() {
		return "Dark roast brew";
	}

	@Override
	public double getCost() {
		return 2.25;
	}

}
