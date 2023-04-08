
/*AUHTOR VINEETH G */

package com.hotel.management;

import java.time.*;
import java.util.*;

public class Room_Schema {	
	private int roomNum,price, customerId;
	private String customerName, category;
	private LocalDate checkin, checkout;
	private boolean is_available = true;
	public static int roomNumGen;
	
	//CONSTRUCTORS
	public Room_Schema(){
		roomNum = roomNumGen++;
	};
		
	//GETTERS AND SETTERS
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	public String addRoom(){
		return roomNum + ", " + category + ", " + price + ", " + is_available + ", " + customerId + ", " + checkin + ", " + checkout ;
	}

	@Override
	public String toString() {
		return customerId + ", " ;
	}
}
