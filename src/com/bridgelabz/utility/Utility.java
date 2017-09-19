package com.bridgelabz.utility;

import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

		System.out.println("enter quantity of product(rice,wheat,pulses):");
		int quantity = scanner.nextInt();
		for (int j = 0; j < quantity; j++) {
			System.out.println(j);
			// after 3rd element rice will repeat
			for (int i = 0; i < itemarray.length; i++) {
				System.out.println(j);

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
 * <p>to shuffel of cards 
 * <p>and return shuffeled deck
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
		/*// print deck print:
		for (int j = 0; j < deck.length; j++) {
			System.out.println(" " + deck[j]);
		}*/
		// shuffle cards n=52
		for (int i = 0; i < 52; i++) {
			int r = i + (int) (Math.random() * (52 - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		/* shuffeled cards: */
		/*System.out.println("shuffeld cards are:");
		for (int i = 0; i < n; i++) {
			System.out.println(deck[i]);
		}
*/
		return deck;
	}

	public static double valueOf(String[] name, String[] symbol, int[] share, double[] value, double[] total) {
		for (int i = 0; i < name.length; i++) {
			total[i] = share[i] * value[i];
			System.out.println("Total value for Stock " + (i + 1) + " is: " + total[i] + " Rs. symbol: " + symbol[i]);
		}
		double allTotal = 0;
		for (int i = 0; i < total.length; i++) {
			allTotal = allTotal + total[i];
		}
		System.out.println("\nTotal value of all  " + total.length + " stock is " + allTotal + " Rs");
		return allTotal;
	}

	public static List sort(String string) {

		return null;
	}
/**
 * @param shuffelDeck String[]
 * @return String [][]
 * <p>take shuffeled cards and dristrubute 9 cards to 4 players
 * <p>and returns 2D[4][9] matrix
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
 * @param player String[][]
 * <p>print cards of player
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


}
