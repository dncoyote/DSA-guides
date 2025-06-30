package binarytree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreAndIn {

  HashMap<Integer, Integer> inOrderIndexMap;
  int preOrderIndex;

  public static void main(String[] args) {

    int[] preorder = { 3, 9, 20, 15, 7 };
    int[] inorder = { 9, 3, 15, 20, 7 };

    ConstructBinaryTreeFromPreAndIn obj = new ConstructBinaryTreeFromPreAndIn();

    TreeNode root = obj.buildTree(preorder, inorder);
    TreeNode.printTree(root, 0);
  }

  private TreeNode buildTree(int[] preorder, int[] inorder) {
    preOrderIndex = 0;
    inOrderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inOrderIndexMap.put(inorder[i], i);
    }
    return construct(preorder, 0, inorder.length - 1);
  }

  private TreeNode construct(int[] preorder, int inStart, int inEnd) {
    if (inStart > inEnd)
      return null;

    int rootVal = preorder[preOrderIndex];
    preOrderIndex++;
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = inOrderIndexMap.get(rootVal);

    root.left = construct(preorder, inStart, rootIndex - 1);
    root.right = construct(preorder, rootIndex + 1, inEnd);

    return root;
  }
}
