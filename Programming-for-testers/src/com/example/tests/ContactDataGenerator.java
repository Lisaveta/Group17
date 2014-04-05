package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <fie> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File axists, please remove it manually:" + file);
			return;
			
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
		saveContactsToCsvFile(contacts, file); 
		}else if("xml".equals(format)){
			saveContactsToXmlFile(contacts, file); 
		}else{
			System.out.println("Unknoun format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
	XStream xstream	= new XStream();
	xstream.alias("contact", ContactData.class);
	String xml = xstream.toXML(contacts);
	FileWriter writer = new FileWriter(file);
	writer.write(xml);
	writer.close();
		}
	
	public static List<ContactData> loadContactsFromXmlFilel(File file) {
		XStream xstream	= new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
		 
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts){
			writer.write(contact.getName() + "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getPhone1() + 
					"," + contact.getPhone3() + "," + contact.getWphone1() + "," + contact.getMail1() + "," + contact.getMail2() + "," + contact.getBday() +
					"," + contact.getBmonth() + "," + contact.getByear() + "," + contact.getAddress2() + "," + contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
// организация цикла типа while  - пока 	выполняется условие
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withName(part[0])
			.withLastname(part[1])
			.withAddress(part[2])
			.withPhone1(part[3])
			.withPhone3(part[4])
			.withWphone1(part[5])
			.withMail1(part[6])
			.withMail2(part[7])
//			.withBday(part[8])
//			.withBmonth(part[9])
			.withByear(part[10])
			.withAddress2(part[11])
			.withPhone2(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();	
		}
		bufferedReader.close();
		return list;
		}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withName(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withPhone1(generateRandomPhone())
			.withPhone3(generateRandomPhone())
			.withWphone1(generateRandomPhone())
			.withMail1(generateRandomEmail())
			.withMail2(generateRandomEmail())
			.withByear(generateRandomString())
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomPhone());
			list.add(contact);
		}
			return list;
	}
	public static String generateRandomString(){
		Random rnd = new Random();
//		if (rnd.nextInt(3) == 0) {
//			return "";
//		}else{
			return "test" + rnd.nextInt();
		}
	
	public static String generateRandomEmail(){
		Random rnd = new Random();
//		if (rnd.nextInt(3) == 0) {
//			return "";
//		}else{
			return rnd.nextInt() +"@mail.ru";
		}
	public static String generateRandomPhone(){
		Random rnd = new Random();
//		if (rnd.nextInt(3) == 0) {
//			return "";
//		}else{
			return "+7" + rnd.nextInt();
		}
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream	= new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
		 
	}

}
