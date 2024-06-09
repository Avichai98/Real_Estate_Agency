package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	static MenuHandler m = new MenuHandler();

	@Override
	public void start(Stage primaryStage) {
		try {
			m.read(primaryStage);
			m.displayMenu(primaryStage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		primaryStage.show();
		primaryStage.setAlwaysOnTop(true);
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}
