package Id206550493;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import application.Screen;

public class RealEstateAgency implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2149991950492768450L;
	public ArrayList<Apartment> allApartments;

	public enum ApartmentType {
		exitManu, ApartmentForSale, ApartmentForOriginalRent, AirbnbForRent
	}

	public static Screen s = new Screen();

	public RealEstateAgency(ArrayList<Apartment> allApartments) {
		this.allApartments = new ArrayList<Apartment>();
		try {
			// fillApartmentList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Apartment> getAllApartemnts() {
		return allApartments;
	}

	public void fillApartmentList() throws Exception {
		/*
		 * ApartmentForSale S1 = new ApartmentForSale("Tel-aviv 10", 50, 3, 7, 1000000,
		 * null);// S-sale allApartments.add(S1); ApartmentForSale S2 = new
		 * ApartmentForSale("haifa 10", 150, 4, 8, 1500000, null);
		 * allApartments.add(S2); ApartmentForSale S3 = new
		 * ApartmentForSale("Jerusalem 10", 200, 5, 9, 2000000, null);
		 * allApartments.add(S3); ApartmentForSale S4 = new ApartmentForSale("Eilat 10",
		 * 250, 6, 10, 2500000, null); allApartments.add(S4); ApartmentForSale S5 = new
		 * ApartmentForSale("Yavne 10", 300, 7, 9, 3000000, null);
		 * allApartments.add(S5); ApartmentForOriginalRent RM1 = new
		 * ApartmentForOriginalRent("Tel-aviv 20", 50, 3, 7, 2000, null);// RD-rental //
		 * month allApartments.add(RM1); ApartmentForOriginalRent RM2 = new
		 * ApartmentForOriginalRent("haifa 20", 100, 4, 8, 3000, null);
		 * allApartments.add(RM2); ApartmentForOriginalRent RM3 = new
		 * ApartmentForOriginalRent("Jerusalem 20", 150, 5, 9, 4000, null);
		 * allApartments.add(RM3); ApartmentForOriginalRent RM4 = new
		 * ApartmentForOriginalRent("Eilat 20", 200, 6, 10, 5000, null);
		 * allApartments.add(RM4); ApartmentForOriginalRent RM5 = new
		 * ApartmentForOriginalRent("Yavne 20", 250, 7, 9, 6000, null);
		 * allApartments.add(RM5); AirbnbForRent RD1 = new AirbnbForRent("Tel-aviv 30",
		 * 50, 3, 7, 500, null);// RD-rental day allApartments.add(RD1); AirbnbForRent
		 * RD2 = new AirbnbForRent("haifa 30", 100, 4, 8, 1000, null);
		 * allApartments.add(RD2); AirbnbForRent RD3 = new AirbnbForRent("Jerusalem 30",
		 * 150, 5, 9, 1500, null); allApartments.add(RD3); AirbnbForRent RD4 = new
		 * AirbnbForRent("Eilat 30", 200, 6, 10, 2000, null); allApartments.add(RD4);
		 * AirbnbForRent RD5 = new AirbnbForRent("Yavne 30", 250, 7, 9, 2500, null);
		 * allApartments.add(RD5);
		 */
		// S1.fillCustomersList();
		// allApartments.get(5).fillCustomersList();
		// allApartments.get(10).fillCustomersList();
		// allApartments.get(7).fillCustomersList();

	}

	public boolean addApartment(Apartment newApartment) throws ClassNotFoundException {// Add apartment
		for (Apartment i : allApartments) {
			if (i.getAddress().equalsIgnoreCase(newApartment.getAddress())) {
				System.out.println("The apartment allrady in the list");
				s.showInformationDialog("Add apartment", "The apartment allrady in the list");
				return false;
			}
		}
		allApartments.add(newApartment);
		System.out.println("The apartment was added successfully");
		s.showInformationDialog("Add apartment", "The apartment was added successfully");
		return true;
	}

	public StringBuffer showAllApartments() {
		StringBuffer apartmentsList = new StringBuffer();
		for (Apartment i : allApartments) {
			apartmentsList.append(i.getClass().getSimpleName() + ":\n" + i.showApartments() + "\n");
		}
		return apartmentsList;
	}

	public boolean ExistsId(int id) {
		if (allApartments.get(id - 1).getClass().getSimpleName().equals("ApartmentForOriginalRent")
				|| allApartments.get(id - 1).getClass().getSimpleName().equals("AirbnbForRent"))
			return true;

		return false;
	}

	public StringBuffer showSpecificApartmentType1(ApartmentType apartment) {
		StringBuffer apartmentsList = new StringBuffer();
		String apartmentClassName = null;
		switch (apartment) {
		case ApartmentForSale: {
			apartmentClassName = "ApartmentForSale";
			break;
		}
		case ApartmentForOriginalRent: {
			apartmentClassName = "ApartmentForOriginalRent";
			break;
		}
		case AirbnbForRent: {
			apartmentClassName = "AirbnbForRent";
			break;
		}
		case exitManu: {
			System.out.println("Goodbye!");

			break;
		}

		}
		for (Apartment i : allApartments) {
			if (i.getClass().getSimpleName().equals(apartmentClassName))
				System.out.println(i.showApartments());

		}

		return apartmentsList;
	}

	public StringBuffer showSpecificApartmentType(String apartmentType) {
		StringBuffer apartmentsList = new StringBuffer();
		for (Apartment i : allApartments) {
			if (i.getClass().getSimpleName().equals(apartmentType))
				apartmentsList.append(i.getClass().getSimpleName() + ":\n" + i.showApartments() + "\n");
		}
		return apartmentsList;
	}

	public StringBuffer showApartmentCustomersList(int apartmentNum) {
		StringBuffer apartment = new StringBuffer("Customers of apartment: " + apartmentNum + "\n"
				+ allApartments.get(apartmentNum - 1).showAllCustomers());
		return apartment;
	}

	public void sorted(int apartmentNum) throws ClassNotFoundException {
		allApartments.get(apartmentNum - 1).sortedCustomersListA(allApartments.get(apartmentNum - 1).allCustomers);

	}

	public boolean addCustomerToApartment(int apartmentNum, Customer newCustomer) {
		boolean isOk;
		isOk = allApartments.get(apartmentNum - 1).addCustomer(newCustomer);
		return isOk;
	}

	public StringBuffer displayPriceListForDuration(int yearI, int monthI, int dayI, int yearF, int monthF, int dayF,
			int apartmentNum) {

		long rentalDays = calculatedDayDuration(yearI, monthI, dayI, yearF, monthF, dayF);
		long rentalMonths = calculatedMonthDuration(yearI, monthI, dayI, yearF, monthF, dayF);

		StringBuffer priceList = new StringBuffer("Price of apartment: " + apartmentNum + "\n");
		if (allApartments.get(apartmentNum - 1).getClass().getSimpleName()
				.equals(ApartmentForOriginalRent.class.getSimpleName()))
			priceList.append(allApartments.get(apartmentNum - 1).priceForEntireDuration((int) rentalMonths));
		else if (allApartments.get(apartmentNum - 1).getClass().getSimpleName()
				.equals(AirbnbForRent.class.getSimpleName()))
			priceList.append(allApartments.get(apartmentNum - 1).priceForEntireDuration((int) rentalDays - 1));
		else
			priceList.append(allApartments.get(apartmentNum - 1).priceForApartmentForSale());
		return priceList;
	}

	public long calculatedDayDuration(int yearI, int monthI, int dayI, int yearF, int monthF, int dayF) {
		LocalDate start = LocalDate.of(yearI, monthI, dayI);
		LocalDate end = LocalDate.of(yearF, monthF, dayF);

		long rentalDays = ChronoUnit.DAYS.between(start, end);
		rentalDays = Math.abs((int) rentalDays);
		rentalDays++;
		return rentalDays;
	}

	public long calculatedMonthDuration(int yearI, int monthI, int dayI, int yearF, int monthF, int dayF) {
		LocalDate start = LocalDate.of(yearI, monthI, dayI);
		LocalDate end = LocalDate.of(yearF, monthF, dayF);

		long rentalMonths = ChronoUnit.MONTHS.between(start, end);
		rentalMonths = Math.abs((int) rentalMonths);
		if ((ChronoUnit.DAYS.between(start, end) > 0) || !(start.isBefore(end)) && !(start.isAfter(end)))// Equal
			rentalMonths++;
		return rentalMonths;
	}

	public StringBuffer maxPriceDuration(int yearI, int monthI, int dayI, int yearF, int monthF, int dayF) {
		StringBuffer sb = new StringBuffer();
		long rentalDays = calculatedDayDuration(yearI, monthI, dayI, yearF, monthF, dayF);
		long rentalMonths = calculatedMonthDuration(yearI, monthI, dayI, yearF, monthF, dayF);
		int maxPrice = 0;
		int Id = 0;
		int apartmentPrice = 0;
		for (Apartment i : allApartments) {
			if (i.getClass().getSimpleName().equals(ApartmentForOriginalRent.class.getSimpleName()))
				apartmentPrice = i.priceForEntireDuration((int) rentalMonths);

			if (i.getClass().getSimpleName().equals(AirbnbForRent.class.getSimpleName()))
				apartmentPrice = i.priceForEntireDuration((int) rentalDays - 1);

			if (apartmentPrice > maxPrice) {
				maxPrice = apartmentPrice;
				Id = i.getId();
			}
		}
		return sb.append("Apartment Id: " + Id + "\nMax price: " + maxPrice);
	}

	public StringBuffer displayApartmentsCommission() {
		StringBuffer sb = new StringBuffer();
		for (Apartment apartment : allApartments) {
			if (apartment.getClass().getSimpleName().equals(ApartmentForOriginalRent.class.getSimpleName()))
				sb.append("Id: " + apartment.getId() + "\nCommission rate: "
						+ ((ApartmentForOriginalRent) apartment).calculateCommission() + "\n");
			if (apartment.getClass().getSimpleName().equals(ApartmentForSale.class.getSimpleName()))
				sb.append("Id: " + apartment.getId() + "\nCommission rate: "
						+ ((ApartmentForSale) apartment).calculateCommission() + "\n");
		}
		return sb;
	}
}
