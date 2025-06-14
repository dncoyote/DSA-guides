package arrayshashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] nums = { 100, 4, 200, 1, 3, 2 };
    int result = longestConsecutiveSequenceOptimal(nums);
    System.out.println(result);
  }

  private static int longestConsecutiveSequenceOptimal(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int n : nums) {
      numSet.add(n);
    }
    int longestStreak = 0;
    for (int n : nums) {
      int currentStreak;
      int currentNumber;
      if (!numSet.contains(n - 1)) {
        currentStreak = 1;
        currentNumber = n;
        while (numSet.contains(currentNumber + 1)) {
          currentStreak++;
          currentNumber++;
        }
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }
    return longestStreak;
  }

  private static int longestConsecutiveSequenceBrute(int[] nums) {
    int longestStreak = 0;
    HashSet<Integer> set = new HashSet<>();
    for (Integer num : nums) {
      set.add(num);
    }
    for (Integer num : nums) {
      int currentStreak = 1;
      int currentNum = num;
      while (set.contains(currentNum + 1)) {
        currentStreak++;
        currentNum++;
      }
      longestStreak = Math.max(longestStreak, currentStreak);
    }
    return longestStreak;
  }

}
