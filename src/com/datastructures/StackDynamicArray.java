package com.datastructures;
import com.datastructures.StackArray;
public class StackDynamicArray {
private int capacity;
private final static int CAPACITY=10;
private final static int MIN_CAPACITY=1<<15;
int top = -1;
int stackRep[];
public StackDynamicArray() {
	this(CAPACITY);
}
public StackDynamicArray(int cap) {
	// TODO Auto-generated constructor stub
	capacity =cap;
	stackRep=new int[capacity];
}
public void expand() {
	StackArray stack = new StackArray();
	int length = stack.arraysize();
	int[] new_stack = new int[length<<1];
	System.arraycopy(stackRep, 0, new_stack, 0, length);
	stackRep = new_stack;
	this.capacity = this.capacity<<1;
	}
public void shrink() {
	int length =top+1;
	while(length<=MIN_CAPACITY || top<<2>stackRep.length) {
		return;
	}
	length=length<<1;
	if(length<MIN_CAPACITY) {
		length = MIN_CAPACITY;
	}
	int[] new_array = new int[length];
	System.arraycopy(stackRep, 0, new_array, 0, top+1);
	stackRep=new_array;
}
}
