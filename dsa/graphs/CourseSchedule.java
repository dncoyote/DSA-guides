package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  public static void main(String[] args) {
    // Example 1: Possible to finish all courses
    int numCourses1 = 4;
    int[][] prerequisites1 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
    System.out.println(courseScheduleBFS(numCourses1, prerequisites1)); // Output:
    // true

    // Example 2: Cycle exists
    int numCourses2 = 2;
    int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
    System.out.println(courseScheduleBFS(numCourses2, prerequisites2)); // Output:
    // false
  }

  private static boolean courseScheduleBFS(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjacencyGraph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjacencyGraph.add(new ArrayList<>());
    }

    int[] visited = new int[numCourses];
    for (int[] pair : prerequisites) {
      int course = pair[0];
      int prereq = pair[1];
      adjacencyGraph.get(prereq).add(course);
      visited[course]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0) {
        queue.add(i);
      }
    }

    int completedCourses = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      completedCourses++;

      for (int neighbor : adjacencyGraph.get(course)) {
        visited[neighbor]--;
        if (visited[neighbor] == 0) {
          queue.add(neighbor);
        }
      }
    }
    return completedCourses == numCourses;
  }
}
