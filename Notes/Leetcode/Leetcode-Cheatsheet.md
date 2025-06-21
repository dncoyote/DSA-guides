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
| [Find Minimum in Rotated Sorted Array](/dsa/binarysearch/FindMinimuInRotatedSortedArray.java) | |O(n) |O(1)| |O(log n)|O(1)|
| [Find Target in Rotated Sorted Array](/dsa/binarysearch/FindTargetInRotatedSortedArray.java) | |O(n) |O(1)| |O(log n)|O(1)|


## Linked List

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Reverse Linked List](/dsa/linkedlist/ReverseLinkedList.java) | | | | |O(n)|O(1)|
| [Merge Two Sorted Linked List](/dsa/linkedlist/MergeTwoSortedLinkedList.java) | | | | |O(n+m)|O(1)|



