package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] arr = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = threeSumOptimal(arr);

    System.out.println(result);
  }

  private static List<List<Integer>> threeSumOptimal(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if (sum == 0) {
          result.add(Arrays.asList(arr[i], arr[left], arr[right]));
          left++;
          right--;
          while (left < right && arr[left] == arr[left - 1]) {
            left++;
          }
          while (left < right && arr[right] == arr[right + 1]) {
            right--;
          }

        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;

  }

  private static List<List<Integer>> threeSumBrute(int[] arr) {
    HashSet<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int sum = arr[i] + arr[j] + arr[k];
          if (sum == 0) {
            List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
            Collections.sort(list);
            set.add(list);
          }
        }
      }
    }
    return new ArrayList<>(set);
  }
}
