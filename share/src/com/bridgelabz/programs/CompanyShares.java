package com.bridgelabz.programs;


	public class CompanyShares {
		private String name;
		private String symbol;	
		private int numberOfShares;	
		private String dateTime;	
		private double price;	
		
		public CompanyShares(String name,String symbol , int numberOfShares, double price, String dateTime) {
			this.name=name;
			this.symbol = symbol;
			this.numberOfShares = numberOfShares;
			this.dateTime = dateTime;
			this.price = price;
		}
		public String getname() {
			return name;
		}
		public String getSymbol() {
			return symbol;
		}
		
		public int getNumberOfShares() {
			return numberOfShares;
		}
		
		public double getPrice() {
			return price;
		}
		
		public String getDateTime() {
			return dateTime;
		}
		
		public double getValue() {
			return numberOfShares * price;
		}

		public void setNumberOfShares(int numberOfShares) {
			this.numberOfShares = numberOfShares;
		}
		
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
	}


