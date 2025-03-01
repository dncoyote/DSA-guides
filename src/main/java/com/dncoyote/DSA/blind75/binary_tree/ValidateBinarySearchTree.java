package com.dncoyote.DSA.blind75.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(5);

        System.out.println(validateBST(root));
        printTree(root, 0);

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

    private static boolean validateBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        boolean isBST = true;

        int prev = inOrderList.get(0);
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= prev) {
                return false;
            }
            prev = inOrderList.get(i);
        }
        return isBST;
    }

    private static void inOrder(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;
        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }
}
