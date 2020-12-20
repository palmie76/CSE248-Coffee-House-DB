package FX;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Coffee;
import model.MenuItem;
import model.Mocha;
import model.Order;
import model.Sandwich;
import model.SoyMilk;
import model.SteamedMilk;
import model.Ticket;
import model.WhippedCream;

public class MainMenuViewController implements Initializable {
	static LinkedList<MenuItem> orderList;
	static Coffee currentCoffee;

	@FXML
	TextArea taTicket;
	@FXML
	Button btnNewCoffee;
	@FXML
	Button btnAddSteamedMilk;
	@FXML
	Button btnAddSoyMilk;
	@FXML
	Button btnAddWhippedCream;
	@FXML
	Button btnAddMocha;
	@FXML
	Button btnSeeHistory;
	@FXML
	Button btnOrder;
	@FXML
	Button btnSandwich;

	public void createNewCoffee(ActionEvent e) throws IOException {
		if (currentCoffee != null) {
			Main.orderList.add(currentCoffee);
		}

		currentCoffee = null;

		Parent root = FXMLLoader.load(getClass().getResource("NewCoffeeView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}

	public void addSteamedMilk(ActionEvent e) {
		if (currentCoffee != null) {
			SteamedMilk steamedMilk = new SteamedMilk(currentCoffee);
			currentCoffee = steamedMilk;
		} else {
			alertPrompt();
		}

	}

	public void addSoyMilk(ActionEvent e) {
		if (currentCoffee != null) {
			SoyMilk soyMilk = new SoyMilk(currentCoffee);
			currentCoffee = soyMilk;
		} else {
			alertPrompt();
		}
	}

	public void addWhippedCream(ActionEvent e) {
		if (currentCoffee != null) {
			WhippedCream whippedCream = new WhippedCream(currentCoffee);
			currentCoffee = whippedCream;
		} else {
			alertPrompt();
		}
	}

	public void addMocha(ActionEvent e) {
		if (currentCoffee != null) {
			Mocha mocha = new Mocha(currentCoffee);
			currentCoffee = mocha;
		} else {
			alertPrompt();
		}
	}

	public void addSandwich(ActionEvent e) {
		if (currentCoffee != null) {
			Main.orderList.add(currentCoffee);
		}
		currentCoffee = null;
		Sandwich sandwich = new Sandwich();
		Main.orderList.add(sandwich);

	}

	public void seeSaleHistory(ActionEvent e) throws IOException, ClassNotFoundException {
		// read from DB
		// display all to sale history text area
		String display = "";
		try {
			ResultSet rs = Main.statement.executeQuery("SELECT * FROM orderHistory");
			while (rs.next()) {
				display += "Sale ID: " + rs.getString("id") + "\nDescription: " + rs.getString("description")
						+ "\n Cost: " + rs.getDouble("cost") + "\n Total: " + rs.getDouble("total") + "\n\n";

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		SalesHistoryViewController.setText(display);
		Parent root = FXMLLoader.load(getClass().getResource("SalesHistoryView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();

	}

	public void order(ActionEvent e) throws IOException {
		// update receipt
		// create ticket object and notify observers
		// append information to binary text file

		if (currentCoffee != null) {
			Main.orderList.add(currentCoffee);
		}
		
		if(orderList.size() == 0) {
			alertOrder();	
		} else {
		// add ticket into the DB
		Order order = new Order(Main.orderList, taTicket);
		order.notifyObserver();

		String sql = "INSERT INTO orderHistory (description, cost, total) VALUES(?, ?, ?)";
		try {
			PreparedStatement prep = Main.conn.prepareStatement(sql);
			prep.setString(1, order.returnTicket().getDescription());
			prep.setDouble(2, order.returnTicket().getCost());
			prep.setDouble(3, order.returnTicket().getTotal());
			prep.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Main.orderList.clear();
		currentCoffee = null;
		}

	}

	public void alertPrompt() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("ALERT");
		alert.setHeaderText("ERROR");
		alert.setContentText("Select coffee first");
		alert.showAndWait();
	}
	
	public void alertOrder() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("ALERT");
		alert.setHeaderText("ERROR");
		alert.setContentText("Select menu item first");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		orderList = Main.returnOrderList();
		currentCoffee = Main.returnSelectedCoffee();
	}

	public static Coffee returnSelectedCoffee() {
		return currentCoffee;
	}

}
