package com.tcs.ilp.ghy.G06.beans;
/**
* The descriptive text that explaining the purpose and use of the class.
      * @author : Sonal Ruhatiya  
      * @version : 1     
      * @Class name :Admin
      * @Creation Date :23/11/13	
     * @ History : Admin class is created for accepting the admin details  
*/

public class Admin 
{
 private int adminId;
 private String password;
 private int roleId;
 private String firstName;
 private String lastName;
 private String Gender;
 private String dateOfBirth;
 private String emailId;
 private int mobileNo;
 private String city;
 private String location;

 public int getAdminId()
 {
	return adminId;
 }
 public void setAdminId(int adminId) 
 {
	this.adminId = adminId;
 }
 public String getFirstName() 
 {
	return firstName;
 }
 public void setFirstName(String firstName) 
 {
	this.firstName = firstName;
 }
 public String getLastName() 
 {
	return lastName;
 }
 public void setLastName(String lastName)
 {
	this.lastName = lastName;
 }
 public String getGender()
 {
	return Gender;
 }
 public void setGender(String gender) 
 {
	Gender = gender;
 }
 public String getDateOfBirth()
 {
	return dateOfBirth;
 }
 public void setDateOfBirth(String dateOfBirth)
 {
	this.dateOfBirth = dateOfBirth;
 }
 public String getEmailId() 
 {
	return emailId;
 }
 public void setEmailId(String emailId) 
 {
	this.emailId = emailId;
 }

 public String getPassword() 
 {
	return password;
 }
 public int getRoleId() 
 {
	return roleId;
 }
 public void setRoleId(int roleId)
 {
	this.roleId = roleId;
 }
 public void setPassword(String password) 
 {
	this.password = password;
 }
 public int getMobileNo()
 {
	return mobileNo;
 }
 public void setMobileNo(int mobileNo)
 {
	this.mobileNo = mobileNo;
 }
 public String getCity() 
 {
	return city;
 }
 public void setCity(String city) 
 {
	this.city = city;
 }
 public String getLocation() 
 {
	return location;
 }
 public void setLocation(String location)
 {
	this.location = location;
 }

}
