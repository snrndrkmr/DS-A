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
		int left = Height(root.getLeft());
		int right = Height(root.getRight());
		return Math.max(left, right)+1;
	}
	public AVLTreeNode delete(AVLTreeNode root,int data) {
		if(root==null) {
			return null;
		}
		else if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(),data));
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
			root.setRight(delete(root.getRight(),data));
			if(Height(root.getLeft())-Height(root.getRight()) == 2) {
				if(data > root.getLeft().getData()) {
					root = leftSingleRotate(root);
				}
				else {
					root = rightLeftDoubleRotate(root);
				}
			}
		}
		else {
			if(root.getLeft()!=null && root.getRight()!=null) {
				AVLTreeNode min = FindMin(root.getRight());
				root.setData(min.getData());
				root.setRight(delete(root.getRight(),min.getData()));
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
	public AVLTreeNode rightLeftDoubleRotate(AVLTreeNode root) {
		root.setRight(rightSingleRotate(root.getRight()));
		return leftSingleRotate(root);
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
		t.insert(root, 3);
		t.insert(root, 1);
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
		t.delete(root,data);
		t.inordertrav(root);
		System.out.println();
		ArrayList<Integer> res1 = t.preorder(root);
		Iterator<Integer> iter1 = res1.iterator();
		while(iter1.hasNext()) {
			System.out.print(iter1.next()+ " ");
		}
	}
}
