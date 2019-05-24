package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PreOrder {
	public ArrayList<Character> preordertraversal(BinaryTreeNode root) {
		ArrayList<Character> res= new ArrayList<Character>();
		if(root==null) {
			return res;
		}
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp = s.pop();
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
		BinaryTree t = new BinaryTree();
		PreOrder i = new PreOrder();
		BinaryTreeNode root = new BinaryTreeNode('a');
		t.insertInOrder(root, 'b');
		t.insertInOrder(root, 'c');
		t.insertInOrder(root, 'd');
		t.insertInOrder(root, 'e');
		t.insertInOrder(root, 'f');
		t.insertInOrder(root, 'g');
		t.insertInOrder(root, 'h');
		ArrayList<Character> res = i.preordertraversal(root);
		Iterator<Character> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
	}
}
