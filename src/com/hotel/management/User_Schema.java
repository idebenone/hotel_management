/* AUTHOR : VINEETH G */

package com.hotel.management;

public class User_Schema {
	private String f_name, l_name, address , city, state , zip;
	private int id;
	public static int idGen = 1;
	
	
	//CONSTRUCTORS
	public User_Schema(){
		id = idGen++;
	}
	
	public User_Schema(String f_name, String l_name, String address, String city, String state, String zip) {
		this();
		this.f_name = f_name;
		this.l_name = l_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	//GETTERS AND SETTERS
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + ", " + f_name + ", " + l_name + ", " + address + ", " + city + ", " +  state + ", " + zip;
	}
	
	
	
}
