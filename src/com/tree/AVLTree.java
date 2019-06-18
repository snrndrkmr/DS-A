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
	public AVLTreeNode rightSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getLeft();
		root.setLeft(newRoot.getRight());
		newRoot.setRight(root);
		return newRoot;
	}
	public AVLTreeNode leftSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getRight();
		root.setRight(newRoot.getRight());
		newRoot.setLeft(root);
		return newRoot;
	}
	public AVLTreeNode leftRightDoubleRotate(AVLTreeNode root) {
		root.setLeft(leftSingleRotate(root.getLeft()));
		return rightSingleRotate(root);
	}
	public AVLTreeNode RightLeftDoubleRotate(AVLTreeNode root) {
		root.setRight(rightSingleRotate(root.getRight()));
		return leftSingleRotate(root);
	}
	
}
