package arrayshashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  public static void main(String[] args) {
    int[] nums = { 5, 5, 5, 4, 4, 3 };
    int k = 2;
    int[] result = topKFrequentElementsOptimal(nums, k);
    for (int n : result) {
      System.out.println(n);
    }
  }

  private static int[] topKFrequentElementsOptimal(int[] nums, int k) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      minHeap.offer(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] result = new int[k];
    for(int i=0;i<k;i++){
      result[i] = minHeap.poll().getKey();
    }

    return result;
  }

  private static int[] topKFrequentElementsBrute(int[] nums, int k) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    List<Integer> list = new ArrayList<>(frequencyMap.keySet());

    Collections.sort(list, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}
