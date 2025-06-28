package binarytree;

public class LowestCommonAncestor {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    TreeNode result = lowestCommonAncestorOptimal(root, root.left, root.right);
    // printTree(result, 0);
    System.out.println("LCA- " + result.val);
  }

  private static TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;

    TreeNode left = lowestCommonAncestorOptimal(root.left, p, q);
    TreeNode right = lowestCommonAncestorOptimal(root.right, p, q);

    if (left != null && right != null)
      return root;

    return left != null ? left : right;
  }

  private static TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;

    if (covers(root.left, p) && covers(root.left, q)) {
      return lowestCommonAncestorBrute(root.left, p, q);
    }
    if (covers(root.right, p) && covers(root.right, q)) {
      return lowestCommonAncestorBrute(root.left, p, q);
    }
    return root;
  }

  private static boolean covers(TreeNode root, TreeNode node) {
    if (root == null)
      return false;
    if (root == node)
      return true;
    return covers(root.left, node) || covers(root.right, node);
  }
}
