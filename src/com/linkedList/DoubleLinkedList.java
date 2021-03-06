package com.linkedList;



public class DoubleLinkedList implements Doubly{
	
	private static DoubleListNode head;
	private DoubleListNode tail;
	private int length;
	
	public DoubleLinkedList() {
		head = new DoubleListNode(Integer.MIN_VALUE,null,null);
		tail = new DoubleListNode(Integer.MIN_VALUE,head,null);
		head.setNext(tail);
		length =0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head==null);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void InsertAtBegin(int data) {
		// TODO Auto-generated method stub
		DoubleListNode newNode = new DoubleListNode(data,null,head);
		newNode.getNext().setPrev(newNode);
		/*newNode.setNext(head);*/
		head = newNode;
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
		DoubleListNode newNode = new DoubleListNode(data,tail.getPrev(),tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
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
		if(isEmpty()) {
			System.out.println("list is empty");
			return;
		}
		DoubleListNode temp = head.getNext();
		head.setNext(null);
		head=temp;
		length--;
		
	}

	@Override
	public void DeleteAtEnd() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("list is empty");
			return;
		}
		DoubleListNode temp = tail.getPrev();
		tail.getPrev().setNext(null);
		tail.setPrev(null);
		tail=temp;
		length--;
	}

	@Override
	public void PrintList() {
		// TODO Auto-generated method stub
		DoubleListNode temp = head;
		System.out.println("the list is:");
		while(temp!=null) {
			
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println("\n");
	}
	public void reversePrint() {
		DoubleListNode temp = tail;
		System.out.println("the reverse list is:");
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getPrev();
		}
		System.out.println("\n");
	}
	public void recursion(DoubleListNode head) {
		if(head==null) {
			return ;
		}
			System.out.print(head.getData()+" ");
			recursion(head.getNext());
	}
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.InsertAtBegin(60);
		list.InsertAtBegin(10);
		list.InsertAtBegin(50);
		list.InsertAtBegin(80);
		list.InsertAtEnd(40);
		list.InsertAtEnd(70);
		list.InsertAtEnd(90);
		list.InsertAtPosition(1, 20);
		list.InsertAtPosition(2, 30);
		list.InsertAtPosition(4, 100);
		
		list.PrintList();
		list.reversePrint();
		list.DeleteAtBegin();
		list.DeleteAtBegin();
		list.DeleteAtEnd();
		list.DeleteAtEnd();
		System.out.println("the recursive list is:");
		list.recursion(head);
		System.out.println("\n");
		list.DeleteAtPosition(2);
		list.recursion(head);
	}


}
