package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class Demo {
	static //static Coffee coffee;
	LinkedList<Ticket> orderHistory;
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		LinkedList<Coffee> orderList = new LinkedList<Coffee>();
		orderHistory = new LinkedList<Ticket>();
		
		loadOrderHistory();
		for(Ticket t: orderHistory) {
			System.out.println(t.toString());
		}
		
	}
	
	public static void loadOrderHistory() throws IOException, ClassNotFoundException {
		File file = new File("data//sales.txt");
		FileInputStream input = new FileInputStream(file);
		
		if(file.length() != 0) {
		ObjectInputStream objectInput = new ObjectInputStream(input);
		try {
			while(true) { 
				Ticket t = (Ticket) objectInput.readObject();
				orderHistory.add(t);
			}
		}
			catch(EOFException ex){
				}
		objectInput.close();
		
		}	
	}
	

}
