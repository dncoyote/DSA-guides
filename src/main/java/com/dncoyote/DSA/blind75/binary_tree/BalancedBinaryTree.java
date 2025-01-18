package com.dncoyote.DSA.blind75.binary_tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);

        System.out.println(isBalancedOptimal(root));
    }

    private static boolean isBalancedOptimal(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(rightHeight - leftHeight) > 1)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static boolean isBalancedBrute(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }

        return isBalancedBrute(root.left) && isBalancedBrute(root.right);
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
