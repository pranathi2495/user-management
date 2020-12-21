package com.manthan.user.dto;

public class UserAddress {
	protected int userid;
	protected String address;
	protected String landmark;
	protected long pincode;
	protected String city;
	protected String state;
	public UserAddress(int userid, String address, String landmark, long pincode, String city, String state) {
		super();
		this.userid = userid;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		
		
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
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
	
	
	
}
