package application;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Buttons extends MenuHandler {

	public Button backToMenu(Stage primaryStage) {
		Button backToMenu = new Button("Back to menu");
		backToMenu.setOnAction(e -> {
			try {
				super.displayMenu(primaryStage);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		return backToMenu;
	}

	public void quit(TilePane t) {
		var quit = new Button();
		quit.setText("Quit");
		t.getChildren().add(quit);
		quit.setOnAction((ActionEvent event) -> {
			Platform.exit();
		});
	}

	public void save(TilePane t) {
		Button save = new Button();
		save.setText("Save");
		t.getChildren().add(save);
		save.setOnAction((ActionEvent event) -> {
			try {
				file.save(O);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
	}
}