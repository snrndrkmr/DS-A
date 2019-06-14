package com.tree;

public class AVLTreeNode {
	private int data;
	private AVLTreeNode left;
	private AVLTreeNode right;
	private AVLTreeNode height;
	
	public AVLTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = null;
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
	public void setHeight(AVLTreeNode height) {
		this.height = height;
	}
	public AVLTreeNode height() {
		return height;
	}
}
