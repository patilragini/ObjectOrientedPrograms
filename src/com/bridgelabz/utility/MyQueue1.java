package com.bridgelabz.utility;


	public class MyQueue1<T> {
		MyLinkedList1<T> list=new MyLinkedList1<T>();
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