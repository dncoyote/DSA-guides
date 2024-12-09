package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.List;

public class Test {
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
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            adj.get(prereq).add(course);
        }

        int[] visited = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) {
                if (hasCycle(course, adj, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasCycle(int course, List<List<Integer>> adj, int[] visited) {

        if (visited[course] == 1) {
            return true;
        }
        if (visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        for (int prereq : adj.get(course)) {
            if (hasCycle(prereq, adj, visited)) {
                return true;
            }
        }

        visited[course] = 2;
        return false;
    }
}
