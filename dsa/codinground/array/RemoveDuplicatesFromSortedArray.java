package codinground.array;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]) {
        int[] num = { 1, 2, 2, 3, 4, 4, 5 };

        // Stream API
        int[] uniqueNum = Arrays.stream(num).distinct().toArray();
        System.out.println("Stream API " + Arrays.toString(uniqueNum));

        // Linked Hash Set
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int n : num) {
            set.add(n);
        }
        Integer[] uniqueNums = set.toArray(new Integer[0]);
        System.out.println("Linked hash set " + Arrays.toString(uniqueNums));

        System.out.println("Two Pointer ");
        int length = removeDuplicateFromSortedArray(num);
        for (int i = 0; i < length; i++) {
            System.out.print(num[i]);
        }

    }

    private static int removeDuplicateFromSortedArray(int[] num) {
        int i = 0;
        for (int j = 1; j < num.length; j++) {
            if (num[j] != num[i]) {
                i++;
                num[i] = num[j];
            }
        }
        return i + 1;
    }
}
