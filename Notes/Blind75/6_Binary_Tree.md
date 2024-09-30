# **Binary Tree**
## **Binary Tree Implementation**
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
    }
}
```

## **Binary Tree Traversals**
### In-order Traversal
- Left, Root, Right (sorted order for BST).
```java
void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
```
### Pre-order Traversal
- Root, Left, Right (useful for cloning the tree).
```java
public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
```
### Post-order Traversal
- Left, Right, Root (useful for deleting nodes).
```java
public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
```
### Level-order Traversal
- Visits nodes level by level.
```java
```