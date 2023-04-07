/* AUTHOR: VINEETH G */

package com.hotel.management;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User_Management {
	String userFile = "Users.txt";
	String roomFile = "Rooms.txt";
	
	//INVOKE UTILITIES CLASS
	Utilities util = new Utilities();
	int lastId = 0;
	
	public User_Management(){
		try {
			lastId = util.getLastId(userFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		User_Schema.idGen = lastId + 1;
	}
		
	//USER CRUD OPERATIONS
	public void addUser(User_Schema u_s){	
		try {
			util.saveData(u_s.toString(),userFile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void editUser(Object obj,String[] newData){
		try {
			util.editData(obj, newData,userFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(Object obj){
		try {
			util.deleteData(obj, userFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//BOOK A ROOM or check-in
	public void bookRoom(Object obj, Room_Schema h_s){
		try {
			String[] val = util.getData(obj, userFile).split(",");
			if(val.length > 1){
				System.out.println("Booking room for" + val[1] + " " + val[2]);
				h_s.setCustomerId(Integer.parseInt(val[0]));
				h_s.setCustomerName(val[1] + " " + val[2]);
				util.saveData(h_s.toString(), roomFile);
			}else{
				System.out.print("The user doesn't exist. Kindly register the user");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//CHECK OUT ALONG WITH PAYMENT DETAILS
	public void checkOut(Object obj){
		try {
			String[] val = util.getData(obj, roomFile).split(",");
			if(val.length > 1){
				if(ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(val[5].trim())) == 0){
					showBill(Integer.parseInt(val[7].trim()),1);
				}else{
					showBill(Integer.parseInt(val[7].trim()) ,  ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(val[5].trim())));					
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
	
}
