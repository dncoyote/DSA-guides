package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    bfs(root);
  }

  private static void bfs(TreeNode root) {
    if (root == null)
      return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      System.out.println(current.val + " ");

      if (null != current.left) {
        queue.add(current.left);
      }
      if (null != current.right) {
        queue.add(current.right);
      }
    }
  }
}
