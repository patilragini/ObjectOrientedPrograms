package com.bridgelabz.programs;

import java.util.Scanner;

public class twmp
{  
    public static void main(String args[])
    {
        System.out.println("Hello, World!");
        Emp[] employees = new Emp[10];
       
        System.out.println("get doc detials: ");
        if(employees.length<5){
        	System.out.println("enter details");
        employees[employees.length] = new Emp(employees.length+1);
        }
    }
}

class Emp{
    int eno;
    public Emp(int no){
    	System.out.println("enter num");
    	Scanner scanner=new Scanner(System.in);
        eno =scanner.nextInt();
        System.out.println("Enter doctor_id");
		int doctorId = scanner.nextInt();
		System.out.println("Enter doctor name");
		String name = scanner.next();
        System.out.println("emp constructor called..eno is.."+eno);
    }
}