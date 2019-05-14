package com.datastructures.model;

public class Listnode {
	private Listnode next;
	private int data;
	public Listnode(int data) {
		this.data = data;
		next=null;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setNext(Listnode next) {
		this.next = next;
	}

	public Listnode getNext() {
		return next;
	}
}
