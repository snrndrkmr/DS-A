package com.queue;

import com.util.ListNode;

public class QueueLinkedList implements QueueADT{
	private ListNode rear=null;
	private ListNode front=null;
	private static int length=0;
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (rear==null);
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void Enqueue(int data) throws QueueIsFull {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(data);
		node.setNext(rear);
		rear = node;
		if(length<1) {
		front = rear;
		}
		length++;
		
	}

	@Override
	public int Dequeue() throws QueueIsFull {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueIsFull("queue is empty");
		}
		ListNode temp = front.getNext();
		front.setNext(null);
		front = temp;
		return front.getData();
	}

	@Override
	public int Front() throws QueueIsFull {
		// TODO Auto-generated method stub
		return front.getData();
	}

	@Override
	public int Rear() {
		// TODO Auto-generated method stub
		return rear.getData();
	}
	public void print() throws QueueIsFull{
		if(isEmpty()) {
			throw new QueueIsFull("queue is empty");
			
		}
		ListNode temp = front;
		while(front.getNext()!=null) {
			System.out.println(front.getData());
			front=front.getNext();
		}
		System.out.println(front.getData());
	}
	
	public static void main(String[] args) {
		QueueLinkedList q = new QueueLinkedList();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
		q.Enqueue(60);
		q.Enqueue(70);
		q.Enqueue(80);
		q.print();
		System.out.println("++++++");
		System.out.println(q.Front());
		System.out.println(q.Rear());
		System.out.println("++++++");
		q.Dequeue();
		q.Dequeue();
		System.out.println(q.Front());
		System.out.println(q.Rear());
		System.out.println("++++++");
		q.print();
		
	}
	
}
