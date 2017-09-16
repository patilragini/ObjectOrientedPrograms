package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			char again;
			do {
				String string = " Hello <<name>>, We have your full name as <<full name>> in our system. \n your contact number is 91-xxxxxxxxxx.\n Please,let us know in case of any clarification \n Thank you BridgeLabz 01/01/2016.";
				System.out.println("Enter your name");
				String firstName = scanner.nextLine();
				System.out.println("Enter full name");
				String fullName = scanner.nextLine();
				System.out.println("Enter 10 digit phno:");
				String phno = scanner.nextLine();
				System.out.print("Enter date in dd/mm/yyyy format: ");
				String date = scanner.nextLine();

				Utility.regularExpresion(string, firstName, fullName, phno, date);
				System.out.println("do you want to continue?");
				again = scanner.next().charAt(0);
			} while (again == 'y' || again == 'Y');
			System.out.println("end");
		} catch (Exception e) {
			System.out.println("Type Error!!!");
		}
		scanner.close();

	}

}
