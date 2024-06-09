package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Screen extends MenuHandler {

	public Screen() {
	}

	public void showScreenWithVBox(Stage primaryStage, VBox layout, String title) {
		Scene scene = new Scene(layout, 700, 500);
		layout.setPadding(new Insets(10, 10, 10, 50));
		layout.setStyle("-fx-background-color: Turquoise");
		layout.setPadding(new Insets(10, 10, 10, 50));
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(false);
	}

	public void showScreenWithGridPane(Stage primaryStage, GridPane g, String title) {
		Scene scene = new Scene(g, 595, 200);
		g.setStyle("-fx-background-color: Turquoise");
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(false);
	}

	public void showScreenWithTilePane(Stage primaryStage, TilePane t, String title) {
		Scene scene = new Scene(t, 300, 400);
		t.setStyle("-fx-background-color: Turquoise");
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(false);
	}

	public void showInformationDialog(String headerText, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(headerText);
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
