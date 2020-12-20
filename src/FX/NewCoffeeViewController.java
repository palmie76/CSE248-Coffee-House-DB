package FX;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Coffee;
import model.DarkRoast;
import model.Decaf;
import model.Espresso;
import model.HouseBlend;

public class NewCoffeeViewController implements Initializable {
	@FXML
	Button btnHouseBlend;
	@FXML
	Button btnDecaf;
	@FXML
	Button btnDarkRoast;
	@FXML
	Button btnEspresso;

	public void createEspresso(ActionEvent e) throws IOException {
		Espresso espresso = new Espresso();
		Main.setCoffee(espresso);

		Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}

	public void createHouseBlend(ActionEvent e) throws IOException {
		HouseBlend houseBlend = new HouseBlend();
		Main.setCoffee(houseBlend);

		Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();

	}

	public void createDarkRoast(ActionEvent e) throws IOException {
		DarkRoast darkRoast = new DarkRoast();
		Main.setCoffee(darkRoast);

		Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}

	public void createDecaf(ActionEvent e) throws IOException {
		Decaf decaf = new Decaf();
		Main.setCoffee(decaf);

		Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// orderList = Main.returnList();

	}

}
