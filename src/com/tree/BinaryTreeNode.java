package com.tree;

public class BinaryTreeNode {
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private char data;
	public BinaryTreeNode(char data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
}
