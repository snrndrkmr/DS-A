package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class InOrder {
	public ArrayList<Character> inordertraversal(BinaryTreeNode root) {
		ArrayList<Character> res= new ArrayList<Character>();
		if(root == null) {
			return res;
		}
		Stack<BinaryTreeNode> s = new  Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
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
		BinaryTree t = new BinaryTree();
		InOrder i = new InOrder();
		BinaryTreeNode root = new BinaryTreeNode('a');
		t.insertInOrder(root, 'b');
		t.insertInOrder(root, 'c');
		t.insertInOrder(root, 'd');
		t.insertInOrder(root, 'e');
		t.insertInOrder(root, 'f');
		t.insertInOrder(root, 'g');
		t.insertInOrder(root, 'h');
		ArrayList<Character> res = i.inordertraversal(root);
		Iterator<Character> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
	}
}
