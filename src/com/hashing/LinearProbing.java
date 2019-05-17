package com.hashing;

public class LinearProbing {
	private final static int CAPACITY=100;
	private int linear[];
	private int n;
	private int m = 7;
	public LinearProbing() {
		this(CAPACITY);
	}
	public LinearProbing(int cap) {
		n = cap;
		linear = new int[n];
	}

	public void insert(int data) {
		int temp = data % m;
		 if(temp>CAPACITY) {
			 
		 }
			while(linear[temp]!=0) {
	
				temp = (temp+1);
				
			}
			linear[temp]=data;
			
		
	}
	public void traverse() {
		for(int i=0;i<linear.length;i++) {
			System.out.print(linear[i]+" ");
		}
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
		lp.traverse();
	}
}
