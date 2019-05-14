package com.datastructures.model;

public class CLLnode {
 private int data;
 CLLnode tail;
 
 public CLLnode(int data) {
	 this.data=data;
	 tail=null;
 }
 public void setNext(CLLnode tail) {
	 this.tail=tail;
 }
 public CLLnode getNext() {
	 return tail;
 }
 public void setData(int data) {
	 this.data=data;
 }
 public int getData() {
	 return data;
 }
}
