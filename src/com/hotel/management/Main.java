package com.hotel.management;

import java.time.*;
public class Main {

	public static void main(String[] args) {
		
		//TESTING METHODS
		
		//add user
		User_Schema u_s  = new User_Schema("Vineeth","G","address","Ilkal","Karnataka","587125");
		User_Management u_m = new User_Management();
//		u_m.addUser(u_s);
		
		//edit user based on name or id
		String[] editedValue = new String[]{"Vinith","G","address","Ilkal","Karnataka","587125"};
//		u_m.editUser("Vineeth G", editedValue);
		
		//delete user based on name or id
//		u_m.deleteUser(1);
		
		//book a room
//		Hotel_Schema h_s = new Hotel_Schema();
//		h_s.setRoomNum(147);
//		h_s.setGuestNum(2);
//		h_s.setStayDays(6);
//		h_s.setPrice(3000);
//		h_s.setCheckin(LocalDate.now());
//		h_s.setCheckout(h_s.getCheckin().plusDays(h_s.getStayDays()));
//		u_m.bookRoom("Vineeth G", h_s);

		u_m.checkOut(1);
	}

}
