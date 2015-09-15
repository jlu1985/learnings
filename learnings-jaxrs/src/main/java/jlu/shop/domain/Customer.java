package jlu.shop.domain;

public class Customer {
	private String city;
	private String country;
	private String firstname;
	private int id;
	private String lastname;
	private String state;
	private String street;
	private String zip;
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getFirstname() {
		return firstname;
	}
	public int getId() {
		return id;
	}
	public String getLastname() {
		return lastname;
	}
	public String getState() {
		return state;
	}
	public String getStreet() {
		return street;
	}
	public String getZip() {
		return zip;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
