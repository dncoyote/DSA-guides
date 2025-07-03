package binarytree;

public class BinaryTreeMaximumPathSum {

  private static int maxSum;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    // TreeNode root = new TreeNode(-10);
    // root.left = new TreeNode(9);
    // root.right = new TreeNode(20);
    // root.right.left = new TreeNode(15);
    // root.right.right = new TreeNode(7);

    // TreeNode root = new TreeNode(0);

    System.out.println(maxPathSum(root));
  }

  private static int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    maxGain(root);
    return maxSum;
  }

  private static int maxGain(TreeNode node) {
    if (node == null)
      return 0;

    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    int currentSum = node.val + leftGain + rightGain;

    maxSum = Math.max(maxSum, currentSum);

    int gain = node.val + Math.max(leftGain, rightGain);

    return gain;
  }
}
