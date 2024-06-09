package application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Id206550493.Apartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ViewApartments extends MenuHandler {

	public ViewApartments() {

	}

	public void apartmentsList(Stage primaryStage) throws Exception {
		Label label = new Label("Apartments:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);

		ObservableList<StringBuffer> allApartments = FXCollections.observableArrayList(O.showAllApartments());
		ListView<StringBuffer> listView = new ListView<StringBuffer>(allApartments);
		listView.setMaxSize(500, 700);
		VBox layout = new VBox(listView, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "All apartments");
	}

	public void apartmentsListWithContinue(Stage primaryStage, int num, int maxApartmentId) throws Exception {
		Label label = new Label("Apartments:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);

		ObservableList<StringBuffer> allApartments = FXCollections.observableArrayList(O.showAllApartments());
		ListView<StringBuffer> listViewAllApartment = new ListView<StringBuffer>(allApartments);
		listViewAllApartment.setMaxSize(500, 700);

		ObservableList<StringBuffer> apartmentsForRent = FXCollections
				.observableArrayList(O.showSpecificApartmentType("ApartmentForOriginalRent"));
		apartmentsForRent.add(O.showSpecificApartmentType("AirbnbForRent"));
		ListView<StringBuffer> listViewApartmentForRent = new ListView<StringBuffer>(apartmentsForRent);
		listViewApartmentForRent.setMaxSize(500, 700);

		Label apartmentId = new Label("Enter apartment id:");
		TextField ApartmentId = new TextField();
		Button Continue = new Button("Continue");
		VBox layout = null;

		if (num == 1 || num == 2 || num == 3) {
			layout = new VBox(listViewAllApartment, apartmentId, ApartmentId, Continue, b.backToMenu(primaryStage));
			layout.setPadding(new Insets(10, 10, 10, 50));
		}

		if (num == 4) {
			layout = new VBox(listViewApartmentForRent, apartmentId, ApartmentId, Continue, b.backToMenu(primaryStage));
			layout.setPadding(new Insets(10, 10, 10, 50));
		}

		Continue.setOnAction(e -> {

			try {
				int id = Integer.parseInt(ApartmentId.getText());
				if (id < 1) {
					s.showInformationDialog("Apartment Id", "Apartment Id smaller then 1");
					return;
				}

				if (id > maxApartmentId) {
					s.showInformationDialog("Apartment Id", "Apartment Id bigger then " + maxApartmentId);
					return;
				}

				if (num == 1)
					customer.newCustomer(primaryStage, id);
				else if (num == 2)
					customer.showCustomers(primaryStage, id);
				else if (num == 3)
					customer.showCustomerOfSpecificApartmentAfterSorting(primaryStage, id);
				else if (num == 4) {

					if (!O.ExistsId(id)) {
						s.showInformationDialog("Apartment Id", "Apartment Id: " + id + "\nnot available for rent");
						return;
					}
					date(primaryStage, 2, id);
				}

			} catch (NumberFormatException e1) {
				s.showInformationDialog("Add customer", "It isn't a number, try again");
			}

		});
		s.showScreenWithVBox(primaryStage, layout, "All apartments");
	}

	public void specificApartmentsList(Stage primaryStage, String apartmentType) {
		Label label = new Label("Apartments:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		ObservableList<StringBuffer> apartmentType1 = FXCollections
				.observableArrayList(O.showSpecificApartmentType(apartmentType));
		ListView<StringBuffer> listView = new ListView<StringBuffer>(apartmentType1);
		listView.setMaxSize(200, 160);
		Button back = new Button("back");
		back.setOnAction(e -> {
			try {
				v.chooseSpecificApartmentType(primaryStage);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		VBox layout = new VBox(listView, back, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "All apartments");
	}

	public void chooseSpecificApartmentType(Stage primaryStage) {
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
			if (ApartmentForSale.isSelected())
				try {
					specificApartmentsList(primaryStage, "ApartmentForSale");
				} catch (Throwable e3) {
					System.out.println(e3.getMessage());
				}
			else if (ApartmentForOriginalRent.isSelected())
				try {
					specificApartmentsList(primaryStage, "ApartmentForOriginalRent");
				} catch (Throwable e2) {
					System.out.println(e2.getMessage());
				}
			else if (AirbnbForRent.isSelected())
				try {
					specificApartmentsList(primaryStage, "AirbnbForRent");
				} catch (Throwable e1) {
					System.out.println(e1.getMessage());
				}
		});

		s.showScreenWithTilePane(primaryStage, t, "Apartment type");
	}

	public void date(Stage primaryStage, int num, int Id) {
		VBox vbox = new VBox(20);
		Scene scene = new Scene(vbox, 400, 400);
		primaryStage.setScene(scene);
		DatePicker startDatePicker = new DatePicker();
		DatePicker endDatePicker = new DatePicker();

		// Disable direct typing
		startDatePicker.setEditable(false);
		endDatePicker.setEditable(false);

		startDatePicker.setValue(LocalDate.now());
		endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
		vbox.setPadding(new Insets(50));
		vbox.setStyle("-fx-background-color: BEIGE");

		primaryStage.setScene(scene);
		final Callback<DatePicker, DateCell> startDatePickerLimit = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(startDatePicker.getValue())) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};

		final Callback<DatePicker, DateCell> endDatePickerLimit = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						long p = ChronoUnit.DAYS.between(startDatePicker.getValue(), item);
						setTooltip(new Tooltip("You're about to stay for " + p + " nights"));

						if (item.isBefore(startDatePicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};
		startDatePicker.setDayCellFactory(startDatePickerLimit);
		endDatePicker.setDayCellFactory(endDatePickerLimit);
		endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
		Button Continue = new Button("Continue");
		Button back = new Button("back");
		vbox.getChildren().add(new Label("Start Date:"));
		vbox.getChildren().add(startDatePicker);
		vbox.getChildren().add(new Label("End Date:"));
		vbox.getChildren().add(endDatePicker);
		vbox.getChildren().add(Continue);
		vbox.getChildren().add(back);
		vbox.getChildren().add(b.backToMenu(primaryStage));
		primaryStage.setTitle("Date");
		primaryStage.show();

		back.setOnAction(e -> {
			try {
				v.apartmentsListWithContinue(primaryStage, 4, O.allApartments.size());
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});

		Continue.setOnAction(e -> {
			int dayI = startDatePicker.getValue().getDayOfMonth();
			int monthI = startDatePicker.getValue().getMonthValue();
			int yearI = startDatePicker.getValue().getYear();
			int dayF = endDatePicker.getValue().getDayOfMonth();
			int monthF = endDatePicker.getValue().getMonthValue();
			int yearF = endDatePicker.getValue().getYear();
			if (num == 1)
				highestPriceForEntireDuration(primaryStage, yearI, monthI, dayI, yearF, monthF, dayF);
			else if (num == 2) {
				displayPriceListForDuration(primaryStage, yearI, monthI, dayI, yearF, monthF, dayF, Id);
			}
		});
	}

	public void highestPriceForEntireDuration(Stage primaryStage, int yearI, int monthI, int dayI, int yearF,
			int monthF, int dayF) {
		StringBuffer sb = O.maxPriceDuration(yearI, monthI, dayI, yearF, monthF, dayF);
		Label label = new Label("Customers:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		ObservableList<StringBuffer> maxPrice = FXCollections.observableArrayList(sb);
		ListView<StringBuffer> listView = new ListView<StringBuffer>(maxPrice);
		listView.setMaxSize(200, 160);
		Button back = new Button("back");
		back.setOnAction(e -> {
			try {
				v.date(primaryStage, 1, 0);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		VBox layout = new VBox(listView, back, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "Max price");

	}

	public void displayPriceListForDuration(Stage primaryStage, int yearI, int monthI, int dayI, int yearF, int monthF,
			int dayF, int Id) {
		StringBuffer sb = O.displayPriceListForDuration(yearI, monthI, dayI, yearF, monthF, dayF, Id);
		Label label = new Label("Customers:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		ObservableList<StringBuffer> price = FXCollections.observableArrayList(sb);
		ListView<StringBuffer> listView = new ListView<StringBuffer>(price);
		listView.setMaxSize(200, 160);
		Button back = new Button("back");
		back.setOnAction(e -> {
			try {
				v.date(primaryStage, 2, Id);
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		VBox layout = new VBox(listView, back, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "Price");

	}

	public void showCopyApartment(Stage primaryStage, Apartment clonedApartment) {
		Label label = new Label("Copy apartment:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		ObservableList<StringBuffer> ClonedApartment = FXCollections
				.observableArrayList(clonedApartment.showApartments());
		ListView<StringBuffer> listView = new ListView<StringBuffer>(ClonedApartment);
		listView.setMaxSize(200, 160);
		Button back = new Button("back");
		back.setOnAction(e -> {
			try {
				c.copyApartment(primaryStage, O.allApartments.size());
			} catch (Throwable e1) {
				System.out.println(e1.getMessage());
			}
		});
		VBox layout = new VBox(listView, back, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "Clone apartment");
	}

	public void displayApartmentsCommission(Stage primaryStage) {
		Label label = new Label("Customers:");
		Font font = Font.font("blue", FontWeight.BOLD, FontPosture.ITALIC, 12);
		label.setFont(font);

		ObservableList<StringBuffer> allApartments = FXCollections.observableArrayList(O.displayApartmentsCommission());
		ListView<StringBuffer> listView = new ListView<StringBuffer>(allApartments);
		listView.setMaxSize(200, 160);
		VBox layout = new VBox(listView, b.backToMenu(primaryStage));
		s.showScreenWithVBox(primaryStage, layout, "Apartments commission");
	}

}
