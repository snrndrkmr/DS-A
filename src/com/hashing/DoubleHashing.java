package com.hashing;

public class DoubleHashing {
	public static void main(String[] args) {
		int m = 7;
		int value = m-(25%m);
		System.out.println(value);
	}
}
