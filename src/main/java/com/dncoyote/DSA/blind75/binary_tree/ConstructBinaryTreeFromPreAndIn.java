package com.dncoyote.DSA.blind75.binary_tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreAndIn {
    int preOrderIndex;
    HashMap<Integer, Integer> inOrderMap;

    public static void main(String[] args) {
        // int[] preorder = { -1 };
        // int[] inorder = { -1 };

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        ConstructBinaryTreeFromPreAndIn obj = new ConstructBinaryTreeFromPreAndIn();

        TreeNode root = obj.buildTree(preorder, inorder);
        printInOrder(root);
        printTree(root, 0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inOrderMap.get(rootValue);

        root.left = construct(preorder, inorderStart, rootIndex - 1);
        root.right = construct(preorder, rootIndex + 1, inorderEnd);

        return root;
    }

    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + "-");
            printInOrder(root.right);
        }
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
