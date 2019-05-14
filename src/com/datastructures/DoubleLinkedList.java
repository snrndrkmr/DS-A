package com.datastructures;
import com.datastructures.model.DLLnode;
public class DoubleLinkedList {
DLLnode head;
DLLnode tail;
int length;
public DLLnode getHead() {
	return head;
}
public DoubleLinkedList() {
	head = new DLLnode(Integer.MIN_VALUE,null,null);
	tail=new DLLnode(Integer.MIN_VALUE,head,null);
	head.setNext(tail);
	length=0;
}
//Traverse through the list and print it
public void traverse() {
	DLLnode temp = head;
	System.out.println("DLL list is:");
	while(temp!=null) {
		System.out.println(temp.getData()+" ");
		temp=temp.getNext();
	}
}
public synchronized void insertAtBegin(int data) {
	DLLnode temp =new DLLnode(data,null,head.getNext());
	temp.getNext().setPrev(temp);
	head=temp;
	length +=1;
}
public synchronized void insertAtPosition(int data,int position) {
	if(position>length) {
		position =length;
	}
	if(position<0) {
		position=0;
	}
	if(head==null) {
		head=new DLLnode(data);
		tail=head;
	}
	else if(position==0) {
		DLLnode node = new DLLnode(data);
		node.setNext(head);
		head=node;
		length++;
	}
	// traverse to the given position
	//set current node next node prev to newnode and currentnode next to new node
	//set newnode next to currentnode next and prev to currentnode
	DLLnode temp =head;
	for(int i=1;i<position;i++) {
		temp=temp.getNext();
	}
	DLLnode node = new DLLnode(data);
	node.setNext(temp.getNext());
	node.setPrev(temp);
	node.getNext().setPrev(node);
	temp.setNext(node);
	length++;
}
public synchronized void insertAtEnd(int data) {
	DLLnode temp =new DLLnode(data,tail.getPrev(),tail);
	temp.getPrev().setNext(temp);
	tail.setPrev(temp);
}
//create a temp value equal to head value
//move the head node pointer to next node
//set temp next node prev to null
public void removeAtBegin() {
	DLLnode temp = head.getNext();
	head.setNext(temp.getNext());
	temp.getNext().setPrev(head);
	length --;
}

public void removeAtEnd() {
	DLLnode temp = tail.getPrev();
	tail.setPrev(temp.getPrev());
	temp.getPrev().setNext(tail);
	length--;
}
public void removeAtPosition(int position) {
	if(position<0) {
		position=0;
	}
	if(position>=length) {
		position=length-1;
	}
	if (head==null) {
		return;
	}
	if(position==0) {
		head=head.getNext();
		if(head==null)
			tail=null;
	}
	else {
	DLLnode temp=head;
	for(int i=0;i<position;i+=1) {
		temp=temp.getNext();
	}
	temp.getNext().setPrev(temp.getPrev());
	temp.getPrev().setNext(temp.getNext());
	}
	length-=1;
}
public static void main(String[] args) {
	DoubleLinkedList dll= new DoubleLinkedList();
	dll.insertAtBegin(10);
	dll.insertAtPosition(20, 1);
	dll.insertAtPosition(30, 2);
	dll.insertAtPosition(40, 3);
	dll.insertAtEnd(50);
	dll.traverse();
	dll.removeAtBegin();
	dll.removeAtPosition(1);
	dll.removeAtPosition(2);
	dll.removeAtPosition(3);
	dll.removeAtEnd();
	dll.traverse();
}
}
