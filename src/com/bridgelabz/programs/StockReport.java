package com.bridgelabz.programs;

import java.util.Scanner;

public class StockReport {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try {
			char again;
			do {
		System.out.println("Enter the size of stock");
		int size = scanner.nextInt();
		String name[] = new String[size];
		int share[] = new int[size];
		int value[] = new int[size];
		int total[] = new int[size];
		int allTotal = 0;
		for (int i = 0; i < size; i++) {
			System.out.println(" please enter name of stock:" + (i + 1));
			name[i] = scanner.next();
			System.out.println("enter no of share");
			share[i] = scanner.nextInt();
			System.out.println("value of each share");
			value[i] =scanner.nextInt();
		}

		for (int i = 0; i < size; i++) {
			total[i] = share[i] * value[i];
			System.out.println("Total value for Stock " + (i + 1) + " is: " + total[i] + " Rs.");
		}

		for (int i = 0; i < size; i++) {
			allTotal = allTotal + total[i];
		}

		System.out.println("\nTotal value of all  " + size + " stock is " + allTotal+" Rs");
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