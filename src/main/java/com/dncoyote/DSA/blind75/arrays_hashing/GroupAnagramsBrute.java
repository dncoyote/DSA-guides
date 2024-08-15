package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagramsBrute {
    public static void main(String[] args) {
        String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(val);
        for (List<String> s : result)
            System.out.println(s);
    }

    private static List<List<String>> groupAnagrams(String[] val) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < val.length; i++) {
            List<String> group = new ArrayList<>();
            group.add(val[i]);

            for (int j = i + 1; j < val.length; j++) {
                if (isAnagram(val[i], val[j])) {
                    group.add(val[j]);
                }
            }
            result.add(group);
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
