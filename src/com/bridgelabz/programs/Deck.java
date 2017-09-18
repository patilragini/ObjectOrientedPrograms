package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class Deck {
	public static void main(String[] args) {

		String shuffelDeck[] = Utility.initShuffel();
		//for (int i = 0; i < 52; i++)
		//	System.out.println(shuffelDeck[i]);

		String players[][] = new String[4][9];

		int a=0;
		for (int i = 0; i < 4; i++) {			
			for (int j = 0; j < 9; j++) {
				players[i][j] = shuffelDeck[a];	
				a++;
			}
						
		}

		for (int i = 0; i < 4; i++) {
			System.out.printf("player"+(i+1)+" : ");
			for (int j = 0; j < 9; j++) {
				System.out.print("  "+ players[i][j]+"  ");
			}
			System.out.println();

		}

	}
}
