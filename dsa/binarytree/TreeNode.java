package binarytree;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
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
