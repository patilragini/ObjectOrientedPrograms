
package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StockAccount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			char again;
			do {
				System.out.println("Enter the number of of stocks");
				int size = scanner.nextInt();
				String name[] = new String[size];
				String symbol[] = new String[size];
				int share[] = new int[size];
				double value[] = new double[size];
				double total[] = new double[size];

				for (int i = 0; i < size; i++) {
					System.out.println(" please enter name of stock:" + (i + 1));
					name[i] = scanner.next();
					System.out.println(" please enter unique symbol: \n");
					symbol[i] = scanner.next();
					System.out.println(symbol[i]);
					System.out.println("enter no of share\n");
					share[i] = scanner.nextInt();
					System.out.println("value of each share\n");
					value[i] = scanner.nextInt();
				}
				Utility.valueOf(name, symbol, share, value, total);

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
