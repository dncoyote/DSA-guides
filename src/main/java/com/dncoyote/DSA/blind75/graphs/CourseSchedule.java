package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        // Example 1: Possible to finish all courses
        int numCourses1 = 4;
        int[][] prerequisites1 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        System.out.println(courseSchedule(numCourses1, prerequisites1)); // Output:
        // true

        // Example 2: Cycle exists
        int numCourses2 = 2;
        int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
        System.out.println(courseSchedule(numCourses2, prerequisites2)); // Output:
        // false
    }

    private static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        // Build adjacency list to represent the directed graph of prerequisites
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjacency.get(prereq).add(course);
        }

        // Use visited array to track state
        int[] visited = new int[numCourses];// 0 = unvisited, 1 = visiting, 2 = visited

        // check for cycle
        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) {// Start DFS only for unvisited nodes
                if (hasCycle(course, adjacency, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasCycle(int course, List<List<Integer>> adjacency, int[] visited) {
        if (visited[course] == 1) {
            // cycle exists as its in visiting state
            return true;
        }
        if (visited[course] == 2) {
            // course is fully processed, no need to check again
            return false;
        }

        // Mark course as visiting
        visited[course] = 1;

        // perform DFS on neighbors(prerequisites)
        for (int neighbor : adjacency.get(course)) {
            if (hasCycle(neighbor, adjacency, visited)) {
                return true; // Cycle detected in one of the neighbors
            }
        }

        // Mark course as visited
        visited[course] = 2;

        return false;
    }
}
