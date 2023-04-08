/* AUTHOR: VINEETH G */

package com.hotel.management;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User_Management {
	String userFile = "Users.txt";
	
	//INVOKE UTILITIES CLASS
	Utilities util = new Utilities();
	int lastId = 0;
	
	public User_Management(){
		lastId = util.getLastId(userFile);
		User_Schema.idGen = lastId + 1;
	}
		
	//USER CRUD OPERATIONS
	public void addUser(User_Schema u_s){	
		try {
			util.saveData(u_s.toString(),userFile);
		} catch (IOException e) {
//			e.printStackTrace();  // IGNORE THE EXCEPTION
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
	
	
}
