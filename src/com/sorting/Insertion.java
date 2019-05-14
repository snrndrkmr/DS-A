package com.sorting;

public class Insertion {
	//Sort the given array elements in increasing order
	//using iterative method
	//if i < j loop until i > j, swap j to i and move all the elements before j to after j
	// worst case time complexity is O(n^2)
	public static void insertionSort(int[] a,int n) {
		int index;
		int hole;
		for(int i=1;i<n-1;i++) {
			index = a[i];
			hole = i;
			while(hole>0 && a[hole-1]>index) {
				a[hole] = a[hole-1];
				hole = hole-1;
			}
			a[hole]=index;
		}
	}
	public static void main(String[] args) {
		int a[] = {7,3,8,2,1,4,6,9,11,34};
		insertionSort(a,a.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
