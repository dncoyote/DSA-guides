package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args) {
    // int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] intervals = { { 1, 4 }, { 0, 4 } };
    int[][] result = merge(intervals);

    System.out.println("Merged intervals:");
    for (int[] interval : result) {
      System.out.println(Arrays.toString(interval));
    }
  }

  private static int[][] merge(int[][] intervals) {
    if (intervals.length == 0)
      return new int[0][];

    // Sort intervals by start time in ascending order
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();
    merged.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int[] last = merged.get(merged.size() - 1);
      int[] current = intervals[i];

      if (current[0] <= last[1]) {
        // overlap detected, merge the intervals 
        last[1] = Math.max(last[1], current[1]);
      } else {
        // no overlap, add the current interval to the merged list
        merged.add(current);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
