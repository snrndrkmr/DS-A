package com.algorithms;

import java.util.ArrayList;
import java.util.Stack;

import com.datastructures.hirerichal.BinaryTree;
import com.datastructures.model.BinaryTreeNode;

public class PreOrderTraversal {
	
	public ArrayList<Integer> preOrderTraversal(BinaryTreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp = s.pop();
			res.add(temp.data);
			if(root.right!=null) {
				s.push(temp.right);
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}
		}
		return res;
	}
	public static void main(String args[]) {
		BinaryTree tree=  new BinaryTree();
		BinaryTreeNode root;
		root = new BinaryTreeNode(10);
		tree.insertBinaryTree(root, 20);
		tree.insertBinaryTree(root, 30);
		tree.insertBinaryTree(root, 40);
		tree.insertBinaryTree(root, 50);
		tree.insertBinaryTree(root, 60);
		tree.insertBinaryTree(root, 70);
		tree.preOrder(root);
		PreOrderTraversal pre = new PreOrderTraversal();
		System.out.println("after insertion preorder traversal is : "+pre.preOrderTraversal(root));
	}
}
