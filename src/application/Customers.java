package application;

import Id206550493.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Customers extends MenuHandler {

	public void newCustomer(Stage primaryStage, int ApartmentId) {
		GridPane g = new GridPane();
		Label name = new Label("Enter full name:");
		Label phone = new Label("Enter phone number:");
		Label NewCustomer = new Label("Enter Customer information:");

		TextField Name = new TextField();
		TextField Phone = new TextField();

		Button submit = new Button("Submit");
		Button back = new Button("Back");
		g.addRow(1, NewCustomer);
		g.addRow(2, name, Name);
		g.addRow(3, phone, Phone);
		g.addRow(7, submit);
		g.addRow(8, back);

		submit.setOnAction(e -> {
			
			try {
				long phoneNumber=Long.parseLong(Phone.getText());
				Customer newCustomer = new Customer(Name.getText(), phoneNumber);
				O.addCustomerToApartment(ApartmentId, newCustomer);
			} catch (Exception e1) {
				s.showInformationDialog("Add customer", "It isn't a number, try again");
				return;
			}
		
			try {
				 displayMenu(primaryStage);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});

		back.setOnAction(e -> {
			try {
				v.apartmentsListWithContinue(primaryStage, 1, O.allApartments.size());
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});

		s.showScreenWithGridPane(primaryStage, g, "Add Customer");

	}

	public void showCustomerOfSpecificApartmentAfterSorting(Stage primaryStage, int Id) {
		try {
			O.sorted(Id);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		showCustomers(primaryStage, Id);
	}

	public void showCustomers(Stage primaryStage, int Id) {
		Label label = new Label("Customers:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);

		ObservableList<StringBuffer> allCustomers = FXCollections
				.observableArrayList(O.allApartments.get(Id - 1).showAllCustomers());
		ListView<StringBuffer> listView = new ListView<StringBuffer>(allCustomers);
		listView.setMaxSize(200, 160);
		Button back = new Button("back");
		back.setOnAction(e -> {
			try {
				v.apartmentsListWithContinue(primaryStage, 2, O.allApartments.size());
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		VBox layout = new VBox(listView, back, b.backToMenu(primaryStage));
		layout.setPadding(new Insets(10, 10, 10, 50));
		layout.setStyle("-fx-background-color: BEIGE");

		s.showScreenWithVBox(primaryStage, layout, "All customers");
	}

	public void apartmentId(Stage primaryStage) throws CloneNotSupportedException {
		GridPane g = new GridPane();
		Label apartmentId = new Label("Enter apartment id:");
		TextField ApartmentId = new TextField();

		Button Continue = new Button("Continue");

		g.addRow(1, apartmentId, ApartmentId);
		g.addRow(2, Continue);
		g.addRow(3, b.backToMenu(primaryStage));

		Continue.setOnAction(e -> {
			int Id = Integer.parseInt(ApartmentId.getText());
			newCustomer(primaryStage, Id);
		});

		s.showScreenWithGridPane(primaryStage, g, "Apartment id");
	}
}
