package com.stack;

public interface Stack {
	public int size();
	public boolean isEmpty();
	public int Top() throws StackOverflow;
	public void Push(int obj) throws StackOverflow;
	public int Pop() throws Exception;
}
