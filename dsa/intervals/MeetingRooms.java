package intervals;

import java.util.Arrays;

public class MeetingRooms {

  public static void main(String[] args) {
    int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
    int[][] intervals2 = { { 7, 10 }, { 2, 4 } };

    System.out.println("Can attend all meetings (1)? " + canAttendMeetings(intervals1)); // false
    System.out.println("Can attend all meetings (2)? " + canAttendMeetings(intervals2)); // true
  }

  private static boolean canAttendMeetings(int[][] intervals) {
    // Sort intervals by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Compare end of one meeting to start of next
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i - 1][1]) {
        return false;
      }
    }
    return true;
  }
}
