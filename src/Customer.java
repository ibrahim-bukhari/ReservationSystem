
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	private static int counter = 1;
	
	Customer(String firstName, String lastName, String phoneNumber) {
		setId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return this.id;
	}
	private void setId() {
		this.id = counter++;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(id);
		b.append(". ");
		b.append(firstName);
		b.append(" ");
		b.append(lastName);
		return b.toString();
	}
}
