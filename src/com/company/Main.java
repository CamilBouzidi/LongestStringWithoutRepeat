package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Thank you to Leetcode https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class Main {

    public static void main(String[] args) {
        slidingWindowOptimize("dvdf");

    }

    public static int slidingWindow(String s){
        //Sliding window: [i,j)
        int n = s.length();
        Set<Character> found = new HashSet<>();
        int max=0,i=0,j=0;
        while (i<n && j<n){
            if (!found.contains(s.charAt(j))){
                //Store it in Hashset: unique string so far.
                found.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            } else {
                //Remove it from hashset. Unique string has to start later.
                found.remove(s.charAt(i));
                i++;
            }
        }
        System.out.println(max);
        return max;
    }

    public static int slidingWindowOptimize(String s){
        //Sliding window: [i,j)
        //Optimized: if s[j] has duplicate in range [i,j) with index j', skip all in [i,j'] and i=j'+1
        int n = s.length();
        Map<Character,Integer> found = new HashMap<>();
        int max=0;
        for (int j=0, i=0; j<n; j++){
            if (found.containsKey(s.charAt(j))){
                //Store it in Hashset: unique string so far.
                i = Math.max(found.get(s.charAt(j)),i);
            }

            max = Math.max(max,j-i+1);
            found.put(s.charAt(j),j+1);
        }
        System.out.println(max);
        return max;
    }
}
