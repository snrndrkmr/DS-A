package com.sorting;

public class Swap {
	public int[] swapElements(int a,int b) {
		int[] arr = new int[2];
		int temp = a;
		a=b;
		b=temp;
		arr[0] = a;
		arr[1] = b;
		return arr;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stu
		swapElements(10, 15);
	}
*/
}
