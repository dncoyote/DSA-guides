package com.dncoyote.DSA.arrays_easy;

public class LeftRotateArrayByKPlacesOptimal {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 8;
        int result[] = leftRotateByK(arr, k);

        System.out.println("After Rotation");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] leftRotateByK(int[] arr, int k) {
        int n = arr.length;
        int temp[] = new int[k];
        k = k % n;

        // Create a temporary array to store the first K elements
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        // Shift the remaining elements of the original array to the left
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        // Copy the elements from the temporary array back to the original array
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
        return arr;
    }
}
