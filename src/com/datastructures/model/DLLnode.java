package com.datastructures.model;

public class DLLnode {
	private int data;
	DLLnode next;
	DLLnode prev;

	public DLLnode(int data, DLLnode prev, DLLnode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public DLLnode(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

	public void setNext(DLLnode next) {
		this.next = next;
	}

	public DLLnode getNext() {
		return next;
	}

	public void setPrev(DLLnode prev) {
		this.prev = prev;
	}

	public DLLnode getPrev() {
		return prev;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
}
