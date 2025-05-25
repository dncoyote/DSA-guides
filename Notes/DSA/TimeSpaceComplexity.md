# **Time and Space Complexity**
## **Time Complexity**
- The rate at which the time taken increases with respect to the input size.
- This is not computed in time or seconds.
- Time complexity is a way to represent how the running time of an algorithm increases as the input size grows. It is expressed in terms of Big-O Notation.
> e.g., _O(1)_, _O(n)_, _O(n^2)_
- Algorithms with complexities like _O(n log n)_, _O(n)_, _O(log n)_ are generally considered efficient and practical for most problems.

#### Examples
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

```
> O(1)

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}

```
> O(n)

```java
for (int i = 0; i < n; i++) {         
    for (int j = 0; j < n; j++) {    
        System.out.println(i + j);
    }
}

```
> O(n^2)


## **Space Complexity**
- Memory space that the program takes.
- It is expressed in terms of Big-O Notation.
- It is the sum of the Auxiliary Space and Input Space
    - Auxiliary Space -  Space that take to solve the problem
    - Input Space -  Space that you take to store the input.

### Big-O Notation
> O( `time taken is denoted here` )
- Also known as Upper-bound complexity
> `Theta notation` - Average Bound Complexity
> `Omega notation` - Lower Bound Complexity

#### Rules of Time Complexity
- Time complexity is always calculated based on worst case scenario.
- Avoid constants.
- Avoid lower values.

#### Hierarchy of Time/Space Complexities
- O(1) - Constant Time
    - The runtime is independent of the input size.
    - Example: Array index access, hash table lookup (ideal case).
- O(log n) - Logarithmic Time
    - The runtime grows very slowly with input size.
    - Example: Binary search, balanced binary tree operations.
- O(n) - Linear Time
    - The runtime grows directly in proportion to the input size.
    - Example: Single traversal of an array, finding the maximum element in an array.
- O(n log n) - Linearithmic Time
    - The runtime is a mix of linear and logarithmic behaviour.
    - Example: Efficient sorting algorithms like Merge Sort, Heap Sort.
- O(n^2) - Quadratic Time
    - The runtime grows quadritically as input size increases.
    - Example: Nested loops, Bubble Sort, Selection Sort.
- O(2^n) - Exponential Time
    - The runtime doubles with each additional input element.
    - Example: Recursive solutions to problems like the Fibonacci sequence or the subset sum problem.
- O(n!) - Factorial Time
    - The runtime grows faster than exponential as input size increases.
    - Example: Permutation generation, brute-force solutions for combinatorial problems.