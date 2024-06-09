package application;

import Id206550493.Apartment;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Clone extends MenuHandler {

	public void copyApartment(Stage primaryStage, int maxApartmentId) {
		GridPane r = new GridPane();
		Label apartmentId = new Label("Enter apartment id:");
		TextField ApartmentId = new TextField();

		Button Continue = new Button("Continue");

		r.addRow(1, apartmentId, ApartmentId);
		r.addRow(2, Continue);
		r.addRow(3, b.backToMenu(primaryStage));

		Continue.setOnAction(e -> {
			try {
				int Id = Integer.parseInt(ApartmentId.getText());
				if (Id < 1) {
					s.showInformationDialog("Add customer", "Apartment Id smaller then 1");
					return;
				}

				if (Id > maxApartmentId) {
					s.showInformationDialog("Add customer", "Apartment Id bigger then " + maxApartmentId);
					return;
				}

				Apartment clonedApartment = (Apartment) O.allApartments.get(Id - 1).clone();
				v.showCopyApartment(primaryStage, clonedApartment);
			} catch (CloneNotSupportedException e1) {
				System.out.println(e1.getMessage());

			} catch (NumberFormatException e1) {
				s.showInformationDialog("Add customer", "It isn't integer, try again");
			}
		});

		s.showScreenWithGridPane(primaryStage, r, "Add apartment");
	}
}
