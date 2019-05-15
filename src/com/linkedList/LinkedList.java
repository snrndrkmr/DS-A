package com.linkedList;

public class LinkedList{
	static ListNode head = null;
	static int length =0;
	public void insertAtBegin(int data) {
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head=newNode;
		length++;
	}
	public static boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	public static int size() {
		return length;
	}
	public void printList() {
		ListNode temp = head;
		while(temp.getNext()!=null) {
			System.out.println(temp.getdata());
			temp = temp.getNext();
		}
		System.out.println(temp.getdata());
	}
	public void insertAtMiddle(int position,int data) {
		if(head==null) {
			head=new ListNode(data);
		}
		else if(position<0) {
			position=0;
		}
		else if(position>length) {
			position=length;
		}
		else if(position==0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head=temp;
		}
		else {
			ListNode temp = head;
			for(int i=1;i<position;i++) {
				temp=temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);

		}
		length++;
		
	}
	public void insertAtEnd(int data) {
		ListNode node = new ListNode(data);
		if(head==null) {
			head=node;
		}
		else {
			ListNode temp = head;
			while(temp.getNext() !=null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		
	}
	public void deleteAtKey(int position) {
		
		ListNode temp = head;
		for(int i=0;i<position-1;i++) {
			temp = temp.getNext();
		}
		System.out.println(temp.getdata());
		temp.setNext(temp.getNext().getNext());
		length--;
	}
	public void deleteAtBegin() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return ;
		}
		ListNode temp=head;
		head=temp.getNext();
		temp.setNext(null);
		length--;
	}
	public void deleteAtEnd() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return ;
		}
		ListNode temp = head;
		ListNode q =null;
		ListNode next = temp.getNext();
		if(next==null) {
			head=null;
		}
		while((next=temp.getNext())!=null) {
			q = temp;
			temp=next;
		}
		q.setNext(null);
		length--;
	}
	public void clearList() {
		head=null;
		length=0;
	}
	public ListNode reverseList(ListNode head) {
		ListNode current,next,prev;
		prev =null;
		current = head;
		while(current.getNext()!=null) {
			next = current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		head=prev;
		return head;
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insertAtBegin(10);
		list.insertAtMiddle(1,20);
		list.insertAtMiddle(2, 30);
		list.insertAtMiddle(3, 40);
		list.insertAtEnd(50);
		list.printList();
		System.out.println("+++++++++++++");
		/*list.deleteAtKey(2);
		list.deleteAtBegin();
		list.deleteAtEnd();
		System.out.println("+++++++++++++");
		list.printList();
		System.out.println(list.size());*/
		ListNode temp = list.reverseList(head);
		while(temp.getNext()!=null) {
			System.out.println(temp.getdata());
			temp = temp.getNext();
		}
		System.out.println(temp.getdata());
		
		
	}

}
