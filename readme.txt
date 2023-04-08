HOTEL MANAGEMENT SYSTEM

There are 5 Primary Functions and 4 Admin Functions.
Primary Functions includes Registering Customer Details, Alloting a room to the customer, Customer checkout, Room Reservation for Customers and Cancelling reservation.

Admin Functions includes Enter rooms related data, Delete data related to the rooms, Edit Registered Users and Deleter Registered Users.


1) ADD CUSTOMER DETAILS

Parameters :Customer Id(Auto Generated), First Name, Last Name, Phone, Address, City, State, Zip.





2) EDIT CUSTOMER DETAILS

editUser() under User_Management.java first searches the user by ID or by Full Name.

While reading through the file, we keep matching the Full Name or ID. 
A flag called 'found' is updated if data is found in the line. And prior to that, we will swap the detail part by part.
If found is true then we copy data from original file to a new temp file. While doing this, the edited data gets written on 
the temp file. Later we will delete the original file amd rename the temp file to original file.
If data is never found, then the newly created  temp file is deleted.




3)DELETE CUSTOMER DETAILS

The approach is similar like we did in editing user details. Here if data is found we will not write that to the temp file. But 
we will write the remaining data to temp file, rename it to original.



  