# **Cheatsheet**
## Arrays and Hashing

| Problem      | Brute      | Time Complexity      | Space Complexity | Optimal      | Time Complexity      | Space Complexity|
| :---  | :----  |:---:           | :---:|:---|:---:|:---:|
| [Contains Duplicate](/dsa/arrayshashing/ContainsDuplicate.java)|  Use nested for loops to identify if a number from first loop exists in the second loop.| O(n<sup>2</sup>) |O(1)|Use HashSet to identify duplicates |O(n)|O(n)|
| [Valid Anagram](/dsa/arrayshashing/ValidAnagram.java)| Convert String to char arrays&rarr;Sort char arrays&rarr;Compare the char arrays. | O(n log n) |O(n)|Create a char count array&rarr;Increment the count for each char in first String by 1&rarr;Decrement the count for each char in second String by 1&rarr;If the char count for each char remains zero, then both String are equal&rarr;If the char count for any char is not ero, then both String are not equal|O(n)|O(1)|
| [Two Sum](/dsa/arrayshashing/TwoSum.java)| Use nested for-loops to if two values from the array yield the target value | O(n<sup>2</sup>) |O(1)| Use HashMap that store element and index&rarr;Find indices that yield the target value |O(n)|O(n)|
| [Group Anagrams](/dsa/arrayshashing/GroupAnagrams.java)|  &rarr;| O(n<sup>2</sup> k log k) |O(nk)| |O(nk)|O(nk)|
| [Top K Frequent Elements](/dsa/arrayshashing/TopKFrequentElements.java)| Count Frequencies using frequencyMap&rarr;Create List of unique elements&rarr;Sort elements by frequency in descending order&rarr;Pick top k using loop | O(n + m log m) | O(n)| Similar as brute, but instead of List use a min-heap to sort the frequencyMap |O(n log k) |O(n) |


