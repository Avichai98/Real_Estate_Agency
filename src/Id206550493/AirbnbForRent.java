package Id206550493;

import java.io.Serializable;
import java.util.ArrayList;

import Id206550493.RealEstateAgency.ApartmentType;


public class AirbnbForRent extends ApartmentsForRent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2828369450732808781L;

	public AirbnbForRent( String address, int size, int numOfRooms, int rank, int price,
			ArrayList<Customer> allCustomers) throws Exception {
		super(ApartmentType.AirbnbForRent.ordinal(), address, size, numOfRooms, rank, price, allCustomers);
	}

	public int priceForEntireDuration(int days) {
		return price * days;
	}

}
