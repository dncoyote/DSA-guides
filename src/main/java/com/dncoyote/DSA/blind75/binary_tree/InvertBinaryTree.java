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

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        printTree(root, 0);
        inorderTraversal(root);
        System.out.println("---");
        TreeNode invertedTree = invertBinaryTree(root);
        inorderTraversal(invertedTree);
        printTree(invertedTree, 0);
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val);
            inorderTraversal(root.right);
        }
    }

    private static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode result = new TreeNode(root.val);

        result.left = invertBinaryTree(root.right);
        result.right = invertBinaryTree(root.left);

        return result;
    }

    public static void printTree(TreeNode root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 5;

        // Print right child first
        printTree(root.right, space);

        // Print current node after space count
        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.val);

        // Print left child
        printTree(root.left, space);
    }

}
