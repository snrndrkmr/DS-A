package com.linkedList;



public class DoubleLinkedList implements Doubly{
	public DoubleListNode head = null;
	public DoubleListNode tail =null;
	int length = 0;
	public DoubleLinkedList() {
		head = new DoubleListNode(Integer.MIN_VALUE,null,null);
		tail = new DoubleListNode(Integer.MIN_VALUE,tail,null);
		head.setNext(tail);
		length=0;
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
		DoubleListNode node = new DoubleListNode(data,null,head.getNext());
		if(head==null) {
			head =node;
			return ;
		}
		node.getNext().setPrev(node);
		head = node;
		length++;
	}

	@Override
	public void InsertAtPosition(int position, int data) {
		if(position>length) {
			position=length;
		}
		if(position<0) {
			position=0;
		}
		if(head==null) {
			head = new DoubleListNode(data,null,head.getNext());
			tail = head;
		}
		else if(position==0) {
			DoubleListNode node = new DoubleListNode(data,null,head.getNext());
			node.getNext().setPrev(node);
			head=node;
			length++;
		}
			DoubleListNode temp = head;
			for(int i=1;i<position;i++) {
				temp=temp.getNext();
			}
			DoubleListNode node = new DoubleListNode(data);
			node.setNext(temp.getNext());
			node.getNext().setPrev(node);
			node.setPrev(temp);
			temp.setNext(node);
		length++;
	}

	@Override
	public void InsertAtEnd(int data) {
		DoubleListNode temp =new DoubleListNode(data,tail.getPrev(),tail);
		temp.getPrev().setNext(temp);
		tail.setPrev(temp);
		length++;
	}

	@Override
	public void DeleteAtPosition(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteAtBegin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteAtEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PrintList() {
		// TODO Auto-generated method stub
		DoubleListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
	}
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.InsertAtBegin(60);
		list.InsertAtBegin(10);
		list.InsertAtEnd(40);
		list.InsertAtEnd(70);
		list.InsertAtPosition(1, 20);
		list.InsertAtPosition(2, 30);
		
		list.PrintList();
	}

}
