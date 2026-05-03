package codinground.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicates {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 2, 4, 1 };

        // Brute force solution is using nested for loops

        // optimal
        List<Integer> result = findDuplicates(arr);

        System.out.println(result);

    }

    private static List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
