package binarytree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(11);
    root.left = new TreeNode(9);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(5);

    System.out.println(validateBST(root));
    TreeNode.printTree(root, 0);
  }

  private static boolean validateBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorderTraversal(root, list);

    int prev = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) <= prev) {
        return false;
      }
      prev = list.get(i);
    }
    return true;
  }

  private static void inorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null)
      return;

    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);
  }

  public static boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private static boolean isValid(TreeNode node, long min, long max) {
    if (node == null)
      return true;
    if (node.val <= min || node.val >= max)
      return false;
    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
  }
}
