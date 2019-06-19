package com.tree;

public class AVLTreeNode {
	private int data;
	private AVLTreeNode left;
	private AVLTreeNode right;
	
	public AVLTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}
	public AVLTreeNode getLeft() {
		return left;
	}
	public void setRight(AVLTreeNode right) {
		this.right = right;
	}
	public AVLTreeNode getRight() {
		return right;
	}
}
