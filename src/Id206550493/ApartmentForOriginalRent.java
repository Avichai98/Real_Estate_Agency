package Id206550493;

import java.io.Serializable;
import java.util.ArrayList;

import Id206550493.RealEstateAgency.ApartmentType;



public class ApartmentForOriginalRent extends ApartmentsForRent implements ApartmentsInterface,  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5596852733284520519L;
	protected int numOfMonths;
	protected int commissionRate = 4000;

	public ApartmentForOriginalRent(String address, int size, int numOfRooms, int rank, int price,
			ArrayList<Customer> allCustomers) throws Exception {
		super(ApartmentType.ApartmentForOriginalRent.ordinal(), address, size, numOfRooms, rank, price, allCustomers);
	}

	public int priceForEntireDuration(int months) {
		return price * months;
	}

	@Override
	public int calculateCommission() {
		return commissionRate;
	}

}
