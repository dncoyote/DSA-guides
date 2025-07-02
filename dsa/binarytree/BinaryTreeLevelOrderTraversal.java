package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(binaryTreeLevelOrderTraversal(root));
  }

  private static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        currentLevel.add(current.val);

        if (null != current.left) {
          queue.add(current.left);
        }
        if (null != current.right) {
          queue.add(current.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
  }

}
