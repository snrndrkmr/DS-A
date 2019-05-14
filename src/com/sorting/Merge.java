package com.sorting;

public class Merge {
	//problem---sort the given array in increasing order using merge sort recursion method
	//logic--using divide and conquer algorithm divide the array into two equal halves and store them in two auxillary arrays
	//compare left and right array elements if left < right merge left element into main array else right element
	//again divide the arrays into equal halves upto 1 element partition
	//sort the divided parts and merge with the arrays back.
	//Time complexity of merge sort is O(nlogn)
 public static void MergeSort(int[] a) {
	 int n=a.length;
	 int m = n/2;
	 int[] arr1 = new int[m];
	 int[] arr2 = new int[n-m];
	 if(m<1) {
		 return ;
	 }
	 for(int i=0;i<m;i++) {
		 arr1[i]=a[i];
	 }
	 for(int j=m;j<n;j++) {
		 arr2[j-m]=a[j];
	 }
	 MergeSort(arr1);
	 MergeSort(arr2);
	 MergeLogic(a,arr1,arr2);
 }
 public static void MergeLogic(int[] a,int[] l,int[] r) {
	 int nl = l.length;
	 int nr = r.length;
	 int i=0,j=0,k =0;
	 while(i<nl && j<nr) {
		 if(l[i]<=r[j]) {
			 a[k] = l[i];
			 i++;
		 }
		 else if(l[i]>=r[j]){
			 a[k] = r[j];
			 j++;
		 }
		 k++;
	 }
	 while(i<nl) {
		 a[k]=l[i];
		 i++;
		 k++;
	 }
	 while(j<nr) {
		 a[k]=r[j];
		 j++;
		 k++; 
	 }
 }
 public static void main(String[] args) {
	 int a[] = {7,3,8,2,1,4,6,9,11,34};
		MergeSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
 }
}
