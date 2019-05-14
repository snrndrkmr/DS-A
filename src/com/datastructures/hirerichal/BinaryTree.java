package com.datastructures.hirerichal;
import com.datastructures.model.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
//Insert a node into a binary tree
//there is no specific order for binary tree so we can insert wherever the node is empty
//for binary tree node insertion we use level order traversal to check the nodes are null at each level
//first check if root node is null i.e  if true return null then insert root node to the queue
	public BinaryTreeNode insertBinaryTree(BinaryTreeNode root,int data) {
		if(root==null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		//if queue is not empty i.e the root node has some data in it 
		//then check for left node if it is not null get left pointer and add to the tree else insert data to left node
		// the same for right node
		while(!q.isEmpty()) { // iterate until any node in the tree is empty to insert new data
			//start from the root node and then traverse
			BinaryTreeNode temp = q.poll();// q.poll will return the top element in the tree
			if(temp!=null) {
				if(temp.getLeft()!=null) {
					q.offer(temp.getLeft());
				}
				else {
					temp.left=new BinaryTreeNode(data);
					return root;
				}
			}
			if(temp.getRight()!=null) {
				q.offer(temp.getRight());
			}
			else {
				temp.right=new BinaryTreeNode(data);
				return root;
			}
		}
		return root;
	}
	// In Order Traversal using recursion left->root->right
	public void inOrder(BinaryTreeNode root) {
		if(root==null) {
			return ;
		}
		inOrder(root.left);
		System.out.println(root.data+" ");
		inOrder(root.right);
	}
	// Pre Order Traversal using recursion root->left->right
	public void preOrder(BinaryTreeNode root) {
		if(root==null) {
			return ;
		}
		System.out.println(root.data+" ");
		inOrder(root.left);
		inOrder(root.right);
	}
	// Post Order Traversal using recursion left->right->root
	public void postOrder(BinaryTreeNode root) {
		if(root==null) {
			return ;
		}
		inOrder(root.left);
		inOrder(root.right);
		System.out.println(root.data+" ");
	}
	//size of the tree include root here in return 1 is root count
	public int size(BinaryTreeNode root) {
		int leftcount=root.left==null?0:size(root.left);
		int rightcount=root.right==null?0:size(root.right);
		return 1+leftcount+rightcount;
	}
	//delete a binary tree node at given position
	public void deleteTree(BinaryTreeNode root) {
		 root =null;
	}
	public BinaryTreeNode deepestNode(BinaryTreeNode root) {
		BinaryTreeNode temp = null;
		if(root ==null)
			return null;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			temp=q.poll();
			if(temp.getLeft()!=null) {
				q.offer(temp.getLeft());
			}
			
			if(temp.getRight()!=null) {
				q.offer(temp.getRight());
			}
		}
		return temp;
	}
	/*Starting at root, find the node which we want to delete.
	Find the deepest node in the tree.
	Replace the deepest node’s data with node to be deleted.
	Then delete the deepest node.*/
	public void deleteTreeNode(BinaryTreeNode root,int key) {
		BinaryTree tree = new BinaryTree();
		if(root.data==key) {
			root=tree.deepestNode(root);
			/*tree.deepestNode(root)=key_node;*/
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode key_node = tree.deepestNode(root);
		while(!q.isEmpty()) {
			BinaryTreeNode temp=q.poll();
			if(temp!=null) {
			if(temp.getLeft()!=null && temp.getLeft().data==key) {
				temp.setLeft(key_node);
				
			}
			if(temp.getRight()!=null && temp.getRight().data==key) {
				temp.setRight(key_node);
			}
			}
			
		}
		q.remove(key_node);
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BinaryTreeNode root;
		root = new BinaryTreeNode(10);
		/*root.left = new BinaryTreeNode(15);
		root.right = new BinaryTreeNode(20);*/
		tree.inOrder(root);
		tree.insertBinaryTree(root, 25);
		tree.insertBinaryTree(root, 30);
		tree.insertBinaryTree(root, 35);
		tree.insertBinaryTree(root, 40);
		tree.insertBinaryTree(root, 45);
		tree.insertBinaryTree(root, 50);
		/*System.out.println("In Order Traversal after insertion");
		tree.inOrder(root);
		System.out.println("pre Order Traversal after insertion");
		tree.preOrder(root);
		System.out.println("post Order Traversal after insertion");
		tree.postOrder(root);*/
		System.out.println("tree size is "+tree.size(root));
		System.out.println("deepest node is "+tree.deepestNode(root));
		tree.deleteTreeNode(root,25);
		System.out.println("pre Order Traversal after insertion");
		tree.preOrder(root);
	}
}
