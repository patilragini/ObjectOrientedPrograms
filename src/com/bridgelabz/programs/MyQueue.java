package com.bridgelabz.programs;

public class MyQueue<T> {
	MyLinkedList<T> list=new MyLinkedList<T>();
	public void enqueue(T data){
		list.add(data);
	}
	public T dequeue(){
		return list.pop(0);
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public int size(){
		return list.size();
	}
	
}
