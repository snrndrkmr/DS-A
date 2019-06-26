package com.heap;

public class Heap {
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	public Heap(int capacity,int heap_type) {
		this.heap_type = heap_type;
		this.count =0;
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	public int parent(int i) {
		int parent = (i-1)/2;
		if(i<=0 || i>=this.count) {
			return -1;
		}
		return parent;
	}
	public int leftChild(int i) {
		int left = (2*i)+1;
		if(left>= this.count) {
			return -1;
		}
		return left;
	}
	public int rightChild(int i) {
		int right = (2*i)+2;
		if(right>=this.count) {
			return -1;
		}
		return right;
	}
	public int MaxHeapMax() {
		if(this.count==0) {
			return -1;
		}
		return this.array[0];
	}
	public void TopDownHeap(int i) {
		int l,r,max,temp;
		l = leftChild(i);
		r = rightChild(i);
		if(l!=-1 && this.array[l]>this.array[i]) {
			max = l;
		}
		else max=i;
		if(r!=-1 && this.array[r] > this.array[max]) {
			max = r;
		}
		if(this.array[i]<this.array[max]) {
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
		}
		TopDownHeap(max);
	}
	
	public void insert(int data) {
		if(this.count == this.capacity) {
			resize();
		}
		this.count++;
		int i = this.count-1;
		while(i>=0 && data > this.array[(i-1)/2]) {
			this.array[i] = this.array[(i-1)/2];
			i = (i-1)/2;
		}
		this.array[i] = data;
	}
	public int delete() {
		if(this.count == 0) {
			return -1;
		}
		int data = this.array[0];
		this.array[0] = this.array[this.count-1];
		count--;
		TopDownHeap(0);
		return data;
	}
	public void resize() {
		int[] array_old = new int[capacity];
		System.arraycopy(this.array, 0, array_old, this.count-1, capacity);
		this.array = new int[capacity*2];
		if(this.array==null) {
			System.out.println("Memory Error");
			return;
		}
		for(int i=0;i<this.capacity;i++) {
			this.array[i] = array_old[i];
		}
		this.capacity*=2;
		array_old = null;
	}
	public void print() {
		System.out.println(this.array[0]);
	}
	public static void main(String[] args) {
		Heap heap = new Heap(10 ,1);
		heap.insert(25);
		heap.insert(15);
		heap.insert(40);
		heap.insert(20);
		heap.insert(10);
		heap.insert(35);
		heap.print();
	}
}
