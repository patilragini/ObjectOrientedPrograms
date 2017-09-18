/******************************************************************************
 *  @author  ragini patil
 *  @version 1.0
 *  @since   17-09-2017
 * Purpose:  read  write json file and calculate total values in inventory
 ******************************************************************************/
package com.bridgelabz.programs;

import org.json.simple.parser.JSONParser;

import com.bridgelabz.utility.Utility;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;

public class inventoryManagementProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char choice;
		do {
			System.out.println(
					"Enter: \n1. to enter details of rice wheat pulse\n2. read details in inventory \n3. to get total of inventory");
			int type = scanner.nextInt();
			switch (type) {
			case 1:

					JSONArray inventory = Utility.writeJSON();
					System.out.println("read json inverntory factory size"+inventory.size());
	
				break;
			case 2:
				try {
					JSONParser jsonParser = new JSONParser();
					FileReader reader = new FileReader("/home/bridgeit/Desktop/abc.json");
					inventory = (JSONArray) jsonParser.parse(reader);
					System.out.println("read json inverntory size***"+inventory.size());
					Utility.readJSON(inventory);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("");
				try {
					JSONParser jsonParser1 = new JSONParser();
					FileReader reader1 = new FileReader("/home/bridgeit/Desktop/abc.json");
					inventory = (JSONArray) jsonParser1.parse(reader1);
					Utility.calculateJSON(inventory);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
		/*	case 4:			
				JSONArray newinventory = Utility.addNewItemJson();
				System.out.println("read json inverntory factory size"+newinventory.size());
				default :
					System.out.println("invalid option:");*/
				default:
					System.out.println("invalid option");
			}
			System.out.println("do you want to continue y/n ?");
			// System.out.println("scan char at 0");
			choice = scanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y' || scanner.hasNext());

		System.out.println("exit");
		scanner.close();
	}
}