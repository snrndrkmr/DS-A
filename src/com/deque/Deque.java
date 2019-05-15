package com.deque;

public class Deque implements DequeADT{
	private DoubleListNode head =null;
	private DoubleListNode tail=null;
	private int length = 0;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head == null && tail == null);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void InsertAtBegin(int data){
		DoubleListNode node = new DoubleListNode(data);
		head.setNext(node);
		head.setPrev(null);
		head = node;
		length++;
	}

	@Override
	public void InsertAtEnd(int data) {
		DoubleListNode node = new DoubleListNode(data);
		tail.setNext(null);
		tail.setPrev(node);
		tail = node;
		length++;
		
	}

	@Override
	public int DeleteAtFront() throws DequeError {
		DoubleListNode temp = head.getNext();
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		head.setNext(null);
		head = temp;
		length--;
		return head.getData();
	}

	@Override
	public int DeleteAtEnd() throws DequeError {
		DoubleListNode temp = tail.getNext();
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		tail.setNext(null);
		tail = temp;
		length--;
		return tail.getData();
	}

	@Override
	public int front() throws DequeError {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		return head.getData();
	}

	@Override
	public int rear() throws DequeError {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		return tail.getData();
	}

	@Override
	public void printDeque() throws DequeError {
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		DoubleListNode temp = head;
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	public static void main(String[] args) throws Exception{
	 Deque q = new Deque();
	 q.InsertAtBegin(10);
	 q.InsertAtEnd(40);
	 q.InsertAtBegin(20);
	 q.InsertAtEnd(30);
	 q.InsertAtBegin(50);
	 q.InsertAtEnd(80);
	 q.InsertAtBegin(60);
	 q.InsertAtEnd(70);
	 q.printDeque();
	 System.out.println("++++++");
	 System.out.println(q.front());
	 System.out.println(q.rear());
	 System.out.println("++++++");
	 q.DeleteAtEnd();
	 q.DeleteAtFront();
	 q.DeleteAtEnd();
	 q.DeleteAtFront();
	 System.out.println("++++++");
	 System.out.println(q.front());
	 System.out.println(q.rear());
	 
	}
}
