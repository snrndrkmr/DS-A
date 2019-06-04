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
	public BinarySearchTreeNode FindMin(BinarySearchTreeNode root) {
		if(root==null) {
			return root;
		}
		while(root.getLeft()!=null) {
			root = root.getLeft();
		}
		return root;
	}
	public BinarySearchTreeNode FindMax(BinarySearchTreeNode root) {
		if(root==null) {
			return root;
		}
		while(root.getRight()!=null) {
			root = root.getRight();
		}
		return root;
	}
	public BinarySearchTreeNode delete(BinarySearchTreeNode root,int data) {
		if (root == null)
			return null;
		if (root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data)); 
		} else if (root.getData()< data) {
			root.setRight(delete(root.getRight(), data));
 
		} else {
			// if nodeToBeDeleted have both children
			if (root.getLeft() != null && root.getRight() != null) {
				BinarySearchTreeNode minNodeForRight = FindMin(root.getRight());
				root.setData(minNodeForRight.getData());
				delete(root.getRight(), minNodeForRight.getData());
 
			}
			// if nodeToBeDeleted has only left child
			else if (root.getLeft() != null) {
				BinarySearchTreeNode temp = root;
				root = root.getLeft();
				temp = null;
			}
			// if nodeToBeDeleted has only right child
			else if (root.getRight() != null) {
				BinarySearchTreeNode temp = root;
				root = root.getRight();
				temp = null;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}
	public BinarySearchTreeNode deleteNode(BinarySearchTreeNode root, int data) {
		if(root==null) {
			return null;
		}
		root = search(root,data);
		root = root.getRight();
		BinarySearchTreeNode temp = FindMin(root.getRight());
		while(root.getLeft()!=null) {
			if(root.getData()==temp.getData()) {
				return temp;
			}
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
	public ArrayList<Integer> print(BinarySearchTreeNode root){
		ArrayList<Integer> res= inorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		return res;
	}
	public void inordertrav(BinarySearchTreeNode root) {
		if(root==null) {
			return;
		}
		inordertrav(root.getLeft());
		System.out.print(root.getData()+" ");
		inordertrav(root.getRight());
	}
	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(25);
		BinarySearchTree t = new BinarySearchTree();
		t.insertion(root, 15);
		t.insertion(root, 35);
		t.insertion(root, 30);
		t.insertion(root, 40);
		t.insertion(root, 10);
		t.insertion(root, 20);
		t.insertion(root, 29);
		t.insertion(root, 32);
		t.insertion(root, 33);
		t.insertion(root, 39);
		t.insertion(root, 41);
		t.insertion(root, 9);
		t.insertion(root, 11);
		t.insertion(root, 19);
		t.insertion(root, 21);
		t.insertion(root, 26);
		t.insertion(root, 27);
		t.insertion(root, 28);
		t.inordertrav(root);
		System.out.println();
		int data = 25 ;
		BinarySearchTreeNode temp = t.search(root, data);
		if(temp.getData()==data) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println(t.inordersuccessor(root, 25).getData());
		System.out.println(t.FindMin(root).getData());
		System.out.println(t.FindMax(root).getData());
		System.out.println();
		t.delete(root,30);
		t.delete(root, 39);
		t.delete(root, 19);
		t.inordertrav(root);
	}
}
