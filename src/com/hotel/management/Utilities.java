/*AUTHOR : VINEETH G*/

package com.hotel.management;

import java.io.*;
import java.util.Arrays;
public class Utilities {
	
	// SAVES USER DATA TO USER.TXT FILE
	public void saveData(String data, String fileName) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
		System.out.println(data);
		bw.write(data);
		bw.newLine();
		bw.close();
		System.out.println("Data has been saved successfully");
	}
	
	
	//GET SAVED DATA FROM USER.TXT FILE
	public String getData(Object input,String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		String res = "";
		if(input instanceof String){
	        while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            String fullName = parts[1].trim() + " " + parts[2].trim();
	            if (fullName.equals(input)) {
	            	res = line;
	            }else{
	            	res = "";
	            }
	        } 
		}else{
	        while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            if (parts[0].trim().equalsIgnoreCase(Integer.toString((int) input))) {
	            	res = line;
	            }else{
	            	res = "";
	            }
	        } 
		}
		br.close();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DATA FOUND!");
		return res;
	}
	
	//EDIT DATA FROM USER.TXT FILE
	public void editData(Object input, String[] newData, String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".temp"));

	    String line;
	    boolean found = false;

	    // SEARCH FOR THE DATA
	    if (input instanceof String) {
	        while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            for (int i = 0; i < parts.length; i++) {
	                parts[i] = parts[i].trim();
	            }
	            String fullName = parts[1].trim() + " " + parts[2].trim();
	            if (fullName.equals(input)) {
	                parts[1] = newData[0].trim();
	                parts[2] = newData[1].trim();
	                parts[3] = newData[2].trim();
	                parts[4] = newData[3].trim();
	                parts[5] = newData[4].trim();
	                parts[6] = newData[5].trim();
	                parts[7] = newData[6].trim();
	                found = true;
	            }
	            String newLine = String.join(", ", parts);
	            bw.write(newLine + "\n");
	        }     
	    } else {        
	    	while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            for (int i = 0; i < parts.length; i++) {
	                parts[i] = parts[i].trim();
	            }
	            if (parts[0].equals(Integer.toString((int) input))){
	                parts[1] = newData[0].trim();
	                parts[2] = newData[1].trim();
	                parts[3] = newData[2].trim();
	                parts[4] = newData[3].trim();
	                parts[5] = newData[4].trim();
	                parts[6] = newData[5].trim();
	                parts[7] = newData[6].trim();
	                found = true;
	            }
	            String newLine = String.join(", ", parts);
	            bw.write(newLine + "\n");
	        }   
	    }
	    br.close();
	    bw.close();
	    
	    if (found) {
	        File originalFile = new File(fileName);
	        originalFile.delete();
	        File tempFile = new File(fileName + ".temp");
	        tempFile.renameTo(originalFile);
	        System.out.println("Edited Successfully!");
	    } else {
	        File tempFile = new File(fileName + ".temp");
	        tempFile.delete();
	        System.out.println("User not found!");
	    }
	}

	
	//DELETE DATA FROM USER.TXT FILE
	public void deleteData(Object input, String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".temp"));
	    
	    String line;
	    boolean found = false;

	    // SEARCH FOR THE DATA
	    if (input instanceof String) {
	        while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            String fullName = parts[1] + " " + parts[2];
	            if (fullName.equals(input))
	                found = true;
	            else            	
	            	bw.write(line + "\n");  
	        }
	    } else {
	    	while ((line = br.readLine()) != null) {
	            String parts[] = line.split(",");
	            if (parts[0].equals(Integer.toString((int) input)))
	                found = true;
	            else
	            	bw.write(line + "\n");	            	          
	        }
	    } 
	    br.close();
	    bw.close();
	    
	    if (found) {
	        File originalFile = new File(fileName);
	        originalFile.delete();
	        File tempFile = new File(fileName + ".temp");
	        tempFile.renameTo(originalFile);
	        System.out.println("Deleted Successfully!");
	    } else {
	        File tempFile = new File(fileName + ".temp");
	        tempFile.delete();
	        System.out.println("User not found!");
	    }
	}
	
	//GET LAST ID FROM THE FILE
	public int getLastId(String filename){
//		int lastId = 0;
//		BufferedReader br = new BufferedReader(new FileReader(filename));
//		String line;
//        while((line = br.readLine()) != null) {
//            String[] values = line.split(",");
//            lastId = Integer.parseInt(values[0].trim());
//        }
//        br.close();
//        return lastId;
		
	    int lastId = 0;
	    BufferedReader br = null;
	    try {
	        br = new BufferedReader(new FileReader(filename));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] values = line.split(",");
	            lastId = Integer.parseInt(values[0].trim());
	        }
	    } catch (IOException e) {
	        // Ignore the exception
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                // Ignore the exception
	            }
	        }
	    }
	    return lastId;
	}
	
	
	public void getRoomList(String category, String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
            String parts[] = line.split(",");
            if (parts[2].trim().equalsIgnoreCase(category) && parts[4].trim().equalsIgnoreCase("true")){
            	System.out.println(line);
            }
        } 
	    br.close();
	}
	
	
	public void updateRoomStatus(int roomId, String[] newData, String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".temp"));

	    String line;
	    boolean found = false;

	    // SEARCH FOR THE DATA
    	while ((line = br.readLine()) != null) {
            String parts[] = line.split(",");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }
            if (Integer.parseInt(parts[0].trim())== roomId){
            	parts[4] = newData[3];
                parts[5] = newData[0]; 
                parts[6] = newData[1];
                parts[7] = newData[2];
                found = true;
            }
            String newLine = String.join(", ", parts);
            bw.write(newLine + "\n");
        }   
    
	    br.close();
	    bw.close();
	    
	    if (found) {
	        File originalFile = new File(fileName);
	        originalFile.delete();
	        File tempFile = new File(fileName + ".temp");
	        tempFile.renameTo(originalFile); 
	    } else {
	        File tempFile = new File(fileName + ".temp");
	        tempFile.delete();
	        System.out.println("User not found!");
	    }
	}


}
