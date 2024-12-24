package com.dncoyote.DSA.blind75.stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperaturesOptimal(temperatures);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] dailyTemperaturesOptimal(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }
        return result;
    }

    private static int[] dailyTemperaturesBrute(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            for(int j=i+1; j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
