package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    // TreeNode.printTree(root, 0);

    String serializedString = serializeIterative(root);
    TreeNode deserializedTree = deserializeIterative(serializedString);
    TreeNode.printTree(deserializedTree, 0);

  }

  private static String serializeIterative(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (current == null) {
        sb.append("X,");
        continue;
      }
      sb.append(current.val).append(",");
      queue.add(current.left);
      queue.add(current.right);
    }
    return sb.toString();
  }

  private static TreeNode deserializeIterative(String serializedString) {
    if (serializedString.isEmpty())
      return null;

    String[] nodes = serializedString.split(",");
    Queue<TreeNode> queue = new LinkedList<>();

    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    queue.offer(root);

    int i = 1;
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();

      if (!nodes[i].equals("X")) {
        TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
        current.left = left;
        queue.offer(left);
      }
      i++;
      if (!nodes[i].equals("X")) {
        TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
        current.right = right;
        queue.offer(right);
      }
      i++;
    }
    return root;
  }
}
