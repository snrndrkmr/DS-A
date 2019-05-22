package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	public void insertion(BinarySearchTreeNode root, int data) {
		if (root == null) {
			return;
		}
		Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinarySearchTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.getData() < data) {
					if (temp.getRight() != null) {
						q.offer(temp.getRight());
					} else {
						BinarySearchTreeNode node = new BinarySearchTreeNode(data);
						temp.setRight(node);
					}
				} else {
					if (temp.getLeft() != null) {
						q.offer(temp.getLeft());
					} else {
						BinarySearchTreeNode node = new BinarySearchTreeNode(data);
						temp.setLeft(node);
					}
				}
			}
		}
	}
	public BinarySearchTreeNode search(BinarySearchTreeNode root,int data) {
		if(root==null) {
			return null;
		}
		Stack<BinarySearchTreeNode> s= new Stack<BinarySearchTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinarySearchTreeNode temp = s.pop();
			if(temp!=null) {
				if(temp.getData()==data) {
					return temp;
				}
				if(temp.getData()<data) {
					if(temp.getRight()!=null) {
						if(temp.getRight().getData()==data) {
							return temp.getRight();
						}
						s.push(temp.getRight());
					}
				}
				else {
					if(temp.getLeft()!=null) {
						if(temp.getLeft().getData()==data) {
							return temp.getLeft();
						}
						s.push(temp.getLeft());
					}
				}
			}
		}
		return root;
	}
	public ArrayList<Integer> preorder(BinarySearchTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinarySearchTreeNode temp = s.pop();
			if(temp!=null) {
				res.add(temp.getData());
				if(temp.getRight()!=null) {
					s.push(temp.getRight());
				}
				if(temp.getLeft()!=null) {
					s.push(temp.getLeft());
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		BinarySearchTreeNode root = new BinarySearchTreeNode(25);
		t.insertion(root, 11);
		t.insertion(root, 34);
		t.insertion(root, 27);
		t.insertion(root, 8);
		t.insertion(root, 67);
		t.insertion(root, 79);
		t.insertion(root, 15);
		/*BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		t.insertion(root, 2);
		t.insertion(root, 3);
		t.insertion(root, 4);
		t.insertion(root, 5);
		t.insertion(root, 6);
		t.insertion(root, 7);
		t.insertion(root, 8);*/
		ArrayList<Integer> res = new ArrayList<Integer>();
		res = t.preorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println("\n");
		int i =34;
		BinarySearchTreeNode var = t.search(root, i);
		if(var.getData()==i) {
			System.out.println("data found "+var.getData());
		}
		else {
			System.out.println("data not found "+var.getData());
		}
	}
}
