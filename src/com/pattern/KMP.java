package com.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KMP {
	public String MaxSubString(String s) {
		String result = null;
		ArrayList<String> list = new ArrayList<>();
		int start = 0;
		while(start<=s.length()) {
			for(int i=start;i<=s.length();i++) {
				String res = s.substring(start, i);
				list.add(res);
			}
			start++;
		}
		Collections.sort(list);
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			result = iter.next();
		}
		return result;
	}
	public static void main(String[] args) {
		KMP k =new KMP();
		String result = k.MaxSubString("banana");
		System.out.println(result);
	}
}
