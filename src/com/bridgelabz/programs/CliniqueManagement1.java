package com.bridgelabz.programs;

import java.util.Scanner;



import com.bridgelabz.utility.Utility;

public class CliniqueManagement1 {

	private static String doctorReg = "/home/bridgeit/raginiWorkspace/HospitalDetails/Doctor/Doctor.json";
	
	public static void main(String[] args) {
		// CliniqueManagement1 cm=new CliniqueManagement1();
		char again;
		Scanner scanner = new Scanner(System.in);

		try {
			do {

				System.out.println("Main menu !!!\nEnter you choice");
				System.out.println(
						"\n1. Enroll new Doctor\n2. Check  Appointments of doctor and doctors patients details\n3. Take Appointment\n 4. search patient details if apointment is booked or not");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("enter verification password to enter new doctor in file:(docapp123)");
					String pswd = scanner.next();

					if (pswd.equals("docapp123")) {
						System.out.println("welcome!!!\n Enter new doctor detials:");

						Utility.enterDoctor(doctorReg);
						// System.out.println("Enter doctor_id");
						// String doctorId = scanner.next();
						// System.out.println("Enter doctor name");
						// String name = scanner.next();
						// System.out.println("Enter doctor specialization:");
						// String specialization = scanner.next();
						// System.out.println("Enter doctor availableTime in
						// clinique");
						// String availableTime = scanner.next();
						// Doctor doctor = new Doctor(doctorId, name,
						// specialization,
						// availableTime);
						System.out.println("Details of doctor entered successfully!!!");
						// cm.display(doctor);

					} else
						System.out.println("verification failed!!!");
					break;

				case 2:
					// search doc and his patients
					Utility.searchDoctor(doctorReg);
					System.out.println("sucessfull search doctor!!!");
					break;
				case 3:
					Utility.takeAppointment();
					//System.out.println("appointment booked!!!");
					break;

				case 4:
					Utility.searchPatient();
				default:
					System.out.println("invalid choice!!!");
				}
				System.out.println("do you want to go main menu y/n :");
				again = scanner.next().charAt(0);
			} while (again == 'y' || again == 'Y');

		} catch (Exception e) {
			System.out.println("invalid !!!");
		}
		scanner.close();
	}
}
