package com.tree;

public class BinarySearchTreeNode {
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	private int data;
	public BinarySearchTreeNode(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
	public BinarySearchTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}
	public BinarySearchTreeNode getRight() {
		return right;
	}
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
