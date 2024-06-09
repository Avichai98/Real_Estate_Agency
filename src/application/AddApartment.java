package application;

import Id206550493.AirbnbForRent;
import Id206550493.ApartmentForOriginalRent;
import Id206550493.ApartmentForSale;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AddApartment extends MenuHandler {
	
	public void addNewApartment(Stage primaryStage) {
		GridPane g = new GridPane();
		Label addApartment = new Label("Enter apartment information:");
		Label address = new Label("Enter address");
		Label size = new Label("Enter size");
		Label numOfRooms = new Label("Enter num of rooms");
		Label rank = new Label("Enter rank (1-10)");
		Label price = new Label("Enter apartment price");

		TextField Address = new TextField();
		TextField Size = new TextField();
		TextField NumOfRooms = new TextField();
		TextField Rank = new TextField();
		TextField Price = new TextField();

		Button submit = new Button("Submit");
		g.addRow(1, addApartment);
		g.addRow(2, address, Address);
		g.addRow(3, size, Size);
		g.addRow(4, numOfRooms, NumOfRooms);
		g.addRow(5, rank, Rank);
		g.addRow(6, price, Price);
		g.addRow(7, submit);
		g.addRow(8, b.backToMenu(primaryStage));
		
		submit.setOnAction(e -> {
			try {
				String apartmentAddress = Address.getText();
				int apartmentSize = Integer.parseInt(Size.getText());
				int apartmentNumOfRooms = Integer.parseInt(NumOfRooms.getText());
				int apartmentRank = Integer.parseInt(Rank.getText());
				int apartmentPrice = Integer.parseInt(Price.getText());
				@SuppressWarnings("unused")
				ApartmentForSale test = new ApartmentForSale(null, apartmentSize, apartmentNumOfRooms, apartmentRank,
						apartmentPrice, null);
				apartmentType(primaryStage, apartmentAddress, apartmentSize, apartmentNumOfRooms, apartmentRank,
						apartmentPrice);
			} catch (NumberFormatException e1) {
				s.showInformationDialog("Add apartment", "It isn't a number, try again");
				return;
			} catch (java.lang.Exception e2) {
				s.showInformationDialog("Add apartment", e2.getMessage());
				return;
			}
		});

		s.showScreenWithGridPane(primaryStage, g, "Add apartment");

	}

	public void apartmentType(Stage primaryStage, String apartmentAddress, int apartmentSize, int apartmentNumOfRooms,
			int apartmentRank, int apartmentPrice) {
		TilePane t = new TilePane();
		ToggleGroup radioGroup = new ToggleGroup();
		Button submit = new Button("Submit");
		RadioButton ApartmentForSale = new RadioButton("Apartment for sale");
		RadioButton ApartmentForOriginalRent = new RadioButton("Apartment for original rent");
		RadioButton AirbnbForRent = new RadioButton("Air bnb for rent");

		Label l = new Label("Choose apartment type:");

		t.getChildren().add(l);
		t.getChildren().add(ApartmentForSale);
		t.getChildren().add(ApartmentForOriginalRent);
		t.getChildren().add(AirbnbForRent);
		t.getChildren().add(submit);
		t.getChildren().add(b.backToMenu(primaryStage));

		ApartmentForSale.setToggleGroup(radioGroup);
		ApartmentForOriginalRent.setToggleGroup(radioGroup);
		AirbnbForRent.setToggleGroup(radioGroup);

		submit.setOnAction(e -> {
			if (ApartmentForSale.isSelected()) {
				ApartmentForSale apartmentForSale;
				try {
					apartmentForSale = new ApartmentForSale(apartmentAddress, apartmentSize, apartmentNumOfRooms,
							apartmentRank, apartmentPrice, null);
					O.addApartment(apartmentForSale);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}

			else if (ApartmentForOriginalRent.isSelected()) {
				ApartmentForOriginalRent apartmentForOriginalRent;
				try {
					apartmentForOriginalRent = new ApartmentForOriginalRent(apartmentAddress, apartmentSize,
							apartmentNumOfRooms, apartmentRank, apartmentPrice, null);
					O.addApartment(apartmentForOriginalRent);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			} else {
				AirbnbForRent airbnbForRent;
				try {
					airbnbForRent = new AirbnbForRent(apartmentAddress, apartmentSize, apartmentNumOfRooms,
							apartmentRank, apartmentPrice, null);
					O.addApartment(airbnbForRent);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
			try {
				super.displayMenu(primaryStage);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}

		});

		s.showScreenWithTilePane(primaryStage, t, "Apartment type");
	}

	{
	}
}
