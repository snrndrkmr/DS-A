package com.sorting;

public class Bubble {
	//Sort the given array in increasing order
	//using iterative method
	//compare i with j if i>j swap it until the array gets sorted
	//worst case time complexity is O(n^2)
	public static void BubbleSort(int[] a,int n) {
		Swap s = new Swap();
		int index;
		for(int i=0;i<n;i++) {
				index=i;
				for(int j=i+1;j<n;j++) {
					if(a[index]>a[j]) {
						/*int temp = a[i];
						a[i]=a[j];
						a[j]=temp;*/
						int[] change = s.swapElements(a[i], a[j]);
						a[i] = change[0];
						a[j] = change[1];
					}
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {7,3,8,2,1,4,6,9,11,34};
		BubbleSort(a, a.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
