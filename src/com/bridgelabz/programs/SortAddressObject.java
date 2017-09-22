package com.bridgelabz.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAddressObject{

	public static void main(String args[]){

	String a="slkc sldfkj kjdfc ij,ljb,nmncdcdf dc";
			List<Address> arr=new ArrayList<Address>();
				
		Address add1 = new Address("zagini",a,"B303 sagar vihar","airoli","maharashttra",407708,12331214);
		Address add2 = new Address("agini","patel","5252 ihar","roli","marashttra",4080708,845425451);
		Address add3 = new Address("cagini","til","B vihar","airoi","maharra",4007088,84540611);
		Address add4 = new Address("ragIni","panchal"," sagar har","roli","maharasttra",4002708,840626041);

			arr.add(add1);
			arr.add(add2);
			arr.add(add3);
			arr.add(add4);
			
			Collections.sort(arr);
	
		int i=0;
		for(Address temp: arr){
		   System.out.println("First name : "  +i+++"  "+ temp.getFirstName() +" Last name : "+temp.getLastName()+" address: "+temp.getAddress()+" "+temp.getCity()+" "+temp.getState()+" "+temp.getZip()+" "+temp.getPhnumber());
		}

	}
}