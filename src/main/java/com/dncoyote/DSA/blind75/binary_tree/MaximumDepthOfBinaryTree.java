package com.dncoyote.DSA.blind75.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);

        int depth = maximumDepthOfBinaryTreeOptimal(root);
        System.out.println(depth);
    }

    static int maximumDepthOfBinaryTreeOptimal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numberOfLevels = 0;

        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0)
                return numberOfLevels;

            while (nodeCount > 0) {
                TreeNode current = queue.poll();
                if (null != current.left)
                    queue.add(current.left);
                if (null != current.right)
                    queue.add(current.right);
                nodeCount--;
            }
            numberOfLevels++;
        }
    }

    private static List<Integer> maximumDepthOfBinaryTreeBrute(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                list.add(null);
            } else {
                list.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return list;

    }
}
