package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class DeckCardSort {

	public static void main(String[] args) {
				
		// get shuffeled deck as array
		String shuffelDeck[] = Utility.doShuffel();

		
		String[][] player = Utility.getCardToPlayer(shuffelDeck);

		System.out.println("Cards before sort");
		
		Utility.printCardOfPlayer(player);
	
		System.out.println("cards after sort:");
		
		Utility.printShuffelCardOfPlayer(shuffelDeck);		
	}
}
