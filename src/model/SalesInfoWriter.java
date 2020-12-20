package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class SalesInfoWriter implements IObserver {
	// write ticket to a file sales.txt

	FileOutputStream fileOut;
	ObjectOutputStream objectOut;

	Ticket ticket;
	File file;

	LinkedList<Ticket> orderHistory;

	public SalesInfoWriter(Ticket t) {
		this.ticket = t;
		file = new File("data//sales.txt");
	}

	@Override
	public void update() {
		// read current file, load all tickets into orderHistory
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		}
		orderHistory = new LinkedList<Ticket>();

		// if the file is not empty, read objects and put into orderHistory
		if (file.length() != 0) {
			ObjectInputStream objectInput = null;
			try {
				objectInput = new ObjectInputStream(input);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				while (true) {
					Ticket t = (Ticket) objectInput.readObject();
					orderHistory.add(t);
				}
			} catch (EOFException ex) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				objectInput.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// add new ticket to orderHistory
		orderHistory.add(ticket);

		// write new file
		try {
			fileOut = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			objectOut = new ObjectOutputStream(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (file.length() != 0) {
			try {
				for (Ticket t : orderHistory) {
					objectOut.writeObject(t);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			writeBinaryFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeBinaryFile() throws IOException {
		// write binary.txt using bytes
		File fileInput = new File("data//sales.txt");
		File fileDestination = new File("data//binary.txt");
		
		InputStream is = new FileInputStream(fileInput);
		OutputStream os = new FileOutputStream(fileDestination);
		
		long fileSize = fileInput.length();
		byte[] allBytes = new byte[(int) fileSize];
		is.read(allBytes); 
        os.write(allBytes);
		


	}
}
