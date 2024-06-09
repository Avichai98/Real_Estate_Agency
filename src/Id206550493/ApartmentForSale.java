package Id206550493;

import java.io.Serializable;
import java.util.ArrayList;

import Id206550493.RealEstateAgency.ApartmentType;

public class ApartmentForSale extends Apartment implements ApartmentsInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1983283633197450377L;
	protected int commissionRate = 5; // Percent

	public ApartmentForSale(String address, int size, int numOfRooms, int rank, int price,
			ArrayList<Customer> allCustomers) throws Exception {
		super(ApartmentType.ApartmentForSale.ordinal(), address, size, numOfRooms, rank, price, allCustomers);

	}

	public int priceForEntireDuration() {
		return price;
	}

	public StringBuffer showApartment() {
		StringBuffer apartment = new StringBuffer(super.showApartments());
		apartment.append("Price for sale: " + price + "\n" + "*\n");
		return apartment;
	}

	@Override
	public int calculateCommission() {
		return commissionRate * (price / 100);
	}

}
