package com.dncoyote.DSA.arrays_medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        int target = 6;
        int[] result = twoSum(arr, target);
        // result.forEach(n->System.out.println(n));
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] twoSum(int[] arr, int target) {
       Map<Integer, Integer> mapVal = new HashMap<>();
       for(int i=0;i<arr.length; i++){
           int val = target-arr[i];
           if(mapVal.containsKey(val)){
               return new int[]{mapVal.get(val), i};
           }
           mapVal.put(arr[i],i);
       }
        return new int[0];
    }
}
