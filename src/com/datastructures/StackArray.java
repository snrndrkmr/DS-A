package com.datastructures;

public class StackArray {
	private int capacity;
	private final static int CAPACITY=10;
	private int stackRep[];
	private int top =-1;
	public StackArray() {
		this(CAPACITY);
	}
	public StackArray(int cap) {
		capacity=cap;
		stackRep=new int[capacity];
	}
	public int arraysize() {
		return (top+1);
	}
	public boolean isEmpty() {
		return (top<0);
	}
	public void push(int data) throws Exception {
		if(arraysize()==capacity) {
			throw new Exception("stack overflow exception");
		}
		
			stackRep[++top]=data;
	}
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("stack is empty");
		}
		return stackRep[top];
	}
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("stack underflow exception");
		}
		int data=stackRep[top];
		stackRep[top--]=Integer.MIN_VALUE;
		return data;
	}
	public void printStack() throws Exception{
		if(isEmpty()) {
			throw new Exception("stack underflow exception");
		}
			for(int i=0;i<arraysize();i++) {
				int temp  = stackRep[i];
				System.out.println(temp);
			}
			
		}
	public static void main(String[] args) throws Exception {
		StackArray stack =new StackArray();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.peek());
		stack.printStack();
		stack.pop();
		System.out.println("+++++++++++");
		stack.printStack();
		
	}
}
