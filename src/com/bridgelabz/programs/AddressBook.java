package com.bridgelabz.programs;

import java.io.IOException;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBook {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException {

		AddressBook book = new AddressBook();

		String file = "/home/bridgeit/Desktop/Address.json";

		Utility.display(Utility.readJSONArray("/home/bridgeit/Desktop/Address.json"));

		System.out.println("Enter your choice \n1.ADD \n \n3.DELETE \n4.SORT BOOK BY NAME\n");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			Utility.addRecord(file);
			break;
//		case 2:
//			book.editRecord(file);
//			break;
		case 3:
			Utility.deleteRecord(file);
			break;
		case 4:
			Utility.sortByName(file);
			break;
		default:
			System.out.println("invalid");
		}

		scanner.close();
	}		

	@SuppressWarnings("unchecked")
	public void editRecord(String file) throws IOException, ParseException {

		JSONObject bookRecords = Utility.readJSONFile(file);

		String choice[] = { "firstname", "laststname", "address", "city", "state", "zip", "phone" };
		System.out.println("Enter FIRST NAME  of record which you wants to edit");
		String name = scanner.next();
		System.out.println("enter number you want to edit \n1.FirstName\n2.LastName\n3.Address\n4.City \n5.State\n6.Zip\n7.Phone Number");
		int choiceIndex = scanner.nextInt();
		System.out.println("Enter " + choice[choiceIndex - 1]);
		String value = scanner.next();
		for (int i = 0; i < bookRecords.size(); i++) {
			JSONObject record = (JSONObject) bookRecords.get(i);
			if (String.valueOf(record.get("firstname")).equals(name)) {
				((JSONObject) bookRecords.get(i)).put(choice[choiceIndex - 1], value);
				Utility.writeJSONFile(file, bookRecords);
				System.out.println("Record updated");

				Utility.readJSONFile(file);
				break;
			}
		}
	}

	

}