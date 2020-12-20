package model;

import java.io.IOException;
import java.util.LinkedList;

import javafx.scene.control.TextArea;

public class Order implements IObservable {
	//makes everything happen
	LinkedList<MenuItem> orderList;
	TextArea textArea;
	
	TicketWriter ticketWriter;
	ReceiptWriter receiptWriter;
	SalesInfoWriter salesInfoWriter;
	Ticket ticket;
	
	public Order(LinkedList<MenuItem> list, TextArea ta) {
		this.orderList = list;
		this.textArea = ta;
		ticketWriter = new TicketWriter(orderList);
		
	}
	
	@Override
	public void notifyObserver() {
		ticketWriter.update();
		this.ticket = ticketWriter.getTicket();
		
		receiptWriter = new ReceiptWriter(ticketWriter.getTicket(), textArea);
		receiptWriter.update();
		
		salesInfoWriter = new SalesInfoWriter(ticket);
		salesInfoWriter.update();
		
	}
	
	public Ticket returnTicket() {
		return this.ticket;
	}


}
