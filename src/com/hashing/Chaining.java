package com.hashing;

public class Chaining {
	public static final int CAPACITY = 100;
	private int n;
	private ListNode[] slots = null;
	private ListNode head=null;
	private int length=0;
	private int probelength=0;
	private int m = 7;
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
		ListNode node = new ListNode(data);
		node.setNext(slots[i]);
		slots[i]=node;
		probelength++;
		/*if(slots[i]==null) {
			ListNode node = new ListNode(data);
			node.setNext(slots[i]);
			slots[i]=node;
		}
		else  {
			ListNode node = new ListNode(data);
			node.setNext(slots[i]);
			slots[i]=node;
			probelength++;
		}*/
		length++;
	}
	public int search(int data) {
		int position=0;
		int temp = data % m;
		for(int i=0;i<=temp;i++) {
			ListNode node = slots[i];
				while(node!=null) {
					if(node.getData()==data) {
						System.out.println("data found "+node.getData());
						}
					node = node.getNext();
					
					position++;
				}
				position++;
		}
		return position;
		
	}
	public int delete(int data) {
		return 0;
	}
	public void traverse() {
		for(int i=0;i<slots.length;i++) {
			ListNode temp = slots[i];
			while(temp!=null) {
				System.out.print(temp.getData()+" ");
				temp=temp.getNext();
			}
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		Chaining ch = new Chaining();
		ch.insert(25);
		ch.insert(12);
		ch.insert(32);
		ch.insert(39);
		ch.insert(40);
		ch.traverse();
		ch.search(12);
		int position = ch.search(10);
		System.out.println("data found at position "+position);
	}
}
