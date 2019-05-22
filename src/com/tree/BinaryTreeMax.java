package com.tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeMax {
	public BinaryTreeNode Max(BinaryTreeNode root) {
		if(root==null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode large = root;
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if(large.getData()<temp.getData()) {
				large = temp;
			}
			if(temp!=null) {
				if(temp.getLeft()!=null) {
					q.offer(temp.getLeft());
				}
				if(temp.getRight()!=null) {
					q.offer(temp.getRight());
				}
			}
		}
		
		
		return large;
	}
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		BinaryTreeMax b = new BinaryTreeMax();
		BinaryTreeNode root = new BinaryTreeNode('a');
		t.insertInOrder(root, 'e');
		t.insertInOrder(root, 'f');
		t.insertInOrder(root, 'g');
		t.insertInOrder(root, 'h');
		t.insertInOrder(root, 'b');
		t.insertInOrder(root, 'c');
		t.insertInOrder(root, 'd');
		
		BinaryTreeNode node = b.Max(root);
		System.out.println(node.getData());
	}
}
