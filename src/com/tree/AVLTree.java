package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class AVLTree {
	public AVLTreeNode insert(AVLTreeNode root, int data) {
		if(root==null) {
			AVLTreeNode node = new AVLTreeNode(data);
			root = node;
		}
		else if(data < root.getData()) {
			root.setLeft(insert(root.getLeft(),data));
			if(Height(root.getLeft())-Height(root.getRight()) == 2) {
				if(data < root.getLeft().getData()) {
					root = rightSingleRotate(root);
				}
				else {
					root = leftRightDoubleRotate(root);
				}
			}
		}
		else if(data > root.getData()) {
			root.setRight(insert(root.getRight(),data));
			if(Height(root.getLeft())-Height(root.getRight()) == 2) {
				if(data > root.getLeft().getData()) {
					root = leftSingleRotate(root);
				}
				else {
					root = rightLeftDoubleRotate(root);
				}
			}
		}
		return root;
	}
	public int Height(AVLTreeNode root) {
		if(root==null) {
			return -1;
		}
		else {
		return root.getHeight();
		}
	}
	public AVLTreeNode rightSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getLeft();
		root.setLeft(newRoot.getRight());
		newRoot.setRight(root);
		root.setHeight(Math.max(Height(root.getLeft()), Height(root.getRight()))+1);
		newRoot.setHeight(Math.max(Height(newRoot.getLeft()), root.getHeight())+1);
		return newRoot;
	}
	public AVLTreeNode leftSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getRight();
		root.setRight(newRoot.getRight());
		newRoot.setLeft(root);
		root.setHeight(Math.max(Height(root.getLeft()), Height(root.getRight()))+1);
		newRoot.setHeight(Math.max(Height(newRoot.getLeft()), root.getHeight())+1);
		return newRoot;
	}
	public AVLTreeNode leftRightDoubleRotate(AVLTreeNode root) {
		root.setLeft(leftSingleRotate(root.getLeft()));
		return rightSingleRotate(root);
	}
	public AVLTreeNode rightLeftDoubleRotate(AVLTreeNode root) {
		root.setRight(rightSingleRotate(root.getRight()));
		return leftSingleRotate(root);
	}
	public ArrayList<Integer> inorder(AVLTreeNode root){
		if(root == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<AVLTreeNode> s = new Stack<AVLTreeNode>();
		s.push(root);
		AVLTreeNode current = root;
		boolean done = false;
		while (!done) {
			if (current != null) {
				s.push(current);
				current = current.getLeft();
			} else {
				if (s.isEmpty()) {
					done = true;
				} else {
					current = s.pop();
					res.add(current.getData());
					current = current.getRight();
				}
			}
		}
		return res;
	}
	
	public ArrayList<Integer> postorder(AVLTreeNode root){
		if(root == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<AVLTreeNode> s = new Stack<AVLTreeNode>();
		s.push(root);
		AVLTreeNode prev = null;
		while(!s.isEmpty()) {
			AVLTreeNode current = s.peek();
			if(prev == null || prev.getRight() == current  || prev.getLeft() == current) {
				if(current.getLeft()!=null) {
					s.push(current.getLeft());
				}
				else if(current.getRight()!=null) {
					s.push(current.getRight());
				}
			}
			else if(current.getLeft() == prev) {
				if(current.getRight()!=null) {
					s.push(current.getRight());
				}
			}
			else {
				res.add(current.getData());
				s.pop();
			}
			prev = current;
		}
		return res;
	}
	public ArrayList<Integer> preorder(AVLTreeNode root){
		if(root == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<AVLTreeNode> s = new Stack<AVLTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			AVLTreeNode current = s.pop();
			if(current!=null) {
				res.add(current.getData());
				if(current.getRight()!=null) {
					s.push(current.getRight());
				}
				if(current.getLeft()!=null) {
					s.push(current.getLeft());
				}
			}
		}
		return res;
	}
	public AVLTreeNode searchAVL(AVLTreeNode root, int data) {
		if(root == null) {
			return null;
		}
		else if(data < root.getData()) {
			searchAVL(root.getLeft(),data);
		}
		else if(data > root.getData()) {
			searchAVL(root.getRight(),data);
		}
		else {
			return root;
		}
		return root;
	}
	public static void main(String[] args) {
		AVLTree t = new AVLTree();
		AVLTreeNode root = new AVLTreeNode(25);
		t.insert(root, 35);
		t.insert(root, 15);
		t.insert(root, 30);
		t.insert(root, 40);
		t.insert(root, 10);
		t.insert(root, 20);
		t.insert(root, 5);
		t.insert(root, 1);
		ArrayList<Integer> res = t.inorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
	}
}
