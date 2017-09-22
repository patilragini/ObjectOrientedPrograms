/*************************************************
 *@author:Patil Ragini
 *@version: 1.8
 *@since: 19-08-2017

 **************************************************/
package com.bridgelabz.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {
	/**
	 * @param string
	 * @param firstName
	 * @param fullName
	 * @param phno
	 * @param date
	 *            <p>
	 *            replaces and print replaced string
	 */
	public static void regularExpresion(String string, String firstName, String fullName, String phno, String date) {
		String replacefname = string.replace("<<name>>", firstName);
		String replacefullname = replacefname.replace("<<full name>>", fullName);
		String replacephno = replacefullname.replace("xxxxxxxxxx", phno);
		String replacedate = replacephno.replace("01/01/2016", date);
		System.out.println(replacedate);
	}

	@SuppressWarnings("unchecked")
	/**
	 * @return JSONArray enters data to json file and returns inventory
	 */
	public static JSONArray writeJSON() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String itemarray[] = { "Rice", "Wheat", "pulse" };

		// json array inventory
		// itemarray[itemarray.length+1];
		JSONArray inventory = new JSONArray();

		System.out.println("enter  quantity of product(rice,wheat,pulses):");
		int quantity = scanner.nextInt();
		for (int j = 0; j < quantity; j++) {
			// System.out.println(j);
			// after 3rd element rice will repeat
			for (int i = 0; i < itemarray.length; i++) {

				// create object item to add name weight price
				JSONObject item = new JSONObject();

				System.out.println("Enter data of " + itemarray[i]);
				System.out.println("Name Of " + itemarray[i]);
				String name = scanner.next();
				System.out.println("weight (in KG)");
				float weight = scanner.nextFloat();
				System.out.println("Price");
				float price = scanner.nextFloat();
				item.put("Name", name);
				item.put("weight", weight);
				item.put("price", price);
				inventory.add(item);
			}
			try (FileWriter file = new FileWriter("/home/bridgeit/Desktop/abc.json")) {
				file.write("\n");
				file.write(inventory.toJSONString());
				file.flush();
				// scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error");

			}
		}
		try (FileWriter file = new FileWriter("/home/bridgeit/Desktop/abc.json")) {
			file.write("\n");
			file.write(inventory.toJSONString());
			file.flush();
			// scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");

		}
		return inventory;

	}

	public static void displayJsonObject(JSONObject object) {
		Set keyList = object.keySet();
		String[] keys = (String[]) keyList.toArray(new String[keyList.size()]);
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] + object.get(keys[i]));
		}

	}

	/**
	 * @param inventory
	 *            <p>
	 *            reads json file and display contents in file
	 */
	public static void readJSON(JSONArray inventory) {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("/home/bridgeit/Desktop/abc.json");
			inventory = (JSONArray) jsonParser.parse(reader);
			// String items1[] = { "Rice", "Wheat", "Pulses" };
			System.out.println("***read json inverntory size" + inventory.size());
			for (int i = 0; i < inventory.size(); i++) {
				JSONObject item = (JSONObject) inventory.get(i);
				System.out.println("detail:\ntype: " + item.get("Name") + "\nweight: " + item.get("weight")
						+ "\nprice per KG: " + item.get("price") + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param inventory
	 *            <p>
	 *            calculates json total of weight price and total of values
	 */
	public static void calculateJSON(JSONArray inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			JSONObject item = (JSONObject) inventory.get(i);
			Double totalValue = (Double) item.get("weight") * (Double) item.get("price");
			System.out.println("Total value of type " + item.get("Name") + " is " + totalValue);
		}
		double sumWheat = 0, sumrice = 0, sumPulse = 0;
		for (int j = 0; j < inventory.size(); j++) {
			JSONObject item = (JSONObject) inventory.get(j);
			Double totalValue = (Double) item.get("weight") * (Double) item.get("price");
			// System.out.println("\n *Total value of type " + item.get("Name")
			// + " is " + totalValue);
			sumrice = sumrice + totalValue;
			// System.out.println("total of rice="+sum);
			j = j + 2;
		}
		System.out.println("\ntotal of rice=" + sumrice);
		for (int j = 1; j < inventory.size(); j++) {
			JSONObject item = (JSONObject) inventory.get(j);
			Double totalValue = (Double) item.get("weight") * (Double) item.get("price");
			// System.out.println("\n *Total value of type " + item.get("Name")
			// + " is " + totalValue);
			sumWheat = sumWheat + totalValue;
			// System.out.println("total of wheat="+sum);
			j = j + 2;
		}
		System.out.println("\ntotal of wheat=" + sumWheat);
		for (int j = 2; j < inventory.size(); j++) {
			JSONObject item = (JSONObject) inventory.get(j);
			Double totalValue = (Double) item.get("weight") * (Double) item.get("price");
			// System.out.println("\n *Total value of type " + item.get("Name")
			// + " is " + totalValue);
			sumPulse = sumPulse + totalValue;
			// System.out.println("total of pulse="+sum);
			j = j + 2;
		}
		System.out.println("\ntotal of pulse=" + sumPulse);
	}

	@SuppressWarnings("unchecked")
	public static JSONArray addNewItemJson() {
		Scanner scanner = new Scanner(System.in);
		// String itemarray[] = { "Rice", "Wheat", "pulse" };
		System.out.println("enter new element name:");
		String newname = scanner.next();
		String newArray[] = { newname };

		JSONArray inventory = new JSONArray();

		System.out.println("enter quantity of new product:");
		int quantity = scanner.nextInt();
		for (int j = 0; j < quantity; j++) {
			for (int i = 0; i < newArray.length; i++) {
				JSONObject newitem = new JSONObject();
				System.out.println("Enter data of " + newArray[j]);
				System.out.println("Name Of " + newArray[j]);
				String name = scanner.next();
				System.out.println("weight (in KG)");
				float weight = scanner.nextFloat();
				System.out.println("Price");
				float price = scanner.nextFloat();
				newitem.put("Name", name);
				newitem.put("weight", weight);
				newitem.put("price", price);
				inventory.add(newitem);
			}
			try (FileWriter file = new FileWriter("/home/bridgeit/Desktop/abc.json")) {
				file.write("\n");
				file.write(inventory.toJSONString());
				file.flush();
				// scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error");

			}

		}
		try (FileWriter file = new FileWriter("/home/bridgeit/Desktop/abc.json")) {
			file.write("\n");
			file.write(inventory.toJSONString());
			file.flush();
			// scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");

		}
		scanner.close();
		return inventory;
	}

	/**
	 * @return shuffeled String[]
	 *         <p>
	 *         to shuffel of cards
	 *         <p>
	 *         and return shuffeled deck
	 */
	public static String[] doShuffel() {
		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		// initialize deck i.e total number of cards 4*13=52
		int n = suit.length * ranks.length;

		// store shuffel cards
		String[] deck = new String[n];
		/*
		 * 2 of Clubs 2 of Diamonds 2 of Hearts 2 of Spades so on
		 */
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				deck[suit.length * i + j] = ranks[i] + " " + suit[j];

			}
		}
		/*
		 * // print deck print: for (int j = 0; j < deck.length; j++) {
		 * System.out.println(" " + deck[j]); }
		 */
		// shuffle cards n=52
		for (int i = 0; i < 52; i++) {
			int r = i + (int) (Math.random() * (52 - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		/* shuffeled cards: */

		/*
		 * System.out.println("shuffeld cards are:"); for (int i = 0; i < n;
		 * i++) { System.out.println(deck[i]); }
		 */
		return deck;
	}

	public static double valueOf(String[] name, String[] symbol, int[] share, double[] value, double[] total) {
		for (int i = 0; i < name.length; i++) {
			total[i] = share[i] * value[i];
			System.out.println("Total value for Stock " + (i + 1) + " is: " + total[i] + " Rs. symbol: " + symbol[i]);
		}
		// total of all accounts as allTotal
		double allTotal = 0;
		for (int i = 0; i < total.length; i++) {
			allTotal = allTotal + total[i];
		}
		System.out.println("\nTotal value of all  " + total.length + " stock is " + allTotal + " Rs");
		return allTotal;
	}

	/**
	 * @param shuffelDeck
	 *            String[]
	 * @return String [][]
	 *         <p>
	 *         take shuffeled cards and dristrubute 9 cards to 4 players
	 *         <p>
	 *         and returns 2D[4][9] matrix
	 * 
	 */
	public static String[][] getCardToPlayer(String[] shuffelDeck) {
		// divide 9 card to each 4 player
		String players[][] = new String[4][9];
		int a = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				players[i][j] = shuffelDeck[a];
				a++;
			}

		}
		return players;
	}

	/**
	 * @param player
	 *            String[][]
	 *            <p>
	 *            print cards of player
	 */
	public static void printCardOfPlayer(String[][] player) {
		// print 9 cards of 4 player

		for (int i = 0; i < 4; i++) {
			System.out.printf("player" + (i + 1) + " : ");
			for (int j = 0; j < 9; j++) {
				System.out.print("  " + player[i][j] + "  ");
			}
			System.out.println();

		}
	}

	public static ArrayList<String> sortCards(@SuppressWarnings("rawtypes") ArrayList list) {
		ArrayList<String> listsorted = new ArrayList<String>();
		char[] ranks = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K' };
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < 9; j++) {
				String match = (String) list.get(j);
				char first = match.charAt(0);
				char rank = ranks[i];
				// System.out.println("first "+first+" rank "+ranks[i]);
				if (first == rank) {
					listsorted.add((String) list.get(j));
					// array[i][j]=listsorted;
				}
			}
		}
		// System.out.println(listsorted + "" + listsorted.size());
		return listsorted;

	}

	public static ArrayList<String> getcards(String[] shuffelDeck, int a, int b) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = a; i < b; i++) {
			list.add(shuffelDeck[i]);
		}
		return list;
	}

	public static void printShuffelCardOfPlayer(String[] shuffelDeck) {
		ArrayList<String> listPlayer1 = new ArrayList<String>();
		ArrayList<String> listPlayer2 = new ArrayList<String>();
		ArrayList<String> listPlayer3 = new ArrayList<String>();
		ArrayList<String> listPlayer4 = new ArrayList<String>();

		int a = 0, b = 9;
		listPlayer1 = Utility.getcards(shuffelDeck, a, b);
		listPlayer1 = Utility.sortCards(listPlayer1);
		a = 9;
		b = 18;
		listPlayer2 = Utility.getcards(shuffelDeck, a, b);
		listPlayer2 = Utility.sortCards(listPlayer2);
		a = 18;
		b = 27;
		listPlayer3 = Utility.getcards(shuffelDeck, a, b);
		listPlayer3 = Utility.sortCards(listPlayer3);
		a = 27;
		b = 36;
		listPlayer4 = Utility.getcards(shuffelDeck, a, b);
		listPlayer4 = Utility.sortCards(listPlayer4);

		System.out.println("\nplayer1" + listPlayer1);
		System.out.println("player2" + listPlayer2);
		System.out.println("player3" + listPlayer3);
		System.out.println("player4" + listPlayer4);

	}

	/**
	 * @param file
	 * @param jsonObject
	 *            <p>
	 *            This method writes Json object in specified file
	 */
	public static void writeJSONFile(String file, JSONObject jsonObject) {
		FileWriter writer;
		try {
			writer = new FileWriter(file, false);
			PrintWriter out = new PrintWriter(writer);
			out.write(jsonObject.toJSONString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param file
	 *            -file to write json array
	 * @param jsonArray
	 *            -Json object to write in file
	 *            <p>
	 *            This method writes Json array in specified file
	 */
	public static void writeJSONFile(String file, JSONArray jsonArray) {
		FileWriter writer;
		try {
			writer = new FileWriter(file, false);
			PrintWriter out = new PrintWriter(writer);
			out.write(jsonArray.toJSONString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static JSONObject readJSONFile(JSONObject bookRecords) throws
	 * IOException, ParseException { JSONParser jsonParser=new JSONParser();
	 * FileReader reader; JSONObject jsonObject=new JSONObject(); try { reader =
	 * new FileReader(bookRecords);
	 * jsonObject=(JSONObject)jsonParser.parse(reader); reader.close(); } catch
	 * ( IOException | ParseException e) { e.printStackTrace(); } return
	 * jsonObject;
	 * 
	 * }
	 */

	public static JSONObject readJSONFile(String file) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader;
		JSONObject jsonObject = new JSONObject();
		try {
			reader = new FileReader(file);
			jsonObject = (JSONObject) jsonParser.parse(reader);
			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			// System.err.println("dfjh");
		}
		return jsonObject;

	}

	public static JSONArray readJSONArray(String file) {
		JSONParser jsonParser = new JSONParser();
		FileReader reader;
		JSONArray jsonObject = new JSONArray();
		try {
			reader = new FileReader(file);
			jsonObject = (JSONArray) jsonParser.parse(reader);
			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	@SuppressWarnings("unchecked")
	public static void addRecord(String file) throws IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		JSONObject record = new JSONObject();
		JSONArray bookRecords = Utility.readJSONArray(file);
		System.out.println("Enter First Name: ");
		String firstName = scanner.next();
		System.out.println("Enter Last Name :");
		String lastName = scanner.next();
		System.out.println("Enter Address :");
		String address = scanner.nextLine();
		System.out.println("Enter city:");
		String city = scanner.nextLine();
		System.out.println("Enter state :");
		String State = scanner.next();
		System.out.println("Enter zip:");
		String zip = scanner.next();
		System.out.println("Enter phone number");
		String phoneNo = scanner.next();
		record.put("firstname", firstName);
		record.put("laststname", lastName);
		record.put("address", address);
		record.put("city", city);
		record.put("state", State);
		record.put("zip", zip);
		record.put("phone", phoneNo);
		bookRecords.add(record);
		Utility.writeJSONFile(file, bookRecords);
		System.out.println("Record Added");
	}

	public static void deleteRecord(String file) throws IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		JSONArray bookRecords = Utility.readJSONArray("//home/bridgeit/Desktop/AddressBook.json");
		System.out.println("Enter First name to delete record");
		String name = scanner.next();
		for (int i = 0; i < bookRecords.size(); i++) {
			JSONObject record = (JSONObject) bookRecords.get(i);
			if (((String) record.get("firstname")).equalsIgnoreCase(name)) {
				bookRecords.remove(i);
				System.out.println("Record Deleted");
				Utility.writeJSONFile(file, bookRecords);
				return;
			}

		}
		System.out.println("Name not found!!!");
	}

	@SuppressWarnings("unchecked")
	public static void sortByName(String file) throws IOException, ParseException {
		JSONArray bookRecords = Utility.readJSONArray(file);
		JSONObject temporary;
		int size = bookRecords.size() - 1;
		for (int i = 0; i < size; i++) {
			JSONObject record = (JSONObject) bookRecords.get(i);
			JSONObject record2 = (JSONObject) bookRecords.get(i + 1);
			// compareto==0 same
			if (String.valueOf(record.get("firstname")).compareTo(String.valueOf(record2.get("firstname"))) > 0) {
				temporary = (JSONObject) bookRecords.get(i);
				bookRecords.remove(i);
				bookRecords.add(i, record2);
				bookRecords.remove(i + 1);
				bookRecords.add(i + 1, temporary);
			}
		}
		display(bookRecords);
	}

	public static void display(JSONArray bookRecords) {
		for (int i = 0; i < bookRecords.size(); i++) {
			JSONObject record = (JSONObject) bookRecords.get(i);
			System.out.println("First Name =" + record.get("firstname"));
			System.out.println("Last Name =" + record.get("laststname"));
			System.out.println("Address =" + record.get("address"));
			System.out.println("City =" + record.get("city"));
			System.out.println("City =" + record.get("state"));
			System.out.println("Zip =" + record.get("zip"));
			System.out.println("Phone =" + record.get("phone"));
			System.out.println("______________________________");

		}
	}

	@SuppressWarnings("unchecked")
	public static void enterDoctor(String doctorFile) {
		Scanner scanner = new Scanner(System.in);
		JSONObject doctor = new JSONObject();
		String keys[] = { "Name", "Id", "Specilization", "Availability" };
		for (int index = 0; index < keys.length; index++) {
			System.out.println("Enter " + keys[index]);
			String value = scanner.next();
			doctor.put(keys[index], value);
		}
		doctor.put("Appointments", 0);
		JSONArray patientList = new JSONArray();
		doctor.put("Patients", patientList);
		JSONArray doctorsList = readJSONArray(doctorFile);
		doctorsList.add(doctor);
		writeJSONFile(doctorFile, doctorsList);
	}

	/**
	 * @param doctorFile
	 *            <p>
	 *            search doctor by name id specializatrion availablity
	 */
	public static void searchDoctor(String doctorFile) {
		Scanner scanner = new Scanner(System.in);

		String searchBy[] = { "Name", "Id", "Specilization", "Availability" };

		System.out.println("Search doctor by(1/2/3/4):\n1.Name\n2.Id\n3.Specilization\n4.Availability");
		int choice = scanner.nextInt();
		System.out.println("Enter " + searchBy[choice - 1] + " you want");
		String valueToSearch = scanner.next();
		JSONArray doctorList = readJSONArray(doctorFile);
		int presentAtIndex = isPresent(doctorList, searchBy[choice - 1], valueToSearch);
		if ((presentAtIndex) >= 0) {
			JSONObject doctor = (JSONObject) doctorList.get(presentAtIndex);
			displayJsonObject(doctor);
		} else {
			System.out.println("Doctor with " + searchBy[choice - 1] + " " + valueToSearch + " is not present");
		}

	}

	public static void takeAppointment() {
		String doctorFile = "/home/bridgeit/raginiWorkspace/HospitalDetails/Doctor/Doctor.json";
		String patientFile = "/home/bridgeit/raginiWorkspace/HospitalDetails/Patient/Patient.json";
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter name of doctor  you want to take appointment");
		String name = scanner.next();
		JSONArray doctorList = readJSONArray(doctorFile);
		JSONObject doctor;

		int index = isPresent(doctorList, "Name", name);

		if (index >= 0) {
			doctor = (JSONObject) doctorList.get(index);
			if (doctor.get("Name").equals(name)) {
				if (Integer.parseInt(doctor.get("Appointments") + "") < 5) {
					JSONArray patientList = (JSONArray) doctor.get("Patients");
					System.out.println(doctor.toJSONString());
					doctor.remove("Patients");
					getPatientDetials(patientList);
					doctor.put("Patients", patientList);
					doctor.put("Appointments", Integer.parseInt((doctor.get("Appointments")) + "") + 1);
					writeJSONFile(doctorFile, doctorList);
					writeJSONFile(patientFile, patientList);
				} else {
					System.out.println(" Dr." + name + " is not available");
				}
			}
		} else {
			System.out.println("You might have enter wrong name try again ");
		}

	}

	private static JSONArray getPatientDetials(JSONArray patientList) {
		Scanner scanner = new Scanner(System.in);
		JSONObject patient = new JSONObject();
		String keys[] = { "Name", "Id", "Mobile_No", "Age" };
		System.out.println("\nEnroll new patient details!!!");
		;
		for (int index = 0; index < keys.length; index++) {
			System.out.println("Enter " + keys[index] + " of patient");
			String value = scanner.next();
			patient.put(keys[index], value);
		}
		patientList.add(patient);
		System.out.println("done enroll!!!");
		return patientList;
	}

	public static void searchPatient() {
		try {
			String patientFile = "/home/bridgeit/raginiWorkspace/HospitalDetails/Patient/Patient.json";
			Scanner scanner = new Scanner(System.in);
			String searchBy[] = { "Name", "Id", "Specilization", "Availability" };
			System.out.println("Search doctor by(1/2/3/4):\n1.Name\n2.Id\n3.Specilization\n4.Availability");
			int choice = scanner.nextInt();
			System.out.println("Enter " + searchBy[choice - 1] + " you want");
			String valueToSearch = scanner.next();
			JSONArray patientList = readJSONArray(patientFile);
			int presentAtIndex = isPresent(patientList, searchBy[choice - 1], valueToSearch);
			if ((presentAtIndex) >= 0) {
				JSONObject doctor = (JSONObject) patientList.get(presentAtIndex);
				displayJsonObject(doctor);
			} else {
				System.out.println("Patient not found!!!");
			}
		} catch (Exception e) {
			System.out.println("not found!!!");
		}

	}

	public static int isPresent(JSONArray doctorList, String key, String valueToSearch) {
		int presentAt = -1;
		for (int index = 0; index < doctorList.size(); index++) {
			JSONObject doctor = (JSONObject) doctorList.get(index);
			//compare
			if (((String) doctor.get(key)).equalsIgnoreCase(valueToSearch)) {
				presentAt = index;
				break;
			}
		}
		return presentAt;
	}

}
