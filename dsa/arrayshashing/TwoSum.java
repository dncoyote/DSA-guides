package arrayshashing;

import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    int[] arr = { 2, 1, 5, 3 };
    int target = 4;
    int[] result = twoSumBrute(arr, target);
    for (int n : result) {
      System.out.println(n);
    }
  }

  private static int[] twoSumBrute(int[] arr, int target) {
    for(int i=0;i<arr.length;i++){
      for(int j=1;j<arr.length;j++){
        int val  = arr[i]+arr[j];
        if(target==val)
        return new int[]{i,j};
      }
    }
    return new int[0];
  }

  private static int[] twoSumOptimal(int[] arr, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int val = 0;
    for (int i = 0; i < arr.length; i++) {
      val = target - arr[i];
      if (map.containsKey(val)) {
        return new int[] { map.get(val), i };
      }
      map.put(arr[i], i);
    }
    return new int[0];
  }
}
