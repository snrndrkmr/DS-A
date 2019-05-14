package com.datastructures;
import com.datastructures.model.CLLnode;
public class CircularLinkedList {
CLLnode tail;
static int length;
public CircularLinkedList() {
	tail=null;
	length=0;
}
//Print circular linked list without running infine loop
public void PrintCLL() {
	CLLnode currentnode =tail;
	System.out.println("CLL is: ");
	if(currentnode != tail) {
		System.out.println(tail.getData() + "->");
		tail =tail.getNext();
	}
}
//get tail next and set it to temp next
//set tail next to temp
public void insertAtHead(int data) {
	CLLnode temp=new CLLnode(data);
	if(tail==null) {
		tail=temp;
		tail.setNext(tail);
	}
	else {
		temp.setNext(tail.getNext());
		tail.setNext(temp);
	}
	length++;
}
public void insertAtTail(int data) {
		insertAtHead(data);
		tail=tail.getNext();
	length++;
}
public int removeAtHead() {
	CLLnode temp =tail.getNext();
	if(tail==tail.getNext()) {
		tail = null;
	}
	else {
		tail.setNext(temp.getNext());
		temp.setNext(null);
	}
	return tail.getData();
}
public int removeTail() {
	CLLnode temp =tail;
	while(temp.getNext()!=tail) {
		temp=tail.getNext();
	}
	CLLnode temp1 =tail;
	if(temp==tail) {
		tail=null;
	}
	else {
		temp.setNext(tail.getNext());
		tail=temp;
	}
	length--;
	return tail.getData();
}
}
