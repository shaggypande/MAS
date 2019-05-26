package com.tcs.ilp.ghy.G06.beans;

public class Customer {

	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String gender;
	private String date;
	private long mobile_no;
	private String email_id;
	private String location;
	private int customer_Id;
	
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customerId) {
		customer_Id = customerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobileNo) {
		mobile_no = mobileNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public long getContact_No() {
		return mobile_no;
	}
	public void setContact_No(long contactNo) {
		mobile_no = contactNo;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String emailId) {
		email_id = emailId;
	}
}
