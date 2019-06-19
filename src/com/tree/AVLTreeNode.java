package com.tree;

public class AVLTreeNode {
	private int data;
	private AVLTreeNode left;
	private AVLTreeNode right;
	private int height;
	
	public AVLTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.height =1;
	}
	
	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "AVLTreeNode [data=" + data + ", left=" + left + ", right=" + right + ", height=" + height + "]";
	}

	public void setHeight(int height) {
		this.height = height;
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
