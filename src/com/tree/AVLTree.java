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
		}
		else if(data > root.getData()) {
			root.setRight(insert(root.getRight(),data));
		}
		root.setHeight(Math.max(Height(root.getLeft()),Height(root.getRight()))+1);
		int balance = getBalance(root);
		if(balance>1 && data < root.getLeft().getData()) {
			return rightSingleRotate(root);
		}
		if(balance< -1 && data > root.getRight().getData()) {
			return leftSingleRotate(root);
		}
		if(balance>1 && data > root.getLeft().getData()) {
			root.setLeft(leftSingleRotate(root.getLeft()));
			return rightSingleRotate(root);
		}
		if(balance< -1 && data < root.getRight().getData()) {
			root.setRight(rightSingleRotate(root.getRight()));
			return leftSingleRotate(root);
		}
		return root;
	}
	public int Height(AVLTreeNode root) {
		if(root==null) {
			return 0;
		}
		return root.getHeight();
	}
	public AVLTreeNode delete(AVLTreeNode root,int data) {
		if(root==null) {
			return root;
		}
		else if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(),data));
		}
		else if(data > root.getData()) {
			root.setRight(delete(root.getRight(),data));
		}
		else {
			if(root.getLeft()!=null && root.getRight()!=null) {
				AVLTreeNode min = FindMax(root.getLeft());
				root.setData(min.getData());
				root.setLeft(delete(root.getLeft(),min.getData()));
			}
			else if(root.getLeft()!=null) {
				root = root.getLeft();
			}
			else if(root.getRight()!=null) {
				root = root.getRight();
			}
			else {
				root = null;
			}
		}
		if(root==null) {
			return root;
		}
		root.setHeight(Math.max(Height(root.getLeft()),Height(root.getRight()))+1);
		int balance = getBalance(root);
		if(balance>1 && getBalance(root.getLeft())>=0) {
			return rightSingleRotate(root);
		}
		if(balance>1 && getBalance(root.getLeft())<0) {
			root.setLeft(leftSingleRotate(root.getLeft()));
			return rightSingleRotate(root);
		}
		if(balance< -1 && getBalance(root.getRight())<=0) {
			return leftSingleRotate(root);
		}
		if(balance< -1 && getBalance(root.getRight())>0) {
			root.setRight(rightSingleRotate(root.getRight()));
			return leftSingleRotate(root);
		}
		return root;
	}
	public AVLTreeNode rightSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getLeft();
		AVLTreeNode temp = newRoot.getRight();
		newRoot.setRight(root);
		root.setLeft(temp);
		root.setHeight(Math.max(Height(root.getLeft()),Height(root.getRight()))+1);
		newRoot.setHeight(Math.max(Height(newRoot.getLeft()),Height(newRoot.getRight()))+1);
		return newRoot;
	}
	public AVLTreeNode leftSingleRotate(AVLTreeNode root) {
		AVLTreeNode newRoot = root.getRight();
		AVLTreeNode temp = newRoot.getLeft();
		newRoot.setLeft(root);
		root.setRight(temp);
		root.setHeight(Math.max(Height(root.getLeft()),Height(root.getRight()))+1);
		newRoot.setHeight(Math.max(Height(newRoot.getLeft()),Height(newRoot.getRight()))+1);
		return newRoot;
	}
	public int getBalance(AVLTreeNode root) {
		if(root==null) {
			return 0;
		}
		return Height(root.getLeft())-Height(root.getRight());
	}
	public ArrayList<Integer> inorder(AVLTreeNode root){
		ArrayList<Integer> res= new ArrayList<Integer>();
		if(root == null) {
			return null;
		}
		Stack<AVLTreeNode> s = new  Stack<AVLTreeNode>();
		AVLTreeNode current = root;
		boolean done = false;
		while(!done) {
			if(current!=null) {
				s.push(current);
				current = current.getLeft();
			}
			else {
				if(s.isEmpty()) {
					done = true;
				}
				else {
					current = s.pop();
					res.add(current.getData());
					current = current.getRight();
				}
			}
		}
		return res;
	}
	public void inordertrav(AVLTreeNode root) {
		if (root == null) {
			return;
		}
		inordertrav(root.getLeft());
		System.out.print(root.getData() + " ");
		inordertrav(root.getRight());
	}
	
	public ArrayList<Integer> postorder(AVLTreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
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
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
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
		else if(data == root.getData()) {
			return root;
		}
		else if(data < root.getData()) {
			return searchAVL(root.getLeft(),data);
		}
		else if(data > root.getData()) {
			return searchAVL(root.getRight(),data);
		}
		return root;
	}
	public AVLTreeNode FindMin(AVLTreeNode root) {
		if(root==null) {
			return null;
		}
		while(root.getLeft()!=null) {
			root = root.getLeft();
		}
		return root;
	}
	public AVLTreeNode FindMax(AVLTreeNode root) {
		if(root==null) {
			return null;
		}
		while(root.getRight()!=null) {
			root = root.getRight();
		}
		return root;
	}
	public static void main(String[] args) {
		AVLTree t = new AVLTree();
		AVLTreeNode root = null;
		root = t.insert(root, 25);
		root = t.insert(root, 35);
		root = t.insert(root, 15);
		root = t.insert(root, 30);
		root = t.insert(root, 40);
		root = t.insert(root, 45);
		root = t.insert(root, 50);
		root = t.insert(root, 10);
		root = t.insert(root, 20);
		root = t.insert(root, 5);
		root = t.insert(root, 3);
		root = t.insert(root, 1);
		t.inordertrav(root);
		System.out.println();
		ArrayList<Integer> res = t.preorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
		System.out.println();
		int data = 25;
		AVLTreeNode search = t.searchAVL(root, data);
		if(data == search.getData()) {
			System.out.println("Success data found "+search.getData());
		} else{
			System.out.println("Failure data not found "+ search.getData());
		}
		System.out.println();
		t.delete(root,25);
		t.delete(root, 30);
		t.inordertrav(root);
		System.out.println();
		ArrayList<Integer> res1 = t.preorder(root);
		Iterator<Integer> iter1 = res1.iterator();
		while(iter1.hasNext()) {
			System.out.print(iter1.next()+ " ");
		}
		System.out.println();
	}
}
