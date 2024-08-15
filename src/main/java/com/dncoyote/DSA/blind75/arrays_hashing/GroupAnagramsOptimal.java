package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsOptimal {
    public static void main(String[] args) {
        String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(val);
        for (List<String> s : result)
            System.out.println(s);
    }

    private static List<List<String>> groupAnagrams(String[] val) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String s : val) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append("#");
                key.append(count[i]);
            }
            String keyString = key.toString();
            if (!result.containsKey(keyString)) {
                result.put(keyString, new ArrayList<>());
            }
            result.get(keyString).add(s);

        }
        return new ArrayList<>(result.values());
    }
}
