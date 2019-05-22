package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	public ArrayList<Character> levelorder(BinaryTreeNode root){
		ArrayList<Character> res = new ArrayList<Character>();
		if(root==null) {
			return res;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			res.add(temp.getData());
			if(temp.getLeft()!=null) {
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null) {
				q.offer(temp.getRight());
			}
		}
		return res;
	}
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		LevelOrder l = new LevelOrder();
		BinaryTreeNode root = new BinaryTreeNode('a');
		t.insertInOrder(root, 'b');
		t.insertInOrder(root, 'c');
		t.insertInOrder(root, 'd');
		t.insertInOrder(root, 'e');
		t.insertInOrder(root, 'f');
		t.insertInOrder(root, 'g');
		t.insertInOrder(root, 'h');
		l.levelorder(root);
		ArrayList<Character> res =l.levelorder(root);;
		Iterator<Character> iter = res.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
	}
}
