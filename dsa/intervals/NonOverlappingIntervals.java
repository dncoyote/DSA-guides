package intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

  public static void main(String[] args) {
    int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
    System.out.println("Minimum intervals to remove: " + nonOverlappingIntervals(intervals));
  }

  private static int nonOverlappingIntervals(int[][] intervals) {
    if (intervals.length == 0)
      return 0;

    // Sorting intervals based on end times
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

    int count = 0;
    int end = Integer.MIN_VALUE;

    for (int[] interval : intervals) {
      //compare the first value of the interval with the end value
      if (interval[0] >= end) {
        end = interval[1];
        count++;
      }
    }
    return intervals.length - count;
  }
}
