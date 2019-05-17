package com.hashing;

import com.linkedList.ListNode;

public class Chaining {
	public static final int CAPACITY = 100;
	private int n;
	private ListNode[] slots = null;
	private ListNode head=null;
	private int length=0;
	private int probelength=0;
	private int m = 7;
	private int position=0;
	public Chaining() {
		this(CAPACITY);
	}
	public Chaining(int cap) {
		n = cap;
		slots = new ListNode[n];
	}
	public boolean isEmpty() {
		return (head==null);
	}
	public int Chainsize() {
		return probelength;
	}
	public int size() {
		return length;
	}
	public void insert(int data) {
		int i = data % m;
		/*ListNode node = new ListNode(data);
		node.setNext(slots[i]);
		slots[i]=node;
		probelength++;*/
		if(slots[i]==null) {
			slots[i]= new ListNode(data);
			probelength++;
		}
		else  {
			ListNode temp = slots[i];
			while(temp.getNext()!=null)
			temp=temp.getNext();
			ListNode node = new ListNode(data);
			temp.setNext(node);
			probelength++;
		}
		length++;
	}

	public int search(int data) {
		int temp = data % m;
		ListNode node = slots[temp];
		while(node!=null) {
			if(node.getdata()==data) {
				return position;
			}
			position++;
			node = node.getNext();
			}
		
		return Integer.MIN_VALUE;

	}

	public void delete(int data) {
		int temp = data % m;
		ListNode node = slots[temp];
		int place = search(data);
		System.out.println(place);
		if(place==0) {
			ListNode node2 =slots[temp].getNext();
			slots[temp] =node2;
			slots[temp].setNext(null);
		}
		for (int i = 0; i < place - 1; i++) {
			node = node.getNext();
		}
		ListNode swap = node.getNext();
		node.setNext(swap.getNext());
		swap.setNext(null);

	}

	public void traverse() {
		for(int i=0;i<slots.length;i++) {
			ListNode temp = slots[i];
			while(temp!=null) {
				System.out.print(temp.getdata()+" ");
				temp=temp.getNext();
			}
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		Chaining ch = new Chaining();
		ch.insert(25);
		ch.insert(19);
		ch.insert(12);
		ch.insert(32);
		ch.insert(39);
		ch.insert(46);
		ch.insert(40);
		ch.insert(41);
		ch.traverse();
		/*System.out.println("data found at position "+ch.search(32));*/
		ch.delete(32);
		ch.traverse();
	}
}
