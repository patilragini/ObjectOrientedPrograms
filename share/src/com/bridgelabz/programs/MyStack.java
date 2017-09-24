package com.bridgelabz.programs;

public class MyStack<T> {
	MyLinkedList<T> list=new MyLinkedList<T>();
	Node<T> top;
	public void push(T item){
		list.add(item);
		top=list.end;
	}
	public T pop(){
		if(!list.isEmpty())
		return list.pop();
		return null;
	}
	public T peek(){
		if(!list.isEmpty())
		return list.get(list.size()-1);
		return null;
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public int size(){
		return list.size();
	}
	
}
