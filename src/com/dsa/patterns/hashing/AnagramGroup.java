package com.dsa.patterns.hashing;

import java.util.*;

public class AnagramGroup {
    public static void main(String[] args){
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(words);
    }

    private static List<List<String>> groupAnagrams(String[] words){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for(String word: words){
            Arrays.fill(counts, 0);
            for(char c: word.toCharArray()){
                counts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int count: counts){
                sb.append('#');
                sb.append(count);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        result.addAll(map.values());
        return result;
    }
}
