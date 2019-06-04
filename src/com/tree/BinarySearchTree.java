package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	public BinarySearchTreeNode insertion(BinarySearchTreeNode root,int data) {
		if (root == null) {
			BinarySearchTreeNode newNode = new BinarySearchTreeNode(data);
			root = newNode;
		} else if (data <= root.getData()) {
			root.setLeft(insertion(root.getLeft(), data));
		} else if (data > root.getData() ) {
			root.setRight(insertion(root.getRight(), data));
		}
		return root;
	}
	public BinarySearchTreeNode search(BinarySearchTreeNode root,int data) {
		if(root==null) {
			return null;
		}
		else if(root.getData()==data) {
			return root;
		}
		else if(data <= root.getData()) {
			return search(root.getLeft(),data);
		}
		else if(data > root.getData()) {
			return search(root.getRight(),data);
		}
		return root;
	}
	public BinarySearchTreeNode inordersuccessor(BinarySearchTreeNode root,int data) {
		if(root==null) {
			return null;
		}
		root = search(root,data);
		root = root.getRight();
		while(root.getLeft()!=null) {
			root = root.getLeft();
		}
		return root;
	}
	public ArrayList<Integer> inorder(BinarySearchTreeNode root) {
		if(root==null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
		BinarySearchTreeNode current = root;
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
	public ArrayList<Integer> preorder(BinarySearchTreeNode root) {
		if(root==null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinarySearchTreeNode temp = s.pop();
			if(temp!=null) {
				res.add(temp.getData());
				if(temp.getRight()!=null) {
					s.push(temp.getRight());
				}
				else if(temp.getLeft()!=null) {
					s.push(temp.getLeft());
				}
			}
		}
		return res;
	}
	public ArrayList<Integer> postorder(BinarySearchTreeNode root) {
		if(root==null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
		s.push(root);
		BinarySearchTreeNode prev =null;
		while(!s.isEmpty()) {
			BinarySearchTreeNode current = s.peek();
			if(prev==null || prev.getRight() == current || prev.getLeft()==current) {
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
	public static void main(String[] args) {
		BinarySearchTreeNode root = null;
		BinarySearchTree t = new BinarySearchTree();
		root = t.insertion(root, 25);
		root = t.insertion(root, 15);
		root = t.insertion(root, 35);
		root = t.insertion(root, 30);
		root = t.insertion(root, 40);
		root = t.insertion(root, 10);
		root = t.insertion(root, 20);
		root = t.insertion(root, 29);
		root = t.insertion(root, 32);
		root = t.insertion(root, 39);
		root = t.insertion(root, 41);
		root = t.insertion(root, 9);
		root = t.insertion(root, 11);
		root = t.insertion(root, 19);
		root = t.insertion(root, 21);
		root = t.insertion(root, 26);
		root = t.insertion(root, 27);
		root = t.insertion(root, 28);
		root = t.insertion(root, 31);
		ArrayList<Integer> res= t.inorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println("\n");
		int data = 25 ;
		BinarySearchTreeNode temp = t.search(root, data);
		if(temp.getData()==data) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println(t.inordersuccessor(root, 25).getData());
	}
}
