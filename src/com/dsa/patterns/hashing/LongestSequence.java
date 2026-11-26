package com.dsa.patterns.hashing;

import java.util.*;

public class LongestSequence {
    public static void main(String args[]){
        int [] input = {100,4,100,1,3,2};
        int output = longestConsecutive(input);
        System.out.println("Longest consecutive Sequence is " + output);
    }

// Input: nums = [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    private static int longestConsecutive(int[] input) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : input) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
 