package Id206550493;

import java.io.Serializable;
import java.util.ArrayList;

import Id206550493.RealEstateAgency.ApartmentType;



public abstract class ApartmentsForRent extends Apartment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -74273262033268874L;

	public ApartmentsForRent(int apartmentType, String address, int size, int numOfRooms, int rank, int price,
			ArrayList<Customer> allCustomers) throws Exception {
		super(ApartmentType.ApartmentForOriginalRent.ordinal(),address, size, numOfRooms, rank, price, allCustomers);

	}

	public StringBuffer showApartment() {
		StringBuffer apartment = new StringBuffer(super.showApartments());
		apartment.append("Price for rental: " + price + "\n" + "*\n");
		return apartment;
	}

}
