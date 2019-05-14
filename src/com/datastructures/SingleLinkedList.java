package com.datastructures;
import java.io.*; 
public class SingleLinkedList {
	
Listnode head;
private static int length=0;	
	static class Listnode{
		int data; 
		Listnode next; 

	    // Constructor 
		Listnode(int d) 
	    { 
	        data = d; 
	        next = null; 
	    } 
	}
	
	

	// insert a node at the begining of the list
		public static SingleLinkedList InsertAtBegin(SingleLinkedList list, int data) {
			Listnode node = new Listnode(data);
			node.next=null;
			if (list.head == null) {
				 list.head=node;
			} else {
				// Else traverse till the last node
				// and insert the new_node there
				Listnode last = list.head;
				while (last.next != null) {
					last = last.next;
				}

				// Insert the new_node at last node
				last.next = node;
			}

			return list;
		}

	public static int getListLength(SingleLinkedList list) {
		Listnode currentnode = list.head;
		System.out.println("LinkedList is:");
		while (currentnode != null) {
			System.out.println(currentnode.data + " ");
			currentnode = currentnode.next;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
			/*list.clearLIst();*/
			list = InsertAtBegin(list, 10);
			list = InsertAtBegin(list, 11);
			getListLength(list);
	}

}
