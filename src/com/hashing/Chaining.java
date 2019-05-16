package com.hashing;

public class Chaining {
	public static final int CAPACITY = 100;
	private int n;
	private int[] slots;
	private ListNode head=null;
	private int length=0;
	private int index =-1;
	private int probelength=0;
	private int m = 3;
	public Chaining() {
		this(CAPACITY);
	}
	public Chaining(int cap) {
		n = cap;
		slots = new int[n];
	}
	public boolean isEmpty() {
		return (index<0);
	}
	public int Chainsize() {
		return probelength;
	}
	public int size() {
		return length;
	}
	public void insert(int data) {
		
	}
	public int search() {
		return 0;
	}
	public int delete(int data) {
		return 0;
	}
}
