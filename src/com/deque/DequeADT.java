package com.deque;

public interface DequeADT {
	public boolean isEmpty();
	public int size();
	public void InsertAtBegin(int data);
	public void InsertAtEnd(int data);
	public int DeleteAtFront() throws DequeError;
	public int DeleteAtEnd() throws DequeError;
	public int front() throws DequeError;
	public int rear() throws DequeError;
	public void printDeque() throws DequeError;
}
