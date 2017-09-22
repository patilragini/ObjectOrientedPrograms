package com.bridgelabz.programs;

public class Patient {
	private int patientId;
	private String name;
	private int phoneNumber ;
	private int age;
	
	public Patient(int patientId,String name,int poneNumber,int age){
		this.patientId=patientId;
		this.name=name;
		this.phoneNumber=poneNumber;
		this.age=age;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
