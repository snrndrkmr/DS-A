package com.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SimpleSearchPattern {
	public void Search(String string) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sub = br.readLine();
		int n = string.length();
		int m = sub.length();
		for(int i=0;i<=n-m;i++) {
			int j=0;
			while(j<m && sub.charAt(j)==string.charAt(i+j)) {
				System.out.print(sub.charAt(j)+" ");
				System.out.print(string.charAt(i+j)+" ");
				System.out.println();
				j = j+1;
			}
			if(j==m) {
				System.out.println("pattern found");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		SimpleSearchPattern pt = new SimpleSearchPattern();
		/*System.out.println("enter your age: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("enter your name");
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println("your age is: "+a+" and name is :"+str);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter your age: ");
		int age = Integer.parseInt(br.readLine());
		System.out.println("enter your name");
		String name = br.readLine();
		System.out.println("your age is: "+age+" and name is :"+name);*/
		System.out.println("search here:");
		pt.Search("abcdefghij");
	}
}
