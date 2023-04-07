package com.hotel.management;

import java.time.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		User_Management u_m = new User_Management();
		int choice = 0;
		do{
			System.out.println("********************************************************************************************");
			System.out.println("********************************************************************************************");
			System.out.println("===================================WELCOME TO BLAH BLAH=====================================");
			System.out.println("********************************************************************************************");
			System.out.println("********************************************************************************************");
			System.out.println();
			System.out.println("1. ADD CUSTOMER DETAILS");
			System.out.println("2. EDIT CUSTOMER DETAILS");
			System.out.println("3. BOOK A ROOM / RESERVATION ");
			System.out.println("4. CHECKOUT CUSTOMER");
			System.out.println("5. DELETE CUSTOMER DETAILS");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1: System.out.println("Please Enter Customer First Name: ");
						String f_name = sc.nextLine();
						
						System.out.println("Please Enter Customer Last Name: ");
						String l_name = sc.nextLine();
						
						System.out.println("Please Enter Customer Phone: ");
						long phone = sc.nextLong();
						sc.nextLine();
						
						System.out.println("Please Enter Customer Address: ");
						String address = sc.nextLine();
						
						System.out.println("Please Enter Customer City: ");
						String city = sc.nextLine();
						
						System.out.println("Please Enter Customer State: ");
						String state = sc.nextLine();
						
						System.out.println("Please Enter Customer Zip: ");
						String zip = sc.nextLine();
						
						User_Schema u_s = new User_Schema(f_name,l_name,phone,address,city,state,zip);
						u_m.addUser(u_s);
						break;
				
				case 2: System.out.println("Please enter Customer ID or Customer Full Name to edit: ");
						Object input;
					    if (sc.hasNextInt()){
					        input = sc.nextInt();
					    } else {
					        input = sc.nextLine();
					    }
						System.out.println();
						System.out.println("EDITING USER DETAILS NOW: ");
						System.out.println("Please Enter Customer First Name: ");
						String ef_name = sc.nextLine();
						
						System.out.println("Please Enter Customer Last Name: ");
						String el_name = sc.nextLine();
						
						System.out.println("Please Enter Customer Phone: ");
						long ephone = sc.nextLong();
						sc.nextLine();
						
						System.out.println("Please Enter Customer Address: ");
						String eaddress = sc.nextLine();
						
						System.out.println("Please Enter Customer City: ");
						String ecity = sc.nextLine();
						
						System.out.println("Please Enter Customer State: ");
						String estate = sc.nextLine();
						
						System.out.println("Please Enter Customer Zip: ");
						String ezip = sc.nextLine();
						
						String[] newData = {ef_name,el_name,Double.toString(ephone),eaddress,ecity,estate,ezip};
						u_m.editUser(input, newData);
						break;
				
				case 3 :Room_Schema h_s = new Room_Schema();
						System.out.println("Please enter Customer ID or Customer Full Name to continue booking: ");
						Object input_b;
					    
						if (sc.hasNextInt()){
					        input_b = sc.nextInt();
					    } else {
					        input_b = sc.nextLine();
					    }
					    
						System.out.println();
						System.out.println("1.Please enter no of guests staying: ");
						int guestsNum = sc.nextInt();
						h_s.setGuestNum(guestsNum);
						
						System.out.println("2.Please enter checkout date: ");
						LocalDate checkOutDate = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
						h_s.setCheckin(LocalDate.now());
						h_s.setCheckout(checkOutDate);
						
						System.out.println("Please enter the room price per night: ");
						int price = sc.nextInt();
						h_s.setPrice(price);
						
						u_m.bookRoom(input_b, h_s);
						break;
						
			}
		}while(choice>0);

	}

}
