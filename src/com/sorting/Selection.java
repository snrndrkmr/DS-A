package com.sorting;

public class Selection {
	
//given elements 7,3,8,2,1,4,6,9,11,34 arrange them in increasing order.
//traverse through the list from 1 to n and find min element.
//swap element at i with min element.
//worst case time complexity is O(n^2)

	/*static void selectionSort(int[] a) {
		int index;
		int temp;
		for(int i=0; i<a.length;i++) {
			index=a[i];
			for(int j=0; j<a.length;j++) {
				if(index<a[j]) {
					temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}*/
	static void selectionSort(int[] arr, int n) {
	// One by one move boundary of unsorted subarray 
		int length =0;
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) {
                	System.out.println("before"+arr[min_idx]);
                	System.out.println("+++++++++++++++++");
                    min_idx = j; 
                    System.out.println("after"+arr[min_idx]);
                    length++;
                }
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        }
        System.out.println(length);
	}
	public static void main(String[] args) {
		int a[] = {8,7,6,5,4,3,2,1};
		selectionSort(a,a.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
