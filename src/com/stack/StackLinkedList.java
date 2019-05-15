package com.stack;

import com.util.ListNode;

public class StackLinkedList implements Stack {
	private int length =0;
	private ListNode top = null;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top==null);
	}

	@Override
	public void Push(int obj) throws StackOverflowError{
		// TODO Auto-generated method stub
		ListNode node = new ListNode(obj);
		node.setNext(top);
		top = node;
		length++;
	}

	@Override
	public int Top() throws StackOverflow{
		if(isEmpty()) {
			throw new StackOverflow("stack is empty");
		}
		ListNode temp = top;
		return temp.getData();
	}
	
	@Override
	public int Pop() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackOverflow("stack is empty");
		}
		ListNode temp = top.getNext();
		top.setNext(null);
		top = temp;
		length--;
		return top.getData();
	}
	public void print() {
		if(isEmpty()) {
			throw new StackOverflow("stack is empty");
		}
		ListNode temp = top;
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	public static void main(String[] args) throws Exception{
		StackLinkedList s = new StackLinkedList();
		s.Push(10);
		s.Push(20);
		s.Push(30);
		s.Push(40);
		s.Push(50);
		s.Push(60);
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
