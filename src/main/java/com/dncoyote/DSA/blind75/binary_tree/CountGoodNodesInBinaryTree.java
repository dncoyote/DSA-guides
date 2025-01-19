package com.dncoyote.DSA.blind75.binary_tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }

    private static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode root, int max) {
        if (root == null)
            return 0;

        int count = 0;
        if (root.val >= max) {
            count = 1;
        }

        max = Math.max(max, root.val);

        count += dfs(root.left, max);
        count += dfs(root.right, max);

        return count;
    }
}
