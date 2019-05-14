package com.stack;


public class StackArray implements Stack{
	public static final int CAPACITY =10;
	private int n;
	private int stackarr[];
	private int top = -1;
	public StackArray() {
		this(CAPACITY);
	}
	public StackArray(int cap) {
		n = cap;
		stackarr= new int[n];
	}
	@Override
	public int size() {
		return (top+1);
	}

	@Override
	public boolean isEmpty() {
		return (top<0);
	}

	@Override
	public int Top() throws StackOverflow{
		if(isEmpty()) {
			throw new StackOverflow("stack is empty");
		}
		return stackarr[top];
	}

	@Override
	public void Push(int obj) throws StackOverflow{
		if(size()==n) {
			throw new StackOverflow("stack is already full");
		}
		stackarr[++top]=obj;
		
	}

	@Override
	public int Pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("stack underflow exception");
		}
		int data=stackarr[top];
		stackarr[top--]=Integer.MIN_VALUE;
		return data;
	}
	public void print() {
		if(isEmpty()) {
			throw new StackOverflowError("stack is empty");
		}
		for(int i=0;i<size();i++) {
			int temp = stackarr[i];
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) throws Exception {
		StackArray s = new StackArray(20);
		s.Push(10);
		s.Push(20);
		s.Push(30);
		s.print();
		System.out.println("+++++++++++++");
		System.out.println(s.Top());
		System.out.println("+++++++++++++");
		s.Pop();
		s.Pop();
		System.out.println(s.Top());
		System.out.println("+++++++++++++");
		s.print();
		
	}

}
