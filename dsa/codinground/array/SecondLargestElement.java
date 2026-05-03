package codinground.array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestElement {
    public static void main(String args[]) {
        int[] arr = { 10, 20, 4, 45, 99 };

        // Stream API
        int val = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
                .orElse(-1);
        System.out.println("Stream API " + val);

        int result = secondLargestElement(arr);
        System.out.print("Comparison :" + result);
    }

    private static int secondLargestElement(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
