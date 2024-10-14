package com.dncoyote.DSA.blind75.binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Counter {
    int count = 0;
    int result = -1;
}

public class KthLargestElementinBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(5);
        int k = 3;

        int result = kthLargest(root, k);
        System.out.println(result);
    }

    private static int kthLargest(TreeNode root, int k) {
        Counter counter = new Counter();
        reverseInOrder(root, k, counter);
        return counter.result;
    }

    private static void reverseInOrder(TreeNode root, int k, Counter counter) {
        if (root == null) {
            return;
        }

        // Traverse right subtree first
        reverseInOrder(root.right, k, counter);

        // Increment the count and check if we found the k-th largest element
        counter.count++;
        if (counter.count == k) {
            counter.result = root.val;
            return;
        }

        // Traverse left subtree
        reverseInOrder(root.left, k, counter);
    }
}
