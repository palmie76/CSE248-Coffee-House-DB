package FX;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Coffee;
import model.MenuItem;
import model.Ticket;
import util.ConnectionUtil;

public class Main extends Application {
	static LinkedList<MenuItem> orderList;
	static Coffee currentCoffee;
	static LinkedList<Ticket> orderHistory;
	
	static Connection conn;
	static Statement statement;
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		currentCoffee = null;
		orderList = new LinkedList<MenuItem>();
		//orderHistory = new LinkedList<Ticket>();
		
		//get connection to DB
		conn = null;
		conn = ConnectionUtil.getConnection();
		statement = conn.createStatement();
		
		Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		Scene scene = new Scene(root, 625, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static LinkedList<MenuItem> returnOrderList(){
		return orderList;
	}
	
	public static Coffee returnSelectedCoffee() {
		return currentCoffee;
	}
	
	public static void setCoffee(Coffee coffee) {
		currentCoffee = coffee;
	}
	
	public static LinkedList<Ticket> returnSales(){
		return orderHistory;
	}
	

	
	

}
