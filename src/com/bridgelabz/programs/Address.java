package com.bridgelabz.programs;

import java.util.Arrays;
import java.util.Comparator;

public class Address implements Comparable<Address> {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phnumber;

	public Address(String firstName, String lastName, String address, String city, String state, int zip,
			int phnumber) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phnumber = phnumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(int phnumber) {
		this.phnumber = phnumber;
	}



		public int compare(Address fname1, Address fname2) {

			String firstName1 = fname1.getFirstName().toUpperCase();
			String firstName2 = fname2.getFirstName().toUpperCase();
			
	//		Arrays.sort(address, firstName, Arrays.ASCENDING);
			
			return firstName1.compareTo(firstName2);
			
			// return fruitName2.compareTo(fruitName1);
		};

		@Override
		public int compareTo(Address o) {
			int firstCmp = this.getFirstName().compareTo(o.getFirstName());
	        return firstCmp != 0 ? firstCmp :  this.getLastName().compareTo(o.getLastName());
		
		}
		
	
}