package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class Deck {
	public static void main(String[] args) {

		// get shuffeled deck as array
		String shuffelDeck[] = Utility.doShuffel();

		// print shuffeled deck
		// for (int i = 0; i < 52; i++){
		// System.out.println(shuffelDeck[i]);
		// }
		String[][] player = Utility.getCardToPlayer(shuffelDeck);

		System.out.println("Cards before sort");
		// print 9 cards of 4 player
		Utility.printCardOfPlayer(player);
	}
}
