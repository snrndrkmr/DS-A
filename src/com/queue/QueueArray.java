package com.queue;

public class QueueArray implements QueueADT {
	public final static int CAPACITY =1024;
	private int n;
	private int front =0;
	private int rear =-1;
	int queue[];
	
	public QueueArray() {
		this(CAPACITY);
	}
	public QueueArray(int cap) {
		n = cap;
		queue = new int[n];
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (rear<0);
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return (rear+1);
	}

	@Override
	public void Enqueue(int data) throws QueueIsFull {
		// TODO Auto-generated method stub
		if(Size()==n) {
			throw new QueueIsFull("queue is full");
		}
		queue[++rear]=data;
		
	}

	@Override
	public int Dequeue() throws QueueIsFull {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueIsFull("queue is empty");
		}
		int temp = queue[front];
		queue[front++]=Integer.MIN_VALUE;
		return temp;
	}

	@Override
	public int Front() throws QueueIsFull {
		// TODO Auto-generated method stub
		return queue[front];
	}

	@Override
	public int Rear() {
		// TODO Auto-generated method stub
		return queue[rear];
	}
	public void print() {
		if(isEmpty()) {
			throw new QueueIsFull("queue is empty");
		}
		for(int i=front;i<Size();i++) {
			int temp = queue[i];
			System.out.println(temp);
		}
	}
	public static void main(String[] args) {
		QueueArray q = new QueueArray();
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
