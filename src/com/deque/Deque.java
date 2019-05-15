package com.deque;

public class Deque implements DequeADT{
	private DoubleListNode head;
	private DoubleListNode tail;
	private int length = 0;
	
	public Deque() {
		head = new DoubleListNode(Integer.MIN_VALUE,null,null);
		tail = new DoubleListNode(Integer.MIN_VALUE,head,null);
		head.setNext(tail);
		length=0;
	}

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
		DoubleListNode node = new DoubleListNode(data,null,head.getNext());
		node.getNext().setPrev(node);
		node.setNext(head);
		head = node;
		length++;
	}

	@Override
	public void InsertAtEnd(int data) {
		DoubleListNode node = new DoubleListNode(data,tail.getPrev(),tail);
		node.getPrev().setNext(node);
		tail.setPrev(node);
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
		DoubleListNode temp = tail.getPrev();
		if(isEmpty()) {
			throw new DequeError("Deque is Empty");
		}
		tail.setPrev(null);
		temp.setNext(null);
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
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println("\n");
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
