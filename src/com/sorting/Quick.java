package com.sorting;

public class Quick {
	public static int partitioning(int[] a,int start, int end) {
		int pivot= a[end];
		int pindex = start;
		for(int i=start;i<end;i++) {
			if(a[i]<=pivot) {
				int temp=a[i];
				a[i]=a[pindex];
				a[pindex]=temp;
				pindex++;
			}
		}
		int temp=a[pindex];
		a[pindex]=a[end];
		a[end]=temp;
		return pindex;
	}
	public static void QuickSort(int[] a,int start,int end) {

		if(start<end) {
			int pindex = partitioning(a, start, end);
			QuickSort(a, start, pindex-1);
			QuickSort(a, pindex+1, end);
		}
	}
	public static void main(String[] args) {
		int a[] = {7,3,8,2,1,4,6,9,11,34};
		QuickSort(a, 0, 9);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
}
