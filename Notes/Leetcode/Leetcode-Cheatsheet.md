# **Cheatsheet**
## Arrays and Hashing

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Contains Duplicate](/dsa/arrayshashing/ContainsDuplicate.java)|  Use nested for loops to identify if a number from first loop exists in the second loop.| O(n<sup>2</sup>) |O(1)|Use HashSet to identify duplicates |O(n)|O(n)|
| [Valid Anagram](/dsa/arrayshashing/ValidAnagram.java)| Convert String to char arrays&rarr;Sort char arrays&rarr;Compare the char arrays. | O(n log n) |O(n)|Create a char count array&rarr;Increment the count for each char in first String by 1&rarr;Decrement the count for each char in second String by 1&rarr;If the char count for each char remains zero, then both String are equal&rarr;If the char count for any char is not ero, then both String are not equal|O(n)|O(1)|
| [Two Sum](/dsa/arrayshashing/TwoSum.java)| Use nested for-loops to if two values from the array yield the target value | O(n<sup>2</sup>) |O(1)| Use HashMap that store element and index&rarr;Find indices that yield the target value |O(n)|O(n)|
| [Group Anagrams](/dsa/arrayshashing/GroupAnagrams.java)|  &rarr;| O(n<sup>2</sup> k log k) |O(nk)|Create a HashMap that store char[26] count String as key and `List<String>` of that count as value&rarr;Return the values |O(nk)|O(nk)|
| [Top K Frequent Elements](/dsa/arrayshashing/TopKFrequentElements.java)| Count Frequencies using frequencyMap&rarr;Create List of unique elements&rarr;Sort elements by frequency in descending order&rarr;Pick top k using loop | O(n + m log m) | O(n)| Similar as brute, but instead of List use a min-heap to sort the frequencyMap |O(n log k) |O(n) |
| [Encode And Decode Strings](/dsa/arrayshashing/EncodeAndDecodeStrings.java)| | O(L) | O(L)| For each string, prepend its length and a delimiter (e.g., #) before the string. `"hello" → "5#hello"`&rarr;Concatenate all encoded strings&rarr;When decoding, read the length, then read that many characters for the string, repeat(find i, j, length)| O(L) |O(L) |
| [Product Of Array Except Self](/dsa/arrayshashing/ProductOfArrayExceptSelf.java)| | O(n<sup>2</sup>) | O(n)| | O(n) |O(1) |
| [Longest Consecutive Sequence](/dsa/arrayshashing/LongestConsecutiveSequence.java)| Add all values to set&rarr;Inside for-loop set current streak and current number&rarr;Inside while-loop check whether set contains the current num+1&rarr;Increment current streak and current number&rarr;Find max streak | O(n<sup>2</sup>) | O(n)|Similar to brute&rarr;Add `if(!set.contains(n-1))`condition inside for-loop first before while-loop | O(n) |O(n) |


## Two Pointers

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Valid Palindrome](/dsa/twopointers/ValidPalindrome.java)|Filter String for special characters and spaces&rarr;Reverse the filtered String&rarr;Compare both Strings | O(n) |O(n)| |O(n)|O(1)|
| [Three Sum](/dsa/twopointers/ThreeSum.java)| | O(n<sup>3</sup>) |O(1)| |O(n<sup>2</sup>)|O(1)|
| [Container With Most Water](/dsa/twopointers/ContainerWithMostWater.java)| | O(n<sup>2</sup>) |O(1)| |O(n)|O(1)|

## Sliding Window

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Buy And Sell Crypto](/dsa/slidingwindow/BuyAndSellCrypto.java) | |O(n<sup>2</sup>) |O(1)| |O(n)|O(1)|
| [Longest Substring Without Repeating Characters](/dsa/slidingwindow/LongestSubstringWithoutRepeatingCharacters.java) | |O(n<sup>3</sup>) |O(min(m, n) or O(k))| |O(n)|O(min(m, n)) or O(k) or O(1)|


## Stack

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Valid Parentheses](/dsa/stack/ValidParentheses.java) | |O(n<sup>2</sup>) |O(n)| |O(n)|O(n)|


## Binary Search

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Find Minimum in Rotated Sorted Array](/dsa/binarysearch/FindMinimumInRotatedSortedArray.java) | |O(n) |O(1)| |O(log n)|O(1)|
| [Find Target in Rotated Sorted Array](/dsa/binarysearch/FindTargetInRotatedSortedArray.java) | |O(n) |O(1)| |O(log n)|O(1)|


## Linked List

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Reverse Linked List](/dsa/linkedlist/ReverseLinkedList.java) | | | | |O(n)|O(1)|
| [Merge Two Sorted Linked List](/dsa/linkedlist/MergeTwoSortedLinkedList.java) | | | | |O(n+m)|O(1)|
| [Reorder Linked List](/dsa/linkedlist/ReorderList.java) | | | | |O(n)|O(1)|
| [Remove nth Node From End of List](/dsa/linkedlist/RemoveNthNodeFromEndOfLinkedList.java) | | | | |O(n)|O(1)|
| [Linked List Cycle](/dsa/linkedlist/LinkedListCycle.java) | Use HashSet | O(n) | O(n) | Floyds Cycle Detection |O(n)|O(1)|
| [Merge K Sorted Lists](/dsa/linkedlist/MergeKSortedLists.java) | Add all val from ListNodes to a list&rarr;sort the list&rarr;Add the values from the list to ListNode until empty. | O(n log n) | O(n) | Create a minHeap&rarr;Add first node of all ListNodes to minHeap&rarr;Poll the smallest value from minHeap and add to a ListNode using while loop&rarr;Check if smallest value has next value, if yes then add to the minHeap&rarr;Repeat process until minHeap is empty |O(n log k)|O(k)|


## Binary Tree

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Invert Binary Tree](/dsa/binarytree/InvertBinaryTree.java) | | | | |O(n)|O(1)|
| [Maximum Depth Of Binary Tree](/dsa/binarytree/MaximumDepthOfBinaryTree.java) | | | | |O(n+m)|O(1)|
| [Same Tree](/dsa/binarytree/SameTree.java) | | | | |O(n)|O(1)|
| [Subtree of Another Tree](/dsa/binarytree/SubtreeOfAnotherTree.java) | | | | |O(n)|O(1)|
| [Lowest Common Ancestor](/dsa/binarytree/LowestCommonAncestor.java) |  | O(n) | O(n) | |O(n)|O(1)|
| [Validate Binary Search Tree](/dsa/binarytree/ValidateBinarySearchTree.java) |  |  |  |  | | |
| [Kth Smallest/Largest Element in BST](/dsa/binarytree/KthSmallestElementInBST.java) |  |  |  |  | | |
| [Construct Binary Tree from Inorder and Preorder Traversal](/dsa/binarytree/ConstructBinaryTreeFromPreAndIn.java) |  |  |  |  | | |
| [Serialize and Deserialize Binary Tree](/dsa/binarytree/SerializeAndDeserializeBinaryTree.java) | O(n) | O(n) |  |  | | |
| [Binary Tree Level Order Traversal](/dsa/binarytree/BinaryTreeLevelOrderTraversal.java) |  |  |  |  |O(n) |O(n) |
| [Binary Tree Maximum Path Sum](/dsa/binarytree/BinaryTreeMaximumPathSum.java) |  |  |  |  |O(n) |O(h) |


## Priority Queue and Heaps

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Find Median From Data Stream](/dsa/priorityqueueheaps/FindMedianFromDataStream.java) | | O(n log n)|  O(n) | |O(log n)|O(1)|


## Backtracking

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Combination Sum](/dsa/backtracking/CombinationSum.java) | | O(n<sup>3</sup>)|   O(n<sup>3</sup>)| |O(n<sup>target/m</sup>)|O(target/m)|
| [Word Search](/dsa/backtracking/WordSearch.java) | | | | |O(m x n x 4<sup>L</sup>)|O(L)|


## Tries

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Implement Trie Prefix Tree](/dsa/tries/ImplementTrie.java) | | | | | | |
| [Add and Search Words](/dsa/tries/AddAndSearchWord.java) | | | | | | |
| [Word Search II](/dsa/tries/WordSearchII.java) | | | | | | |


## Graphs

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Number of Islands](/dsa/graphs/NumberOfIslands.java) | | | | |O(m x n) |O(m x n) |
| [Clone Graph](/dsa/graphs/CloneGraph.java)  | | | | | O(V + E) | O(V) |
| [Pacific Atlantic Water Flow](/dsa/graphs/PacificAtlanticWaterFlow.java)  | | | | | O(m x n) | O(m x n) |
| [Course Schedule](/dsa/graphs/CourseSchedule.java)  | | | | | O(V + E) | O(V + E) |
| [Graph Valid Tree](/dsa/graphs/GraphValidTree.java)  | | | | | O(V + E) | O(V + E) |
| [Number of Connected Components in an Undirected Graph](/dsa/graphs/CountConnectedComponents.java)  | | | | | O(V + E) | O(V + E) |


## 1D Dynamic Programming 

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Climbing Stairs](/dsa/dynamicprogramming1D/ClimbingStairs.java) | |O(2<sup>n</sup>) |O(n) | |O(n) |O(1) |
| [House Robber](/dsa/dynamicprogramming1D/HouseRobber.java) | |O(2<sup>n</sup>) |O(n) | |O(n) |O(n) |
| [House Robber II](/dsa/dynamicprogramming1D/HouseRobberII.java) | |O(2<sup>n</sup>) |O(n) | |O(n) |O(n) |
| [Longest Palindromic Substring](/dsa/dynamicprogramming1D/LongestPalindromicSubtring.java) | |O(n<sup>3</sup>) |1 | |O(n<sup>2</sup>) |O(n<sup>2</sup>) |
| [Palindromic Substring](/dsa/dynamicprogramming1D/PalindromicSubtrings.java) | |O(n<sup>3</sup>) |1 | |O(n<sup>2</sup>) |O(n<sup>2</sup>) |
| [Decode Ways](/dsa/dynamicprogramming1D/DecodeWays.java) | |O(2<sup>n</sup>) |O(n) | |O(n) |O(n) |
| [Coin Change](/dsa/dynamicprogramming1D/CoinChange.java) | |O(S<sup>n</sup>) |O(S) | |O(n x amount) |O(amount) |
| [Maximum Product Subarray](/dsa/dynamicprogramming1D/MaximumProductSubarray.java) | |O(n<sup>2</sup>) |O(1) | |O(n) |O(1) |
| [Word Break](/dsa/dynamicprogramming1D/WordBreak.java) | |O(2<sup>n</sup>) |O(n) | |O(n<sup>2</sup> x k) |O(n) |
| [Longest Increasing Subsequence](/dsa/dynamicprogramming1D/LongestIncreasingSubsequence.java) | | | | |O(n<sup>2</sup> x k) |O(n) |


## 2D Dynamic Programming 

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Unique Paths](/dsa/dynamicprogramming2D/UniquePaths.java) | |O(2<sup>m+n</sup>) |O(m+n) | |O(m x n) |O(m x n) |
