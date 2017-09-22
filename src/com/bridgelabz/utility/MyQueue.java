package com.bridgelabz.utility;

import java.util.Vector;
public class MyQueue<E> {

	private Vector<E> queue=new Vector<E>();
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public MyQueue()
	{
		this.queue=(Vector<E>) new Vector<Integer>();
		this.front=0;
		this.rear=-1;
	}
	
	public void insert(E obj)
	{
		queue.add(obj);
		rear++;
	}
	
	
	public boolean isEmpty()
	{
		if(front>rear)
		{
			return true;
		}
		else{
			return false;
		}
	}
	public E remove()
	{
		if(isEmpty())
		{
			return null;
		}
		return queue.get(front++);				
	}		
	/* public E peek() {
	        return ((Object) queue).getFirst();
	    }*/

}