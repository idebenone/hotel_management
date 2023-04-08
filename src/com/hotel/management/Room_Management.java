package com.hotel.management;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Room_Management {
	private String roomFile = "Rooms.txt";
	private String userFile = "Users.txt";
	
	Utilities util = new Utilities();
	int lastId = 0;
	
	public Room_Management(){
		lastId = util.getLastId(roomFile);
		Room_Schema.roomNumGen = lastId + 1;
	}
	
	public void addRoom(Room_Schema r_s){
		try {
			util.saveData(r_s.addRoom(), roomFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editRoom(int id){
		
	}
	
	public void deleteRoom(int id){
		
	}
	
	public void getRoomOnCategory(String category){
		try {
			util.getRoomList(category, roomFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//CHECK - IN User
	public void bookRoom(Object userId, int roomId, LocalDate checkout){ // check rooms and get an id
		try {
			String[] val = util.getData(userId, userFile).split(",");
			if(val.length > 1){
				System.out.println("Booking room for " + val[1].trim() + " " + val[2].trim());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String[] newData ={val[0].trim(),LocalDate.now().format(formatter),checkout.format(formatter),"false"}; //format the LocalDate values to String
				util.updateRoomStatus(roomId, newData, roomFile);
				System.out.println("The Room has been booked successfully!");
			}else{
				System.out.println("The user doesn't exist. Kindly register the user");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//CHECK OUT ALONG WITH PAYMENT DETAILS
	public void checkOut(int roomId, int type){
		try {
			String[] val = util.getData(roomId, roomFile).split(",");
			if(val.length > 1){
				if(type == 1){
					if(ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(val[5].trim())) == 0)
						showBill(Integer.parseInt(val[2].trim()),1);
					else
						showBill(Integer.parseInt(val[2].trim()) , ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(val[5].trim())));
					
					String[] newData ={"0","null","null","true"}; 
					util.updateRoomStatus(roomId, newData, roomFile);
					System.out.println("Checkout Successfull!");
				}else{
					String[] newData ={"0","null","null","true"}; 
					util.updateRoomStatus(roomId, newData, roomFile);
					System.out.println("Reservation has been successfully cancelled");
				}
				

			}else{
				System.out.print("No user found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showBill(int price, long stayDays){
		System.out.println("HOPE YOU ENJOYED YOUR STAY AT BLAH BLAH");
		System.out.println("Your Bill is Rs." +  price*stayDays + " for " + stayDays + " Day(s)");
	}
	
	//RESERVE A ROOM FOR A CUSTOMER
	public void reserveRoom(Object userId, int roomId, LocalDate checkin, LocalDate checkout){
		try {
			String[] val = util.getData(userId, userFile).split(",");
			if(val.length > 1){
				System.out.println("Booking room for " + val[1].trim() + " " + val[2].trim());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String[] newData ={val[0].trim(),checkin.format(formatter),checkout.format(formatter),"false"}; //format the LocalDate values to String
				util.updateRoomStatus(roomId, newData, roomFile);
				System.out.println("The Room has been booked successfully!");
			}else{
				System.out.print("The user doesn't exist. Kindly register the user");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
