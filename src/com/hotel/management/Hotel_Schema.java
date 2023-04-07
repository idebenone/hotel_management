/*AUHTOR VINEETH G */

package com.hotel.management;

import java.time.*;
import java.util.*;

public class Hotel_Schema {	
	private int roomNum, guestNum, stayDays, price, customerId;
	private String customerName;
	private LocalDate checkin, checkout;
	private boolean is_available = false; //additional
	private List<String> metadata; //additional
	
	//CONSTRUCTORS
	public Hotel_Schema(){};
		
	//GETTERS AND SETTERS
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getGuestNum() {
		return guestNum;
	}
	public void setGuestNum(int guestNum) {
		this.guestNum = guestNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	public boolean isIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	public List<String> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<String> metadata) {
		this.metadata = metadata;
	}
	public int getStayDays() {
		return stayDays;
	}
	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}

	@Override
	public String toString() {
		return customerId + ", " + customerName + ", " + roomNum + ", " + guestNum + ", " + stayDays + ", " + checkin + ", " + checkout + ", " + price ;
	}
}
