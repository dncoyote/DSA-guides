# **Graphs**

## **Graph Representation**
```java
class Node {
    int val;
    List<Node> neighbors;

    Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class Graph {
    public static void main(String[] args) {
        Node node1 = new Node(11);
        Node node2 = new Node(22);
        Node node3 = new Node(33);
        Node node4 = new Node(44);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        printGraph(Arrays.asList(node1, node2, node3, node4));
    }

    static void printGraph(List<Node> graph) {
        for (Node node : graph) {
            System.out.print("Node " + node.val + " ->");
            for (Node neighbour : node.neighbors) {
                System.out.print(neighbour.val + " ");
            }
        }
        System.out.println();
    }

}
```
## **Number of Islands**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '1' },
                { '0', '0', '0', '1', '1' },
                { '0', '0', '0', '0', '0' },
                { '1', '0', '1', '0', '1' }
        };

        System.out.println("Number of islands: " + numberOfislands(grid));
    }

    private static int numberOfislands(char[][] grid) {
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Clone Graph**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(11);
        Node node2 = new Node(22);
        Node node3 = new Node(33);
        Node node4 = new Node(44);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        Node cloneGraph = cloneGraph(node1);
        System.out.println("Cloned graph node value: " + cloneGraph.val);
    }

    private static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited);
    }

    private static Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node))
            return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Pacific Atlantic Water Flow**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        List<List<Integer>> results = pacificAtlanticFlow(heights);
        System.out.println(results);
    }

    private static List<List<Integer>> pacificAtlanticFlow(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> results = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);// Pacific left border
            dfs(heights, i, cols - 1, atlantic, Integer.MIN_VALUE);// Atlantic right border
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);// Pacific top border
            dfs(heights, rows - 1, j, atlantic, Integer.MIN_VALUE);// Atlantic bottom border
        }

        // Collect cells that can reach both oceans
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (atlantic[row][col] && pacific[row][col]) {
                    results.add(Arrays.asList(row, col));
                }
            }
        }
        return results;
    }

    private static void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        // Stop if out of bounds, already visited, or can't flow
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col]
                || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
    }
}

/**
 * Output
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 * 
 * 
 * corresponding coordinates
 * [5, 4, 4, 5, 6, 7, 5]
 */
```
#### Explanation

-

#### Steps

-

#### Follow up 

-