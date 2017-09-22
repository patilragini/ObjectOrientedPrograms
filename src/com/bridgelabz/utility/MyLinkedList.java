package com.bridgelabz.utility;

public class MyLinkedList<T> {
	Node<T> head;
	Node<T> current;
	int position;

	public MyLinkedList() {
		head = null;
		current = null;
		position = -1;
	}

	public void list() {
		Node<T> tempCurrent = head;
		while (tempCurrent != null) {
			System.out.println(tempCurrent.data);
			tempCurrent = tempCurrent.next;
		}
	}

	/**
	 * adds element to the list at end of the list
	 */
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			current = head;
		} else {
			current.next = node;
			current = current.next;
		}
		position++;
	}

	/**
	 * removes given element from the list
	 */
	public void remove(T data) {
		Node<T> tempCurrent = head;
		Node<T> tempPrev = null;
		while (!tempCurrent.data.equals(data)) {
			tempPrev = tempCurrent;
			tempCurrent = tempCurrent.next;
		}
		if (tempCurrent == head) {
			head = head.next;
		} else {
			tempPrev.next = tempCurrent.next;
		}
		if (tempCurrent == current) {
			current = tempPrev;
		}
		position--;
	}

	/**
	 * @returns true if the element is in the list else returns false
	 */
	public boolean search(T data) {
		return index(data) == -1 ? false : true;
	}

	/**
	 * @returns true if the list is empty else returns false
	 */
	public boolean isEmpty() {
		return position == -1 ? true : false;
	}

	/**
	 * @returns size(number of elements) of the list
	 */
	public int size() {
		return position + 1;
	}

	/**
	 * adds data to the end of the list
	 */
	public void append(T data) {
		add(data);
	}

	/**
	 * position of the element in the list if it is in the list else returns -1
	 */
	public int index(T data) {
		if (position == -1) {
			return -1;
		}
		Node<T> tempCurrent = head;
		int tempPosition = 0;

		while (!tempCurrent.data.equals(data)) {
			if (tempCurrent == current) {
				return -1;
			}
			tempCurrent = tempCurrent.next;
			tempPosition++;
		}
		return tempPosition;
	}

	/**
	 * @param pos
	 *            , data- inserts element 'data' at 'pos' position
	 */
	public void insert(int pos, T data) {

		if ((pos == position + 1) || (position == -1)) {
			add(data);
		} else if (pos == 0) {
			Node<T> tempNode = head;
			head = new Node<T>(data);
			head.next = tempNode;
		} else {
			Node<T> tempCurrent = head;
			Node<T> tempPrev = null;
			int tempPosition = 0;
			while (tempPosition <= pos + 1) {
				tempPrev = tempCurrent;
				tempCurrent = tempCurrent.next;
				tempPosition++;
			}
			Node<T> newNode = new Node<T>(data);
			newNode.next = tempCurrent;
			tempPrev.next = newNode;
		}
		position++;
	}

	/**
	 * @return pops and returns last element in the list
	 */
	public T pop() {
		return pop(position);
	}

	/**
	 * @param location
	 *            - pops elements at given location
	 * @returns element popped
	 */
	public T pop(int location) {
		Node<T> tempCurrent = head;
		Node<T> tempPrev = null;
		int tempPosition = 0;
		position--;
		while (tempPosition != location) {
			tempPrev = tempCurrent;
			tempCurrent = tempCurrent.next;
			tempPosition++;
		}
		if (tempCurrent == head) {
			head = head.next;
			return tempCurrent.data;
		} else if (tempCurrent == current) {
			current = tempPrev;
			tempPrev.next = tempCurrent.next;
			return tempCurrent.data;
		} else {
			tempPrev.next = tempCurrent.next;
			return tempCurrent.data;
		}
	}

	/**
	 * @param location
	 * @returns object of given location
	 */
	public T get(int location) {
		Node<T> tempCurrent = head;
		int tempPosition = 0;

		while (tempPosition != location) {
			tempCurrent = tempCurrent.next;
			tempPosition++;
		}

		return tempCurrent.data;

	}
}
