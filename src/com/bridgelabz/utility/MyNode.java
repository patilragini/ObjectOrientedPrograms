package com.bridgelabz.utility;

public class MyNode<E> {

	public int data;
	public String data1;
	@SuppressWarnings("rawtypes")
	public MyNode nextNode;

	// constructor
	public MyNode() {
		this.nextNode = null;
	}

	public void setData(int data) {
		this.data = data;
		nextNode = null;
	}

	public void setData(String data1) {
		this.data1 = data1;
		nextNode = null;
	}
}