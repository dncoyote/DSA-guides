package binarytree;

public class KthSmallestElementInBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(11);
    root.left = new TreeNode(9);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(5);
    int k = 3;

    int result = kthSmallest(root, k);
    System.out.println(result);
  }

  private static int kthSmallest(TreeNode root, int k) {
    int count =  0 ;
    int result =  -1 ;

    inorder(root, count, result, k);

    return result;
  }

  private static void inorder(TreeNode root, int count, int result, int k) {
    if (root == null)
      return;
    inorder(root.left, count, result, k);
    count++;
    if (count == k) {
      result = root.val;
      return;
    }
    inorder(root.right, count, result, k);
  }
}
