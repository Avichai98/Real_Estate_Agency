package application;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import java.io.IOException;

import Id206550493.Files;
import Id206550493.RealEstateAgency;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuHandler {
	public static RealEstateAgency O = new RealEstateAgency(null);
	public static Buttons b = new Buttons();
	public static Screen s = new Screen();
	public static AddApartment a = new AddApartment();
	public static ViewApartments v = new ViewApartments();
	public static Customers customer = new Customers();
	public static Clone c = new Clone();
	public static Exceptions e = new Exceptions();
	public static Files file = new Files();

	public void read(Stage primaryStage) {
		try {
			O = file.read();
		} catch (ClassNotFoundException | IOException e2) {
			e2.printStackTrace();
		}
	}

	public void displayMenu(Stage primaryStage) throws Throwable {

		ToggleGroup radioGroup = new ToggleGroup();
		Button submit = new Button("Submit");
		TilePane t = new TilePane();
		RadioButton addApartment = new RadioButton("Add apartment");
		RadioButton addCustomerToApartment = new RadioButton("Add customer to apartment");
		RadioButton showAllApartments = new RadioButton("Show all apartments");
		RadioButton showSpecificApartmentType = new RadioButton("Show specific apartment type");
		RadioButton priceForEntireDurationSpecificApartment = new RadioButton(
				"Price for entire duration specific apartment");
		RadioButton highPriceForEntireDuration = new RadioButton("Highest price for entire duration");
		RadioButton showCustomersOfSpecificApartment = new RadioButton("Show customers of specific apartment");
		RadioButton showCustomerOfSpecificApartmentAfterSorting = new RadioButton(
				"Show customers of specific apartment after sorting");
		RadioButton displayApartmentsCommission = new RadioButton("Display apartments commission");
		RadioButton copyApartment = new RadioButton("Copy apartment and display");

		Label l = new Label("Engency");

		t.getChildren().add(l);
		t.getChildren().add(addApartment);
		t.getChildren().add(addCustomerToApartment);
		t.getChildren().add(showAllApartments);
		t.getChildren().add(showSpecificApartmentType);
		t.getChildren().add(priceForEntireDurationSpecificApartment);
		t.getChildren().add(highPriceForEntireDuration);
		t.getChildren().add(showCustomersOfSpecificApartment);
		t.getChildren().add(showCustomerOfSpecificApartmentAfterSorting);
		t.getChildren().add(displayApartmentsCommission);
		t.getChildren().add(copyApartment);
		t.getChildren().add(submit);
		b.save(t);
		b.quit(t);

		addApartment.setToggleGroup(radioGroup);
		addCustomerToApartment.setToggleGroup(radioGroup);
		showAllApartments.setToggleGroup(radioGroup);
		showSpecificApartmentType.setToggleGroup(radioGroup);
		priceForEntireDurationSpecificApartment.setToggleGroup(radioGroup);
		highPriceForEntireDuration.setToggleGroup(radioGroup);
		showCustomersOfSpecificApartment.setToggleGroup(radioGroup);
		showCustomerOfSpecificApartmentAfterSorting.setToggleGroup(radioGroup);
		displayApartmentsCommission.setToggleGroup(radioGroup);
		copyApartment.setToggleGroup(radioGroup);

		submit.setOnAction(e -> {
			if (addApartment.isSelected())
				a.addNewApartment(primaryStage);

			else if (addCustomerToApartment.isSelected()) {
				try {
					v.apartmentsListWithContinue(primaryStage, 1, O.allApartments.size());
				} catch (Exception e1) {
					e1.getMessage();
				}
			} else if (showAllApartments.isSelected())
				try {
					v.apartmentsList(primaryStage);
				} catch (Exception e1) {
					e1.getMessage();
				}
			else if (showSpecificApartmentType.isSelected())
				v.chooseSpecificApartmentType(primaryStage);
			else if (priceForEntireDurationSpecificApartment.isSelected())
				try {
					v.apartmentsListWithContinue(primaryStage, 4, O.allApartments.size());
				} catch (Exception e2) {
					e2.getMessage();
				}
			else if (highPriceForEntireDuration.isSelected())
				v.date(primaryStage, 1, 0);
			else if (showCustomersOfSpecificApartment.isSelected()) {
				try {
					v.apartmentsListWithContinue(primaryStage, 2, O.allApartments.size());
				} catch (Exception e1) {
					e1.getMessage();
				}
			} else if (showCustomerOfSpecificApartmentAfterSorting.isSelected())
				try {
					v.apartmentsListWithContinue(primaryStage, 3, O.allApartments.size());
				} catch (Exception e1) {
					e1.getMessage();
				}
			else if (displayApartmentsCommission.isSelected())
				v.displayApartmentsCommission(primaryStage);
			else if (copyApartment.isSelected()) {
				c.copyApartment(primaryStage, O.allApartments.size());
			}

		});
		{
		}
		s.showScreenWithTilePane(primaryStage, t, "Menu");
	}

}