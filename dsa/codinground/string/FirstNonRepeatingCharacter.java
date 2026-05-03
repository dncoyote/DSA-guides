package codinground.string;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabbcdeff";
        System.out.print(firstNonRepeatingChar(s));

    }

    private static char firstNonRepeatingChar(String s) {
        char result = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (freqMap.get(c) == 1) {
                result = c;
            }
        }
        return result;
    }
}
