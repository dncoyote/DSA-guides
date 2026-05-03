package codinground.array;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String args[]) {
        int[] arr = { 0, 1, 1, 3, 12 };

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }

        System.out.println(Arrays.toString(arr));
    }

}
