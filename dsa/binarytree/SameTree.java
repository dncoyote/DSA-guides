package binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.left.left = new TreeNode(3);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.left.left = new TreeNode(3);

    // TreeNode root2 = new TreeNode(1);
    // root2.right = new TreeNode(2);
    // root2.right.left = new TreeNode(3);

    System.out.println(sameTreeRecursiveBrute(root1, root2));

    // List<Integer> list1 = bfs(root1);
    // List<Integer> list2 = bfs(root2);

    // System.out.println(list1.equals(list2));

  }

  private static boolean sameTreeRecursiveBrute(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null)
      return true;
    if (root1 == null || root2 == null)
      return false;
    if (root1.val != root2.val)
      return false;
    return sameTreeRecursiveBrute(root1.left, root2.left) && sameTreeRecursiveBrute(root1.right, root2.right);
  }

  private static boolean sameTreeOptimal(TreeNode root1, TreeNode root2) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root1);
    queue.add(root2);

    while (!queue.isEmpty()) {
      TreeNode node1 = queue.poll();
      TreeNode node2 = queue.poll();

      if (node1 == null && node2 == null)
        continue;

      if (null == node1 || null == node2 || node1.val != node2.val)
        return false;

      queue.add(node1.left);
      queue.add(node2.left);
      queue.add(node1.right);
      queue.add(node2.right);
    }
    return true;
  }
}
