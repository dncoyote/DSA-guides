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

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(5);
        int k = 3;

        int result = kthSmallest(root, k);
        System.out.println(result);
    }

    private static int kthSmallest(TreeNode root, int k) {
        int[] count = { 0 };
        int[] result = { -1 };

        inOrder(root, count, result, k);

        return result[0];
    }

    private static void inOrder(TreeNode root, int[] count, int[] result, int k) {
        if (root == null)
            return;

        inOrder(root.left, count, result, k);
        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }
        inOrder(root.right, count, result, k);
    }

}
