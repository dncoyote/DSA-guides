package binarytree;

public class SubtreeOfAnotherTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(4);
    root1.right = new TreeNode(5);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(2);

    TreeNode root2 = new TreeNode(4);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(2);

    System.out.print(isSubtree(root1, root2));
  }

  private static boolean isSubtree(TreeNode root1, TreeNode root2) {
    String tree1 = traversal(root1);
    String tree2 = traversal(root2);
    // System.out.println(tree1);
    // System.out.println(tree2);
    return tree1.contains(tree2);
  }

  private static String traversal(TreeNode root) {
    if (root == null)
      return null;
    StringBuilder sb = new StringBuilder("-");
    sb.append(root.val);
    sb.append(traversal(root.left));
    sb.append(traversal(root.right));
    return sb.toString();
  }
}
