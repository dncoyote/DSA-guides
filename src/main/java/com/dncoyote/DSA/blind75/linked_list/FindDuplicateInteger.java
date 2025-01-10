package com.dncoyote.DSA.blind75.linked_list;

public class FindDuplicateInteger {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicateIntegerOptimal1(nums));
    }

    private static int findDuplicateIntegerOptimal1(int[] nums) {
        int fast = 0, slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2)
                return slow;
        }
    }

    private static int findDuplicateIntegerOptimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Detect Cycle
        do {
            slow = nums[slow]; // Move slow pointer by 1 step
            fast = nums[nums[fast]]; // Move fast pointer by 2 steps
        } while (slow != fast);

        // Find duplicate
        slow = nums[0]; // Reset slow to the start
        while (slow != fast) {
            slow = nums[slow]; // Move both pointers one step
            fast = nums[fast];
        }
        return slow;
    }

    private static int findDuplicateIntegerBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
