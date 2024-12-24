package com.dncoyote.DSA.blind75.stack;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        int target = 12;
        System.out.println(carFleet(target, position, speed));
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length];

        // Calculate the time for each car to reach the destination
        for (int i = 0; i < position.length; i++) {
            time[i] = (double) (target - position[i]) / speed[i];
        }

        // Sort the cars based on their positions in decreasing order
        Integer[] indices = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double lastTime = 0;
        // Process cars in order of their positions (from farthest to closest)
        for (int i : indices) {
            if (time[i] > lastTime) {
                fleets++;
                lastTime = time[i];
            }
        }
        return fleets;
    }

}
