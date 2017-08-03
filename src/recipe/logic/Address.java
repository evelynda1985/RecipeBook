package recipe.logic;

public class Address {
	private String address;
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	private String city;
	private String state;
	private String zip;
	
	
	public Address(String address, String city, String state, String zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString(){
		return "Address: " + address + ", " + city + ", " + state +", " + zip;
	}
	
	
	
	
}
