package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Ticket implements Serializable {
	String description;
	double cost;
	double total;

	public Ticket() {
		this.description = "";
		this.cost = 0;
		this.total = 0;
	}

	public void appendOrder(String s, double c) {
		description += s;
		cost += c;
		total = calculateTotal();
	}

	public double calculateTotal() {
		String s = String.format("%.2f", cost * 1.0825);

		return Double.parseDouble(s);

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Description: " + this.description + "\n Cost: " + this.cost + "\n Total: " + this.total + " ";

	}

}
