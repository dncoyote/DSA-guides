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

public class DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTree(root, 0);
        DFS obj = new DFS();
        System.out.println("Inorder");
        obj.inOrderTraversal(root);
        System.out.println("Preorder");
        obj.preOrderTraversal(root);
        System.out.println("Postorder");
        obj.postOrderTraversal(root);

    }

    void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
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
