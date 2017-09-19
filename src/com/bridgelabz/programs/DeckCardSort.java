package com.bridgelabz.programs;

import java.awt.List;
import java.util.ArrayList;
import java.util.Queue;

import com.bridgelabz.utility.MyQueue;
import com.bridgelabz.utility.QueueArray;
import com.bridgelabz.utility.Utility;

public class DeckCardSort {

	public static void main(String[] args) {
		char[] ranks = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K' };

		QueueArray sortedQueue = new QueueArray(35);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listsorted = new ArrayList<String>();
		String[] temp = new String[9];

		System.out.println("cards before sort: ");

		String shuffelDeck[] = Utility.doShuffel();
		for (int i = 0; i < 9; i++) {
			list.add(shuffelDeck[i]);
		}
		System.out.println(list);
		String[][] array=new String[4][9];
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < 9; j++) {
				String match = list.get(j);
				char first = match.charAt(0);
				char rank=ranks[i];
				// System.out.println("first  "+first+"  rank  "+ranks[i]);
				if (first==rank) {
				listsorted.add(list.get(j));
				//array[i][j]=listsorted;
				}
			}
		}
		System.out.println(listsorted+""+listsorted.size());		
	}
}
