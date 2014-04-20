package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
	private String id;
	private String name;
	private String lastname;
	private String address;
	private String phone1;
	private String phone3;
	private String wphone1;
	private String mail1;
	private String mail2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;
	private String phone2;
	
	public ContactData(){
	}

	public ContactData(String name, String lastname, String address,
			String phone1, String phone3, String wphone1, String mail1,
			String mail2, String bday, String bmonth, String byear,
			String address2, String phone2) {
		this.setName(name);
		this.setLastname(lastname);
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
//  что бы было удобно читать, чтобы можно было объект "напечатать" на консоль или в лог-файл
	@Override
	public String toString() {
		return "ContactData [name=" + getName() + ", lastname=" + getLastname()
				+ "]";
	}
// equals чтобы сравнивать на "равно-не равно"
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (getLastname() == null) {
			if (other.getLastname() != null)
				return false;
		} else if (!getLastname().equals(other.getLastname()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}

	// это оптимизаци€ сравнени€: то есть сначала у двух объектов сравниваютс€ хешкоды, и только если они совпали тогда выполн€етс€ сравнение методом equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result
	//			+ ((lastname == null) ? 0 : lastname.hashCode());
	//	result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// чтобы сравнивать на "больше-меньше", то есть определ€ть пор€док (упор€дочение)
	@Override
	public int compareTo(ContactData other) {
		return this.getLastname().toLowerCase().compareTo(other.getLastname().toLowerCase());
	}
	public ContactData withId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @param phone3 the phone3 to set
	 */
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	/**
	 * @param wphone1 the wphone1 to set
	 */
	public void setWphone1(String wphone1) {
		this.wphone1 = wphone1;
	}

	/**
	 * @param mail1 the mail1 to set
	 */
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	/**
	 * @param mail2 the mail2 to set
	 */
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	/**
	 * @param bday the bday to set
	 */
	public void setBday(String bday) {
		this.bday = bday;
	}

	/**
	 * @param bmonth the bmonth to set
	 */
	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	/**
	 * @param byear the byear to set
	 */
	public void setByear(String byear) {
		this.byear = byear;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public ContactData withName(String name) {
		this.setName(name);
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.setLastname(lastname);
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withPhone1(String phone1) {
		this.phone1 = phone1;
		return this;
	}

	public ContactData withPhone3(String phone3) {
		this.phone3 = phone3;
		return this;
	}

	public ContactData withWphone1(String wphone1) {
		this.wphone1 = wphone1;
		return this;
	}

	public ContactData withMail1(String mail1) {
		this.mail1 = mail1;
		return this;
	}

	public ContactData withMail2(String mail2) {
		this.mail2 = mail2;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone3() {
		return phone3;
	}

	public String getWphone1() {
		return wphone1;
	}

	public String getMail1() {
		return mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}