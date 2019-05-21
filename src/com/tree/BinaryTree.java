package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public int length =0;
	static char arr;
	public boolean isEmpty(BinaryTreeNode root) {
		return (root==null);
	}
	public int size() {
		return length;
	}
	public BinaryTreeNode insertInOrder(BinaryTreeNode root,char data) {
		if(root==null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		length++;
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if(temp!=null) {
				//when we are inserting a existing node we are returning a new queue with new elements
				if(temp.getLeft()!=null) {
					q.offer(temp.getLeft());
				}
				//when we are inserting a new node and return the temp the same elements in the queue are returning
				else {
					BinaryTreeNode node = new BinaryTreeNode(data);
					temp.setLeft(node);
					length++;
					return temp;
				}
			}
			if(temp.getRight()!=null) {
				q.offer(temp.getRight());
			}
			else {
				BinaryTreeNode node = new BinaryTreeNode(data);
				temp.setRight(node);
				length++;
				return temp;
			}
		}
		
		return root;
	}
	public BinaryTreeNode deepestNode(BinaryTreeNode root) {
		BinaryTreeNode temp = null;
		if(root==null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			 temp = q.poll();
			if(temp.getLeft()!=null) {
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null) {
				q.offer(temp.getRight());
			}
		}
		return temp;
	}

	public BinaryTreeNode DeepestParent(BinaryTreeNode root) {
		BinaryTreeNode temp = null;
		BinaryTreeNode parent = null;
		if (root == null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
		}
		parent= temp;
		return parent;
	}
	public BinaryTreeNode deleteBinaryElement(BinaryTreeNode root,char data) {
		BinaryTreeNode temp=null;
		BinaryTreeNode deepest = deepestNode(root);
		BinaryTreeNode parent = DeepestParent(root);
		if(root==null) {
			return null;
		}
		if(root!=null && root.getData()==data && root.getLeft()==null && root.getRight()==null) {
			System.out.println("deleted root");
			root=null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			temp=q.poll();
			if(temp!=null && temp.getData()==data) {
				temp.setData(deepest.getData());
				/*deleteBinaryElement(deepest, deepest.getData());*/
				parent.setRight(null);
			}
			if(temp.getLeft()!=null) {
				if(temp.getLeft().getData()==data) {
					temp.getLeft().setData(deepest.getData());
					parent.setRight(null);
				}
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null) {
				if(temp.getRight().getData()==data) {
					temp.getRight().setData(deepest.getData());
					parent.setRight(null);
				}
				q.offer(temp.getRight());
			}
		}
		return temp;
	}
	public void preorder(BinaryTreeNode root) {
		if(root==null) {
			return ;
		}
		System.out.print(root.getData()+" ");
		preorder(root.getLeft());
		preorder(root.getRight());
	}
	public boolean ancestor(BinaryTreeNode root,BinaryTreeNode node) {
		if(root==null) {
			return false;
		}
		if(root.getLeft()==node || root.getRight()==node || 
				ancestor(root.getLeft(),node) || ancestor(root.getRight(),node)) {
			System.out.println(root.getData());
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		BinaryTreeNode root = new BinaryTreeNode('a');
		t.insertInOrder(root, 'b');
		t.insertInOrder(root, 'c');
		t.insertInOrder(root, 'd');
		t.insertInOrder(root, 'e');
		t.insertInOrder(root, 'f');
		t.insertInOrder(root, 'g');
		t.insertInOrder(root, 'h');
		t.preorder(root);
		System.out.println("\n");
		BinaryTreeNode temp = t.deepestNode(root);
		System.out.println(temp.getData());
		BinaryTreeNode temp2 = t.DeepestParent(root);
		System.out.println(temp2.getData());
		t.ancestor(root, temp2);
		/*t.deleteBinaryElement(root, 'a');
		t.preorder(root);*/
	}
}
