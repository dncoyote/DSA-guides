package codinground.string;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatingWords {
    public static void main(String args[]) {
        String s = "Java is great and Java is powerful and Java is fast";

        HashMap<String, Integer> freqMap = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

}
