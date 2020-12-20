package model;

import javafx.scene.control.TextArea;

public class ReceiptWriter implements IObserver {
	//updates a text area
	Ticket ticket;
	TextArea textArea;

	
	public ReceiptWriter(Ticket t, TextArea ta) {
		this.ticket = t;
		this.textArea = ta;
	}
	
	@Override
	public void update() {
		textArea.clear();
		textArea.appendText(ticket.toString());
	}

}
