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
## DFS
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
> Output: 4, 2, 5, 1, 6, 3, 7

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
> Output: 1, 2, 4, 5, 3, 6, 7

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
> Output: 4, 5, 2, 6, 7, 3, 1

## BFS
### Level-order Traversal
- Visits nodes level by level.
```java
public static void bfs(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (null != current.left) {
                queue.add(current.left);
            }
            if (null != current.right) {
                queue.add(current.right);
            }
        }
    }
```

## **Invert Binary Tree**
>

#### Better - 
>Time Complexity - 

>Space Complexity - 
```java
private static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode result = new TreeNode(root.val);

        result.left = invertBinaryTree(root.right);
        result.right = invertBinaryTree(root.left);
        return result;
    }
```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public TreeNode invertBinaryTreeOptimal(TreeNode root) {
    if (root == null) {
        return null;
    }
    // Swap left and right children
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively invert left and right subtrees
    invertBinaryTreeOptimal(root.left);
    invertBinaryTreeOptimal(root.right);
    return root;
}
```
#### Explanation

-

#### Steps

-