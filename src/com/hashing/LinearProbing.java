package com.hashing;

public class LinearProbing {
	private final static int CAPACITY=100;
	private int linear[];
	private int n;
	private int m = 7;
	private static int length=0;
	private static int position=0;
	private static int delete =0;
	public LinearProbing() {
		this(CAPACITY);
	}
	public LinearProbing(int cap) {
		n = cap;
		linear = new int[n];
	}

	public void insert(int data) {
		int temp = data % m;
		if (length>linear.length) {
			System.out.println("the table is full");
		}
		while (linear[temp] != 0) {
			temp = (temp + 1);
		}
		linear[temp] = data;
		length++;
	}
	public int search(int data) {
		int value = data % m;
		while(linear[value]!=0) {
			if(linear[value]==data) {
				return position;
			}
			position++;
			value = value+1;
		}
		return position;
	}
	public int delete(int data) {
		int value = data % m;
		while(linear[value]!=0) {
			if(linear[value]==data) {
				linear[value]=Integer.MIN_VALUE;
			}
			value = value+1;
		}

		delete++;
		return delete;
	}
	public void rehash() {
		if(delete>4) {
			int arr[]=new int[linear.length-1];
			for(int i=0;i<linear.length;i++) {
				if(linear[i]>0) {
					arr[i]=linear[i];
					linear[i]=0;
					insert(arr[i]);
				}
				else {
					linear[i]=0;
				}
			}
		}
	}
	public void traverse() {
		for(int i=0;i<linear.length;i++) {
			System.out.print(linear[i]+" ");
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		LinearProbing lp = new LinearProbing();
		lp.insert(25);
		lp.insert(32);
		lp.insert(39);
		lp.insert(46);
		lp.insert(19);
		lp.insert(12);
		lp.insert(40);
		lp.insert(41);
		lp.insert(21);
		lp.insert(49);
		lp.insert(56);
		lp.insert(63);
		lp.insert(70);
		lp.insert(2);
		lp.traverse();
		/*System.out.println(length);
		System.out.println(lp.search(32));*/
		lp.delete(32);
		lp.delete(2);
		lp.delete(41);
		lp.delete(49);
		lp.delete(19);
		lp.traverse();
		System.out.println(delete);
		lp.rehash();
		lp.traverse();
		
	}
}
