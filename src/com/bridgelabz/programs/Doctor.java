package com.bridgelabz.programs;
public class Doctor {
	private String doctorId;
	private String name;
	private String specialization ;
	private String availableTime;

	
	public Doctor(String doctorId,String name, String specialization,String availableTime){
		this.doctorId=doctorId;
		this.name=name;
		this.specialization=specialization;
		this.availableTime=availableTime;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailablity() {
		return availableTime;
	}

	public void setAvailablity(String availableTime) {
		this.availableTime = availableTime;
	}
	
}
