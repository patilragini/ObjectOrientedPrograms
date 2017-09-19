/* ***********************************************************************************************
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   12-9-2017
 *  @description all function of Queue as Array of n size in util class
 *
 *************************************************************************************************/
package com.bridgelabz.utility;
	/**
	 *  @author ragini patil
	 *  <p> a Queue implemented as array by object size n
	 *      
	 */
	public class QueueArray{
	//Queue for array	
	private int Queue[];
	
	protected int front, rear, size, len;
	
	//Constructoof size n n-> given from main 
	public QueueArray(int n) {
	size = n;
	len = 0;
	Queue = new int[size];
	front = -1;
	rear = -1;
	}    

	public boolean isEmpty() 
	{
	return front == -1;
	}    

	public boolean isFull() 
	{
	return rear == size -1 ;
	}    
	
	public int getSize()
	{
	return Queue.length ;
	}    
//print 1st element in array /queue
	public int peek()	{
	if (isEmpty())
		 System.out.println("Underflow Exception");
	return Queue[front];
	}    
	//
	public void insert(int i) 	{
	if (rear == -1) 
	{
	    front = 0;
	    rear = 0;
	    Queue[rear] = i;
	}
	else if (rear + 1 >= size)
	    System.out.println("Overflow Exception");
	else if ( rear + 1 < size)
	    Queue[++rear] = i;    
	len++ ;    
	}  
	//
	public void insert(char i) 	{
	if (rear == -1) 
	{
	    front = 0;
	    rear = 0;
	    Queue[rear] = i;
	}
	else if (rear + 1 >= size)
		 System.out.println("Overflow Exception");
	else if ( rear + 1 < size)
	    Queue[++rear] = i;    
	len++ ;    
	}    
//
	public int remove() {
	if (isEmpty())
		 System.out.println("Underflow Exception");
	else 
	{
	    len-- ;
	    //int element = Queue[front];
	    if ( front == rear) 
	    {
	        front = -1;
	        rear = -1;
	    }
	    else
	        front++;                
	    }  
	return front;
	}

	public void display()	{
	System.out.print("\nQueue => ");
	if (len == 0)
	{
	    System.out.print("Empty Queue\n");
	    return ;
	}
	for (int i = front; i <= rear; i++)
	    System.out.print(Queue[i]+" ");
	System.out.println();        
	}
}   
 