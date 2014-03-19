package com.example.tests;

public class ContactData {
	public String name;
	public String lastname;
	public String address;
	public String phone1;
	public String phone3;
	public String wphone1;
	public String mail1;
	public String mail2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String phone2;
	
	public ContactData(){
	}

	public ContactData(String name, String lastname, String address,
			String phone1, String phone3, String wphone1, String mail1,
			String mail2, String bday, String bmonth, String byear,
			String address2, String phone2) {
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.phone1 = phone1;
		this.phone3 = phone3;
		this.wphone1 = wphone1;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}