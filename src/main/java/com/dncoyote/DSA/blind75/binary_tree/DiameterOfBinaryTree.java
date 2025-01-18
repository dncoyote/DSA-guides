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

public class DiameterOfBinaryTree {
    static int maxDiameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Binary Tree: " + diameterOfBinaryTreeOptimal(root));
    }

    private static int diameterOfBinaryTreeOptimal(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, rightHeight + leftHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static int diameterOfBinaryTreeBrute(TreeNode root) {
        int maxDiameter = 0;
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, rightHeight + leftHeight);

        diameterOfBinaryTreeBrute(root.left);
        diameterOfBinaryTreeBrute(root.right);

        return maxDiameter;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
