package Id206550493;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import application.Screen;

public abstract class Apartment implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6809805706052971283L;
	protected static int counter = 0;
	protected int id;
	protected int apartmentType;
	protected String address;
	protected int size;
	protected int numOfRooms;
	protected int rank; // 1-10
	protected int price;
	protected ArrayList<Customer> allCustomers;

	public static Screen s = new Screen();

	public Apartment(int apartmentType, String address, int size, int numOfRooms, int rank, int price,
			ArrayList<Customer> allCustomers) throws Exception {
		if (!(address == null))
			this.id = ++counter;
		this.apartmentType = apartmentType;
		this.address = address;
		setSize(size);
		setNumOfRooms(numOfRooms);
		setRank(rank);
		setPrice(price);
		this.allCustomers = new ArrayList<Customer>();
	}

	public void fillCustomersList() {
		Customer C1 = new Customer("Tomer", 0543156713);// C-customer
		Customer C2 = new Customer("Noam", 0543156713);
		Customer C3 = new Customer("Yarden", 0523156135);
		Customer C4 = new Customer("Daniel", 0533152432);
		Customer C5 = new Customer("Chaim", 0573151027);
		addCustomer(C1);
		addCustomer(C2);
		addCustomer(C3);
		addCustomer(C4);
		addCustomer(C5);
		

	}

	public boolean addCustomer(Customer newCustomer) {
		for (Customer i : allCustomers) {
			if ((i.getPhoneNumber() == newCustomer.getPhoneNumber())) {
				System.out.println("The customer allrady in the list");
				s.showInformationDialog("Add customer", "The customer allrady in the list");
				return false;
			}
		}
		allCustomers.add(newCustomer);
		s.showInformationDialog("Add customer", "The customer was added successfully");
		return true;
	}

	public int getId() {
		return id;
	}

	public int getCounter() {
		return counter;
	}

	public String getAddress() {
		return address;
	}

	public int getSize() {
		return size;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public int getRank() {
		return rank;
	}

	public ArrayList<Customer> getAllCustomers() {
		return allCustomers;
	}

	public void setAllCustomers(ArrayList<Customer> allCustomers) {
		this.allCustomers = allCustomers;
	}

	public void setIdGenerator(int Idgeneretor) {
		Apartment.counter = Idgeneretor;
	}

	public void setSize(int size) throws Exception {
		if (size <= 0)
			throw new Exception("The size isn't bigger from 0");
		else
			this.size = size;
	}

	public void setNumOfRooms(int numOfRooms) throws Exception {
		if (numOfRooms <= 0)
			throw new Exception("The num of the rooms isn't bigger from 0");
		else
			this.numOfRooms = numOfRooms;
	}

	public void setRank(int rank) throws Exception {
		if (rank < 1 || rank > 10)
			throw new Exception("The rank isn't between 1-10");
		else
			this.rank = rank;
	}

	public void setPrice(int price) throws Exception {
		if (price <= 0)
			throw new Exception("The price isn't bigger from 0");
		else
			this.price = price;
	}

	public int priceForEntireDuration(int rentPeriod) {
		return price * rentPeriod;
	}

	public int priceForApartmentForSale() {
		return price;
	}

	/*public StringBuffer showApartmentsWithCustomers() {
		StringBuffer apartment = new StringBuffer();
		apartment.append("Id: " + id + "\nAddress: " + address + "\nSize: " + size + "\nNum of rooms: "
				+ numOfRooms + "\nRank: " + rank + "\nPrice: " + price + "\n");
		apartment.append("Interested customers:\n" + showAllCustomers() + "\n");
		return apartment;
	}*/
	
	public StringBuffer showApartments() {
		StringBuffer apartment = new StringBuffer();
		apartment.append("Id: " + id + "\nAddress: " + address + "\nSize: " + size + "\nNum of rooms: "
				+ numOfRooms + "\nRank: " + rank + "\nPrice: " + price + "\n*");
		return apartment;
	}

	public StringBuffer showAllCustomers() {
		StringBuffer customers = new StringBuffer();
		if(allCustomers.size() < 1) {
			customers.append("There are no interested customers");
			return customers;
		}
			
		int counter = 1;
		for (Customer i : allCustomers) {
			customers.append(counter + ":\n" + "Name: " + i.getName() + "\n" + "Phone Number: " + i.getPhoneNumber()
					+ "\n*\n");
			counter++;
		}
		return customers;
	}

	public void sortedCustomersListA(ArrayList<Customer> allCustomers) {
		Customer[] arr = allCustomers.toArray(new Customer[0]);
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				int length1 = arr[j].getName().codePointAt(0);
				int length2 = arr[j + 1].getName().codePointAt(0);
				if (length1 > length2) {
					Customer tempName = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tempName;
				}
			}
		}
		ArrayList<Customer> newCustomersList = new ArrayList<Customer>(Arrays.asList(arr));
		allCustomers.clear();
		allCustomers.addAll(newCustomersList);
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}