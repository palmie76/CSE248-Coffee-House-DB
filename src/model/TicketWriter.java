package model;

import java.util.LinkedList;

public class TicketWriter implements IObserver {
	// creates Ticket object
	LinkedList<MenuItem> orderList;
	Ticket ticket;

	public TicketWriter(LinkedList<MenuItem> list) {
		this.orderList = list;

	}

	@Override
	public void update() {
		ticket = new Ticket();
		StringBuilder stringBuilder;

		for (int i = 0; i < orderList.size(); i++) {
			stringBuilder = new StringBuilder();
			if (i == orderList.size() - 1) {
				stringBuilder.append(orderList.get(i).getDescription());
			} else {
				stringBuilder.append(orderList.get(i).getDescription() + " + ");
			}
			String s = stringBuilder.toString();
			ticket.appendOrder(s, orderList.get(i).getCost());
		}
	}

	public Ticket getTicket() {
		return this.ticket;
	}

}
