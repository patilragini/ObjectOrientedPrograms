package com.bridgelabz.programs;

class Node<T> {
	T data;
	@SuppressWarnings("rawtypes")
	Node next;

	public Node(T data) {
		this.data = data;
		next = null;
	}

}

public class MyLinkedList<T> {
	Node<T> root;
	Node<T> end;
	int size;

	public MyLinkedList() {
		root = null;
		end = null;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		if (this.isEmpty()) {
			root = node;
			end = node;
			
		} else {
			end.next = node;
			end = end.next;
		}
		size++;
	}
	@SuppressWarnings("unchecked")
	public void removeAt(int pos){
		int tempPos=0;
		Node<T> tempPrev=root; 
		Node<T> tempCurrent=root;
		if(pos==0){
			root=root.next;
			
		}else if(pos==(this.size()-1)){
			while(tempCurrent.next!=null){
				tempPrev=tempCurrent;
				tempCurrent=tempCurrent.next;
			}
			tempPrev.next = tempPrev.next.next;
			end=tempPrev;
		}else if(pos<this.size()){
			while(tempCurrent.next!=null){
				if(pos==tempPos){	
					tempPrev.next=tempPrev.next.next;
					break;
				}
				tempPrev=tempCurrent;
				tempCurrent=tempCurrent.next;
				tempPos++;
			}
		}else{
			System.out.println("Given index does not exist");
		}
		
	}
	@SuppressWarnings("unchecked")
	public void remove(T data) {
		Node<T> tempCurrent = root;
		Node<T> tempPrev = root;
		if(root.data.equals(data)){
			root=root.next;
		}else if(end.data.equals(data)){
			while(tempCurrent.next!=null){
				tempPrev=tempCurrent;
				tempCurrent=tempCurrent.next;
			}
			tempPrev.next = tempPrev.next.next;
			end=tempPrev;
		}else{
			while (tempCurrent != null) {
				if (tempCurrent.data.equals(data)) {
					tempPrev.next = tempCurrent.next;
					break;
				}
				tempPrev = tempCurrent;
				tempCurrent = tempCurrent.next;
			}
		}
		if (size != 0) {
			size--;
		}
	}


	@SuppressWarnings("rawtypes")
	public int size() {
		Node temp = root;
		int size = 0;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}
	
	public boolean isEmpty(){
		if(root==null){
			return true;
		}
		return false;
	}
	
	public boolean search(T item){
		Node temp=root;
		boolean isPresent=false;
		while(temp!=null){
			if(temp.data.equals(item)){
				isPresent=true;
			}
			temp=temp.next;
		}
		return isPresent;	
	}
	
	public int index(T item){
		Node temp=root;
		int index=-1;
		if(this.search(item)){
			while(temp!=null){
				index++;
				if(temp.data.equals(item)){
					return index;
				}
				temp=temp.next;
				
			}
		}
		return index;
	}
	@SuppressWarnings("unchecked")
	public T get(int index){
		Node<T> tempCurrent=new Node(null);
		if(index>=0 && index<this.size()){
			tempCurrent=root;
			for(int i=0;i<index;i++){
				tempCurrent=tempCurrent.next;
			}
		}else{
			System.out.println("Invalid index");
		}
		
		return tempCurrent.data;
	}
	
	public T pop(){
		T data=end.data;
		removeAt(this.size()-1);
		return data;
	}
	public T pop(int pos){
		T tempData=get(pos);
		removeAt(pos);
		return tempData;
		
	}
	@SuppressWarnings("unchecked")
	public void printList(){
		Node<T> temp=root;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
}