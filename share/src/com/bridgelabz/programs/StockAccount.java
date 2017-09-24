package com.bridgelabz.programs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StockAccount {
	Scanner scanner = new Scanner(System.in);

	MyLinkedList<CompanyShares> companylist = new MyLinkedList<>();
	MyStack<String> transactionStack = new MyStack<>();
	MyQueue<String> dateTimeQueue = new MyQueue<>();

	public StockAccount(String file) {
		String data[] = Utility.readFile(file);
		for (int i = 0; i < data.length; i++) {
			// System.out.println("data length**"+data.length);
			String name = data[i++];
			String symbol = data[i++];
			int noOfShares = Integer.parseInt(data[i++]);
			double sharePrice = Double.parseDouble(data[i++]);
			String dateTime = data[i];
			CompanyShares shares = new CompanyShares(name, symbol, noOfShares, sharePrice, dateTime);
			companylist.add(shares);
			// System.out.println("stock details added!!!*");
		}
	}

	public void buy(String name, int amount, String symbol) {
		System.out.println("Enter price per share for " + symbol);
		double price = scanner.nextDouble();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
		String dateTime = format.format(date);
		CompanyShares share = new CompanyShares(name, symbol, amount, price, dateTime);
		transactionStack.push("purchased");
		dateTimeQueue.enqueue(dateTime);
		companylist.add(share);
	}

	/**
	 * @param file
	 *            String
	 *            <p>
	 * 			adds data to file
	 */
	public void save(String file) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < companylist.size(); i++) {
			list.add((companylist.get(i).getname()));
			list.add(companylist.get(i).getSymbol());
			list.add(String.valueOf(companylist.get(i).getNumberOfShares()));
			list.add(String.valueOf(companylist.get(i).getPrice()));
			list.add(companylist.get(i).getDateTime());
		}
		String data[] = list.toArray(new String[list.size()]);
		Utility.writeFile(data, file);
	}

	private int index = 0;

	public void sell(int amount, String symbol) {
		// index to get position of stock
		for (index = 0; index < companylist.size(); index++) {
			if (companylist.get(index).getSymbol().equals(symbol)) {
				System.out.println("found>>>>>>>>>>>");
				break;
			}
		}
		// deduct amount
		int deductShare = companylist.get(index).getNumberOfShares() - amount;
		if (deductShare >= 0) {

			companylist.get(index).setNumberOfShares(deductShare);
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
			String dateTime = format.format(date);
			companylist.get(index).setDateTime(dateTime);
			dateTimeQueue.enqueue(dateTime);
			System.out.println("sold!!!");
			transactionStack.push("Sold");
			return;
		}
		System.out.println("error in transaction \nnumber of sell share is more than in account");
	}

	/**
	 * <p>
	 * print data
	 */
	public void printReport() {
		for (int index = 0; index < companylist.size(); index++) {
			System.out.println("Stock number :" + (index + 1));
			System.out.println("Name: " + companylist.get(index).getSymbol());
			System.out.println("Stock symbol:" + companylist.get(index).getSymbol());
			System.out.println("Number of shares: " + companylist.get(index).getNumberOfShares());
			System.out.println("Share price: " + companylist.get(index).getPrice());
			System.out.println("Total value: " + companylist.get(index).getValue());
			System.out.println("Last transaction date and time: " + companylist.get(index).getDateTime());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");

		}
	}

	public static void main(String args[]) {
		String file = "/home/bridgeit/raginiWorkspace/StockDetails/Accounts";
		String name, symbol;
		int numberOfStock, amount;
		char again = 'y';
		do {
			StockAccount account = new StockAccount(file);
			System.out.println("Enter your operatons \n1.Buy \n2.Sell \n3.Print report ");
			int choice = account.scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name:");
				name = account.scanner.next();
				System.out.println("Enter stock symbol: ");
				symbol = account.scanner.next();
				System.out.println("Enter stock number of stock: ");
				numberOfStock = account.scanner.nextInt();
				account.buy(name, numberOfStock, symbol);
				account.save(file);
				System.out.println("file saved!!!");
				// System.out.println("report after edit");
				// account.printReport();
				break;
			case 2:
				System.out.println("Enter stock symbol to sell stock: ");
				symbol = account.scanner.next();
				System.out.println("Enter stock number of shares to sell:");
				amount = account.scanner.nextInt();
				account.sell(amount, symbol);
				account.save(file);
				System.out.println("file saved!!!\n");
				// account.printReport();
				break;
			case 3:
				System.out.println("~~~~~~~~~~Details of stock and values are ~~~~~~~~  ");
				account.printReport();
				break;
			default:
				System.out.println("Invalid choice!!!");
			}
			System.out.println("Do you want to continue y/n");
			again = account.scanner.next().charAt(0);
		} while (again == 'y' || again == 'Y');
		System.out.println("end!!!");

	}
}
