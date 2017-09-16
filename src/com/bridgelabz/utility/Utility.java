package com.bridgelabz.utility;

public class Utility {
	public static void regularExpresion(String string,String firstName,String fullName,String phno,String date) {
		String replacefname=string.replace("<<name>>", firstName);
		String replacefullname=replacefname.replace("<<full name>>", fullName);
		String replacephno=replacefullname.replace("xxxxxxxxxx", phno);
		String replacedate=replacephno.replace("01/01/2016", date);
		System.out.println(replacedate);
	}
	

}
