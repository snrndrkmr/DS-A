package com.linkedList;

public class CircularLinkedList implements Doubly{
	private DoubleListNode head;
	private DoubleListNode tail;
	private int length;
	public CircularLinkedList() {
		head = new DoubleListNode(Integer.MIN_VALUE,null,null);
		tail = new DoubleListNode(Integer.MIN_VALUE,null,null);
		head.setNext(tail);
		head.setPrev(tail);
		tail.setPrev(head);
		tail.setNext(head);
		length =0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head == null);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void InsertAtBegin(int data) {
		// TODO Auto-generated method stub
		DoubleListNode node = new DoubleListNode(data,tail,head);
		tail = head.getPrev();
		node.setNext(head);
		node.setPrev(tail);
		tail.setNext(node);
		head.setPrev(node);
		head=node;
		length++;
		
	}

	@Override
	public void InsertAtPosition(int position, int data) {
		// TODO Auto-generated method stub
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length;
		}
		if(isEmpty()) {
			head = new DoubleListNode(data);
			tail=head;
		}
		else if( position==0 ) {
			DoubleListNode newNode = new DoubleListNode(data,null,head);
			newNode.getNext().setPrev(newNode);
			/*newNode.setNext(head);*/
			head = newNode;
			length++;
		}
		DoubleListNode newNode = new DoubleListNode(data);
		DoubleListNode temp = head;
		for(int i=1;i<position;i++) {
			temp=temp.getNext();
		}
		newNode.setNext(temp.getNext());
		newNode.setPrev(temp);
		newNode.getNext().setPrev(newNode);
		temp.setNext(newNode);
		length++;
	}

	@Override
	public void InsertAtEnd(int data) {
		// TODO Auto-generated method stub
		DoubleListNode node = new DoubleListNode(data,tail,head);
		head = tail.getNext();
		node.setNext(head);
		node.setPrev(tail);
		tail.setNext(node);
		head.setPrev(node);
		tail=node;
		length++;
		
	}

	@Override
	public void DeleteAtPosition(int position) {
		// TODO Auto-generated method stub
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length;
		}
		if(isEmpty()) {
			System.out.println("list is empty");
			return;
		}
		else if( position==0 ) {
			DoubleListNode temp = head.getNext();
			head.getNext().setPrev(null);
			head.setNext(null);
			head= temp;
			length--;
		}
		DoubleListNode temp = head;
		for(int i=1;i<position;i++) {
			temp = temp.getNext();
		}
		DoubleListNode node = temp.getNext();
		temp.setNext(node.getNext());
		node.getNext().setPrev(temp);
		node.setNext(null);
		node.setPrev(null);
		length--;
	}

	@Override
	public void DeleteAtBegin() {
		// TODO Auto-generated method stub
		DoubleListNode node = head.getNext();
		DoubleListNode tail = head.getPrev();
		tail.setNext(node);
		node.setPrev(tail);
		head.setNext(null);
		head.setPrev(null);
		head = node;
		length--;
		
	}

	@Override
	public void DeleteAtEnd() {
		// TODO Auto-generated method stub
		DoubleListNode node = tail.getPrev();
		DoubleListNode head = tail.getNext();
		node.setNext(head);
		head.setPrev(node);
		tail.setNext(null);
		tail.setPrev(null);
		tail=node;
		length--;
		
	}

	@Override
	public void PrintList() {
		// TODO Auto-generated method stub
		DoubleListNode temp = head;
		System.out.println("The List is");
		while(temp != tail) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.print(temp.getData()+" ");
		System.out.println("\n");
		System.out.println(length);
		
	}
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.InsertAtBegin(10);
		cll.InsertAtEnd(30);
		cll.InsertAtBegin(20);
		cll.InsertAtEnd(40);
		cll.PrintList();
		System.out.println("++++++++++++++");
		cll.DeleteAtBegin();
		cll.DeleteAtEnd();
		cll.PrintList();
	}
}
