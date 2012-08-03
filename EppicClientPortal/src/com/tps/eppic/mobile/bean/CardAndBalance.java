package com.tps.eppic.mobile.bean;

public class CardAndBalance {

	private int personId = -1;
	private String firstName = null;
	private String lastName = null;
	
	private String address1 = null;
	private String address2 = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	
	private String pan = null;
	private String balance = null;
	
	private String notifMethod = null;
	private String notif = null;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getNotifMethod() {
		return notifMethod;
	}
	public void setNotifMethod(String notifMethod) {
		this.notifMethod = notifMethod;
	}
	public String getNotif() {
		return notif;
	}
	public void setNotif(String notif) {
		this.notif = notif;
	}
	
}
