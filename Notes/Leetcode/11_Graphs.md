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

## **Course Schedule**
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

#### Better - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal - Topological Sort(Kahns Algorithm)

#### Optimal - Cycle Detection using DFS
>Time Complexity - 

>Space Complexity - 

```java
public class CourseSchedule {
    public static void main(String[] args) {
        // Example 1: Possible to finish all courses
        int numCourses1 = 4;
        int[][] prerequisites1 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        System.out.println(courseSchedule(numCourses1, prerequisites1)); // Output:
        // true

        // Example 2: Cycle exists
        int numCourses2 = 2;
        int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
        System.out.println(courseSchedule(numCourses2, prerequisites2)); // Output:
        // false
    }

    private static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        // Build adjacency list to represent the directed graph of prerequisites
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjacency.get(prereq).add(course);
        }

        // Use visited array to track state
        int[] visited = new int[numCourses];// 0 = unvisited, 1 = visiting, 2 = visited

        // check for cycle
        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) {// Start DFS only for unvisited nodes
                if (hasCycle(course, adjacency, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasCycle(int course, List<List<Integer>> adjacency, int[] visited) {
        if (visited[course] == 1) {
            // cycle exists as its in visiting state
            return true;
        }
        if (visited[course] == 2) {
            // course is fully processed, no need to check again
            return false;
        }

        // Mark course as visiting
        visited[course] = 1;

        // perform DFS on neighbors(prerequisites)
        for (int neighbor : adjacency.get(course)) {
            if (hasCycle(neighbor, adjacency, visited)) {
                return true; // Cycle detected in one of the neighbors
            }
        }

        // Mark course as visited
        visited[course] = 2;

        return false;
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Graph Valid Tree**
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

#### Better - 
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
public class GraphValidTree {
    public static void main(String[] args) {
        // Example 1: Valid Tree
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(validTree(n1, edges1)); // Output: true

        // Example 2: Not a Tree (Cycle)
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println(validTree(n2, edges2)); // Output: false

        // Example 3: Not a Tree (Disconnected)
        int n3 = 4;
        int[][] edges3 = { { 0, 1 }, { 2, 3 } };
        System.out.println(validTree(n3, edges3)); // Output: false
    }

    private static boolean validTree(int n, int[][] edges) {
        // Check edge count
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency graph
        List<List<Integer>> adjacencyGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyGraph.get(edge[0]).add(edge[1]);
            adjacencyGraph.get(edge[1]).add(edge[0]);
        }

        // Detect cycles
        boolean[] visited = new boolean[n];
        if (hasCycles(adjacencyGraph, 0, -1, visited)) {
            return false;
        }

        for(boolean isVisited:visited){
            if(!isVisited){
                return false;
            }
        }
        return true;

    }

    private static boolean hasCycles(List<List<Integer>> adjacencyGraph, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjacencyGraph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycles(adjacencyGraph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Number of Connected Components In An Undirected Graph**
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

#### Better - 
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
public class CountConnectedComponents {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countComponents(n1, edges1)); // Output: 2

        int n2 = 4;
        int[][] edges2 = { { 0, 1 }, { 2, 3 } };
        System.out.println(countComponents(n2, edges2)); // Output: 2

        int n3 = 6;
        int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 3, 4 }, { 4, 5 } };
        System.out.println(countComponents(n3, edges3)); // Output: 2

        int n4 = 3;
        int[][] edges4 = { { 0, 1 }, { 0, 2 } };
        System.out.println(countComponents(n4, edges4)); // Output: 1
    }

    private static int countComponents(int n, int[][] edges) {
        // Build the adjacency list
        List<List<Integer>> adjacencyGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyGraph.get(edge[0]).add(edge[1]);
            adjacencyGraph.get(edge[1]).add(edge[0]);
        }
        // Create visited array
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyGraph, visited);
                components++;
            }
        }
        return components;
    }

    private static void dfs(int node, List<List<Integer>> adjacencyGraph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyGraph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyGraph, visited);
            }
        }
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-