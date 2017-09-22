package com.bridgelabz.utility;

public class MyStack<T> {
	MyLinkedList<T> linkedList;

	public MyStack() {
		linkedList = new MyLinkedList<T>();
	}

	public void push(T data) {
		linkedList.add(data);
	}

	public T pop() {
		return linkedList.pop();
	}

	public T peek() {
		T temp = linkedList.pop();
		linkedList.add(temp);
		return temp;
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	public int size() {
		return linkedList.size();
	}

}
