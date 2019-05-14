package com.algorithms;
import com.datastructures.hirerichal.BinaryTree;
import com.datastructures.model.BinaryTreeNode;
public class InOrderTraversal {

	
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
	}
}
