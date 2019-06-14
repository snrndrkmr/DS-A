package com.tree;

public class AVLTree {
	public AVLTreeNode insert(AVLTreeNode root, int data) {
		if(root==null) {
			AVLTreeNode node = new AVLTreeNode(data);
			root = node;
		}
		else if(data > root.getData()) {
			root.setRight(insert(root.getRight(),data));
		}
		else if(data < root.getData()) {
			root.setLeft(insert(root.getLeft(),data));
		}
		return root;
	}
}
