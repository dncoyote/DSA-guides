package codinground.string;

import java.util.HashMap;

public class CountFreqOfChar {
    public static void main(String[] args) {
        String s = "aabbbc";
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        freqMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
