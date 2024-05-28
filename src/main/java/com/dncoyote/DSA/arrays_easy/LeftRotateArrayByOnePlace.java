package com.dncoyote.DSA.arrays_easy;

public class LeftRotateArrayByOnePlace {

    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5};
        int result[] = leftRotate(arr);

        System.out.println("After Rotation");
        for(int n: result){
            System.out.println(n);
        }
    }

    private static int[] leftRotate(int[] arr) {
        int temp = arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]= arr[i];
        }
        arr[arr.length-1]=temp;
        return arr;
    }
}
