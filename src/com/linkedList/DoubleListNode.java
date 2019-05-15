package com.linkedList;

public class DoubleListNode {
	private int data;
	private DoubleListNode next;
	private DoubleListNode prev;
	public DoubleListNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		prev = null;
		next = null;
	}
	public DoubleListNode(int data,DoubleListNode prev,DoubleListNode next) {
		this.data=data;
		this.prev = prev;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoubleListNode getNext() {
		return next;
	}
	public void setNext(DoubleListNode next) {
		this.next = next;
	}
	public DoubleListNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleListNode prev) {
		this.prev = prev;
	}
	
	
}
