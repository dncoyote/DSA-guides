package binarytree;

public class InvertBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(9);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    TreeNode.printTree(root, 0);
    System.out.println("---");
    TreeNode invertedTree = invertBinaryTreeOptimal(root);
    TreeNode.printTree(invertedTree, 0);
  }

  private static TreeNode invertBinaryTreeOptimal(TreeNode root) {
    if (root == null)
      return null;

    TreeNode result = new TreeNode(root.val);

    result.left = invertBinaryTreeOptimal(root.right);
    result.right = invertBinaryTreeOptimal(root.left);

    return result;
  }
}
