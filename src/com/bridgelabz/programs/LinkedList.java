/******************************************************************************

 *
 *  @author  ragini patil
 *  @version 1.0
 *  @since   15-09-2017
 *   
 *  Purpose: linked list 
 ******************************************************************************/
package com.bridgelabz.programs;

import java.util.Scanner;
class Node{
	protected String data;

    protected Node link;
    public Node()
    {
        link = null;
        data = null;
    }    
    public Node(String d,Node n)
    {
        data = d;
        link = n;
    }    
     public void setLink(Node n)
    {
        link = n;
    }    
     public void setData(String d)
    {
        data = d;
    }    
       public Node getLink()
    {
        return link;
    }    
     public String getData()
    {
        return data;
    }
}
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
  
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return start == null;
    }
    public int getSize()
    {
        return size;
    }    
    
    public void insertAtEnd(String val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
   
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
public class  LinkedList{    
    public static void main(String[] args)
    {             
        Scanner scanner = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        do
        {
            System.out.println("1. get size\n 2 insert at end\n 3display");            
            int choice = scanner.nextInt();            
            switch (choice)
            {      
            case 1 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break; 
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scanner.next() );                     
                break;  
            case 3:
            	list.display();
                break;
                                    
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            list.display();
            System.out.println("\nDo you want to continue y/n) \n");
            ch = scanner.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');             
        scanner.close();
    }
}