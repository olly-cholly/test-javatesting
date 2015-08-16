package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of tast data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remote it manualy: " + file);
			return;
		}
			
		List<ContactData> contacts = generateRandomContact(amount);
		if ("csv".equals(format)) {
			saveContactToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactToXmlFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveContactToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getLastname() + "," + contact.getFirstname() + "," + contact.getAddress1() + "," + contact.getHome() + "," + contact.getMobile() + "," + contact.getWork() + "," + contact.getEmail1() + "," + contact.getEmail2() + "," + contact.getBday() + "," + contact.getBmonth() + "," + contact.getByear() + "," + contact.getGroup() + "," 
					+ contact.getAddress2() + "," + contact.getPhone() + ",|" + "\n");			
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withLastname(part[0])
				.withFirstname(part[1])
				.withAddress1(part[2])
				.withHome(part[3])
				.withMobile(part[4])
				.withWork(part[5])
				.withEmail1(part[6])
				.withEmail2(part[7])
				.withBday(part[8])
				.withBmonth(part[9])
				.withByear(part[10])
				.withGroup(part[11])
				.withAddress2(part[12])
				.withPhone(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
		}
	
	public static List<ContactData> generateRandomContact(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
				.withLastname(generateRandomString())
				.withFirstname(generateRandomString())
				.withAddress1(generateRandomString())
				.withHome(generateRandomString())
				.withMobile(generateRandomString())
				.withWork(generateRandomString())
				.withEmail1(generateRandomString())
				.withEmail2(generateRandomString())
				.withBday("-")
				.withBmonth("-")
				.withByear(generateRandomString())
				.withGroup("")
				.withAddress2(generateRandomString())
				.withPhone(generateRandomString());
			list.add(contact);
		}
		return list;
		}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
}
