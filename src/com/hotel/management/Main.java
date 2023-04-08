package com.hotel.management;

import java.io.IOException;
import java.time.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		String[] categories = {"SINGLE" , "DOUBLE", "FAMILY", "PREMIUM"};
		User_Management u_m = new User_Management();
		Room_Management m_m  = new Room_Management();
		int choice = 0;
		do{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("**********************************|---------------------|************************************");
			System.out.println("----------------------------------|WELCOME TO BLAH BLAH |------------------------------------");
			System.out.println("**********************************|---------------------|************************************");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("1. ADD CUSTOMER DETAILS");
			System.out.println("2. BOOK A ROOM / RESERVATION ");
			System.out.println("3. CHECKOUT CUSTOMER");
			System.out.println("4. -------");
			System.out.println("5. -------");
			System.out.println("6. -------");
			System.out.println("7. -------");
			System.out.println("8. -------");
			System.out.println("9. ADMIN ONLY");
			
			System.out.println();
			System.out.print("Please select an option: ");
			System.out.println();
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1: System.out.print("Please Enter Customer First Name: ");
						String f_name = sc.nextLine();
						
						System.out.print("Please Enter Customer Last Name: ");
						String l_name = sc.nextLine();
						
						System.out.print("Please Enter Customer Phone: ");
						long phone = sc.nextLong();
						sc.nextLine();
						
						System.out.print("Please Enter Customer Address: ");
						String address = sc.nextLine();
						
						System.out.print("Please Enter Customer City: ");
						String city = sc.nextLine();
						
						System.out.print("Please Enter Customer State: ");
						String state = sc.nextLine();
						
						System.out.print("Please Enter Customer Zip: ");
						String zip = sc.nextLine();
						
						User_Schema u_s = new User_Schema(f_name,l_name,phone,address,city,state,zip);
						u_m.addUser(u_s);
						break;
				
				case 2 :System.out.println("Please select a category to book room: ");
						System.out.println("1. SINGLE");
						System.out.println("2. DOUBLE");
						System.out.println("3. FAMILY");
						System.out.println("4. PREMIUM");
						
						int b_cat_choice = sc.nextInt();
						String b_category = categories[b_cat_choice - 1];
						System.out.println("You have selected " + b_category);
						System.out.println();
						System.out.println("CHECKING ALL AVAILABLE ROOMS");
						System.out.println("*********************************************");
						m_m.getRoomOnCategory(b_category);
						
						System.out.print("Please enter the roomId that you want to book: ");
						int roomId = sc.nextInt();
						sc.nextLine();
						System.out.print("Please enter customer Id or full name to continue booking: ");
						Object cusName;
					    if (sc.hasNextInt()){
					        cusName = sc.nextInt();
					    } else {
					        cusName = sc.nextLine();
					    }
					    System.out.print("Please enter the checkout date in YYYY MM DD format ");
					    int year = sc.nextInt();
					    int month = sc.nextInt();
					    int day = sc.nextInt();
						
					    LocalDate checkout = LocalDate.of(year, month, day);
						m_m.bookRoom(cusName, roomId,checkout);
						break;
						
				case 4: System.out.print("Please enter the room ID to checkout: ");
						int id = sc.nextInt();
						
						m_m.checkOut(id);
						
				case 9: Room_Schema r_s = new Room_Schema();
						System.out.println("ADMIN FUNCTIONS");
						System.out.println();
						System.out.println("1. ADD ROOMS");
						System.out.println("2. EDIT ROOMS");
						System.out.println("3. DELETE ROOMS");
						System.out.println("4. EDIT USERS");
						System.out.println("5. DELETE USERS");
						int admin_choice = sc.nextInt();
						switch(admin_choice){
							case 1: System.out.println("ADDING ROOM DETAILS: ");								
									System.out.println("Please select the category for the room: ");
									System.out.println("1. SINGLE");
									System.out.println("2. DOUBLE");
									System.out.println("3. FAMILY");
									System.out.println("4. PREMIUM");
									
									int cat_choice = sc.nextInt();
									String category = categories[cat_choice - 1];
									r_s.setCategory(category);
									sc.nextLine();
									
									System.out.print("Please enter the price of the room: ");
									int price = sc.nextInt();
									r_s.setPrice(price);
									
									m_m.addRoom(r_s);
									break;
									
							case 4:	System.out.print("Please enter Customer ID or Customer Full Name to edit: ");
									Object input;
								    if (sc.hasNextInt()){
								        input = sc.nextInt();
								    } else {
								        input = sc.nextLine();
								    }
								    sc.nextLine();
								    
									System.out.println();
									System.out.println("EDITING USER DETAILS NOW: ");
									System.out.print("Please Enter Customer First Name: ");
									String ef_name = sc.nextLine();
									
									System.out.print("Please Enter Customer Last Name: ");
									String el_name = sc.nextLine();
									
									System.out.print("Please Enter Customer Phone: ");
									long ephone = sc.nextLong();
									sc.nextLine();
									
									System.out.print("Please Enter Customer Address: ");
									String eaddress = sc.nextLine();
									
									System.out.print("Please Enter Customer City: ");
									String ecity = sc.nextLine();
									
									System.out.print("Please Enter Customer State: ");
									String estate = sc.nextLine();
									
									System.out.print("Please Enter Customer Zip: ");
									String ezip = sc.nextLine();
									
									String[] newData = {ef_name,el_name,Long.toString(ephone),eaddress,ecity,estate,ezip};
									u_m.editUser(input, newData);
									break;
									
						}
						
			}
		}while(choice>0);

	}

}
