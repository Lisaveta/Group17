package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
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
//  ��� �� ���� ������ ������, ����� ����� ���� ������ "����������" �� ������� ��� � ���-����
	@Override
	public String toString() {
		return "ContactData [name=" + name + ", lastname=" + lastname
				+ ", address=" + address + ", phone1=" + phone1 + ", phone3="
				+ phone3 + ", mail1=" + mail1 + ", mail2=" + mail2 + "]";
	}
// ����� ���������� �� "�����-�� �����"
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
//		if (address == null) {
//			if (other.address != null)
//				return false;
//		} else if (!address.equals(other.address))
//			return false;
//		if (lastname == null) {
//			if (other.lastname != null)
//				return false;
//		} else if (!lastname.equals(other.lastname))
//			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
//		if (phone1 == null) {
//			if (other.phone1 != null)
//				return false;
//		} else if (!phone1.equals(other.phone1))
//			return false;
		return true;
	}

	// ��� ����������� ���������: �� ���� ������� � ���� �������� ������������ �������, � ������ ���� ��� ������� ����� ����������� ��������� ������� equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((address == null) ? 0 : address.hashCode());
		//result = prime * result
		//		+ ((lastname == null) ? 0 : lastname.hashCode());
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		return result;
	}

	// ����� ���������� �� "������-������", �� ���� ���������� ������� (������������)
	@Override
	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}

}