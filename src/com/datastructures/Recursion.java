package com.datastructures;

public class Recursion {

	public static void main(String[] args) {
		Recursion r =new Recursion();
		r.binary(5);
		/*System.out.println("the factorial is \t"+r.factorial(10));*/
	}
	/*public int factorial(int n) {
		if(n==0){
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}*/
	int a[];
	public void binary(int n) {
		if(n<1) {
		 System.out.println(a);
		}
		else {
			a[n-1]=0;
			binary(n-1);
			a[n-1]=1;
			binary(n-1);
		}
	}

}
