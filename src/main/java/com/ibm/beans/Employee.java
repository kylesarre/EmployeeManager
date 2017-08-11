package com.ibm.beans;

public class Employee 
{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String cellPhone;
	private String homePhone;
	private String email;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10)
	{
		setFirstName(s1);
		setLastName(s2);
		setAddress(s3);
		setCity(s4);
		setState(s5);
		setZip(s6);
		setCellPhone(s7);
		setHomePhone(s8);
		setEmail(s9);
		setId(s10);
	}
	public Employee(String[] fields)
	{
		firstName = fields[0];
		lastName = fields[1];
		address = fields[2];
		city = fields[3];
		state = fields[4];
		zip = fields[5];
		cellPhone = fields[6];
		homePhone = fields[7];
		email = fields[8];
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
