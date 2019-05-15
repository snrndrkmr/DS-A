package com.linkedList;

public interface Doubly {
	public boolean isEmpty();
	public int size();
	public void InsertAtBegin(int data);
	public void InsertAtPosition(int position,int data);
	public void InsertAtEnd(int data);
	public void DeleteAtPosition(int position);
	public void DeleteAtBegin();
	public void DeleteAtEnd();
	public void PrintList();
}
