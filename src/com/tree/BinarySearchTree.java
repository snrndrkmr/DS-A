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
	public BinarySearchTreeNode delete(BinarySearchTreeNode root, int data) {
		
		Stack<BinarySearchTreeNode> s = new Stack<BinarySearchTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinarySearchTreeNode temp = s.pop();
			if (temp != null) {
				if (temp.getData() == data) {
					BinarySearchTreeNode succ = findSuccessor(root);
					BinarySearchTreeNode pare = parentSuccesor(root);
					temp.setData(succ.getData());
					if (pare.getRight() == succ) {
						pare.setRight(null);
					}
				}
				if(temp.getData() > data) {
					if(temp.getLeft()!=null) {
						if(temp.getLeft().getData() == data) {
							BinarySearchTreeNode succ = findSuccessor(root);
							BinarySearchTreeNode pare = parentSuccesor(root);
							temp.setData(succ.getData());
							if (pare.getRight() == succ) {
								pare.setRight(null);
							}
						}
						s.push(temp.getLeft());
					}
					else if(temp.getRight()!=null) {
						if(temp.getRight().getData() == data) {
							BinarySearchTreeNode succ = findSuccessor(root);
							BinarySearchTreeNode pare = parentSuccesor(root);
							temp.setData(succ.getData());
							if (pare.getRight() == succ) {
								pare.setRight(null);
							}
						}
						s.push(temp.getRight());
					}
				}
			}
		}
		return root;
	}

	public BinarySearchTreeNode parentSuccesor(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinarySearchTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.getRight() != null) {
					if (temp.getRight() == findSuccessor(root)) {
						return temp;
					}
					q.offer(temp.getRight());
				}
				if (temp.getLeft() != null) {
					if (temp.getLeft() == findSuccessor(root)) {
						return temp;
					}
					q.offer(temp.getLeft());
				}
			}
		}
		return root;
	}
	public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode root) {
		if(root==null) {
			return null;
		}
		BinarySearchTreeNode current = root.getLeft();
		while(current!=null) {
			current = current.getRight();
			return current;
		}
		return current;
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
	public ArrayList<Integer> inorder(BinarySearchTreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
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
		int i =34;
		BinarySearchTreeNode var = t.search(root, i);
		if(var.getData()==i) {
			System.out.println("data found "+var.getData());
		}
		else {
			System.out.println("data not found "+var.getData());
		}
		BinarySearchTreeNode succ = t.findSuccessor(root);
		System.out.println(succ.getData());
		BinarySearchTreeNode pare = t.parentSuccesor(root);
		System.out.println(pare.getData());
		
		t.delete(root, 11);
		ArrayList<Integer> res = new ArrayList<Integer>();
		res = t.inorder(root);
		Iterator<Integer> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println("\n");
	}
}
