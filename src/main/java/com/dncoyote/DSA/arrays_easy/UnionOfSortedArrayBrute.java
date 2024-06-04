package com.dncoyote.DSA.arrays_easy;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfSortedArrayBrute {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

        int result[] = findUnion(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int[] findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : arr1) {
            hs.add(n);
        }
        for (int m : arr2) {
            hs.add(m);
        }
        for (int p : hs) {
            result.add(p);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
