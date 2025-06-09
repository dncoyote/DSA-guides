# **Arrays & Hashing**

## **Contains Duplicate**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 095447.png" />
</div>

#### Brute - Nested for loops
```java
public class ContainsDuplicateBrute {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
> [Time Complexity]  
> Highlights information that users should take into account, even when skimming.
> [Space Complexity]  
> Highlights information that users should take into account, even when skimming.


>Time Complexity - O(n^2)
- nested for loops
>Space Complexity - O(1)
- array is used
#### Explanation

- Use nested for loops to identify if a number from first loop exists in the second loop.

#### Better - Sorting
```java
public class ContainsDuplicateBetter {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
```
>Time Complexity - O(nlogn)

>Space Complexity - O(1)
#### Explanation

- Sort the array using inbuilt sort function and  compare if adjacent values are equal.

#### Optimal - HashSet
```java
public class ContainsDuplicateOptimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> newSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (newSet.contains(nums[i])) {
                return true;
            }
            newSet.add(nums[i]);
        }
        return false;
    }
}
```
>Time Complexity - O(n)
- due to loop

>Space Complexity - O(n)
- due to HashSet usage
#### Explanation

- Use a HashSet.

## **Two Sum**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 111837.png" />
</div>

#### Brute - 
```java
public class TwoSumBrute {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3 };
        int target = 4;
        int[] result = twoSumSolution(arr, target);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] twoSumSolution(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    return new int[] { arr[i], arr[j] };
                }
            }
        }
         return new int[0];
    }

}
```
>Time Complexity - O(n^2)
- due to nested for loops

>Space Complexity - O(1)
- no extra space used

#### Explanation
- Use two for loops to iterate through the given integer array.
- Find the sum of the value of the element from the first for loop and the second for loop.
- Compare the sum with the target.
- Return if true.
- Else iterate the loop.

#### Optimal - HashMap
```java
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3 };
        int target = 4;
        int[] result = twoSum(arr, target);
        for(int n: result){
            System.out.println(n);
        }
    }

    private static int[] twoSum(int[] arr, int target) {
       Map<Integer, Integer> mapVal = new HashMap<>();
       for(int i=0;i<arr.length; i++){
           int val = target-arr[i];
           if(mapVal.containsKey(val)){
               return new int[]{mapVal.get(val), i};
           }
           mapVal.put(arr[i],i);
       }
         return new int[0];
    }
}
```
>Time Complexity - O(n)
- Single traversal of loop

>Space Complexity - O(n)
- Space for HashMap

#### Explanation
- Use a for loop to iterate through the integer array.
- Find the difference between target value and the value from the array.
- Check if that difference exists in the Hashmap.
- If it does not exist then add the value from array as key and its position as value in the hashmap.
- If it exists return the   

## **Valid Anagram**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 104236.png" />
</div>

#### Brute - Ordering and Sorting
```java
public class ValidAnagramBrute {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = validAnagram(s, t);
        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not anagram");
        }
    }

    private static boolean validAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
```
>Time Complexity - O(nlogn)
- Sorting operation takes O(nlogn)

>Space Complexity - O(n)
- char array `a` and `b` are copies of input string taking O(n) 
#### Explanation

- Convert String to char arrays.
- Sort char arrays
- Compare the char arrays.

#### Optimal - 
```java
public class ValidAnagramOptimal {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = validAnagram(s, t);
        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not anagram");
        }
    }

    private static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```
>Time Complexity - O(n)
- Length check `(s.length() != t.length())` takes O(1)
- Char counting takes O(n)
- Count check takes O(1) as its 26 characters.
         
>Space Complexity - O(1)
- The count array is always of size 26 so its O(1), no other auxilliary space taken.

#### Explanation

- Create a char count array.
- Increment the count for each char in first String by 1.
- Decrement the count for each char in second String by 1.
- If the char count for each char remains zero, then both String are equal.
- If the char count for any char is not ero, then both String are not equal.

## **Group Anagrams**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 122024.png" />
</div>

#### Optimal - HashMap
```java
public class GroupAnagramsOptimal {
    public static void main(String[] args) {
        String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(val);
        for (List<String> s : result)
            System.out.println(s);
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```
>Time Complexity - O(m*n)
- Where `m` is number of strings and `n` is the length of the longest String.

>Space Complexity - O(m)
- Where `m` is number of strings added to the HashMap.

#### Explanation
- If we used a simple `map.put(key, value)` instead of `putIfAbsent()`, we would overwrite the value every time we encounter a key that already exists.

#### Steps
- Get a string from the String array.
- Create its character count array.
- Add the character count array as the key to the result map.
- Add the String to the result map against the key.
- Repeat for all Strings.
- Return the value of the result map.

#### Optimal - Sorting
```java
public class GroupAnagramsOptimal {
    public static void main(String[] args) {
        String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(val);
        for (List<String> s : result)
            System.out.println(s);
    }

    private static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String anagram = new String(ch);

            if (!map.containsKey(anagram)) {
                map.put(anagram, new ArrayList<>());
            }
            map.get(anagram).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
```
>Time Complexity - O(m*nlogn)
- Where `m` is number of strings and `n` is the length of the longest String.

>Space Complexity - O(m*n)

## **Top k elements in List**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 131930.png" />
</div>

#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class TopKElementsBrute {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        frequencyMap.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println(frequencyMap.entrySet());

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedList.get(i).getKey();
        }
        return result;
    }
}
```
#### Explanation

-

#### Optimal - Heap
```java
public class TopKElementsOptimal {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
```
>Time Complexity - O(nlogk)
- n is the length of the array
- k is the number of top frequent elements.

>Space Complexity - O(n+k)

#### Explanation
- `PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b)->a.getValue()-b.getValue())` creates a min-heap that orders the entries based on the values of the `Map.Entry<Integer, Integer> elements`
- A min-heap is a specialized binary tree-based data structure that satisfies the heap property. Specifically, for a min-heap, the value of each parent node is less than or equal to the values of its children, ensuring that the smallest element is always at the root of the tree. That is why we have added this `for (int i = k - 1; i >= 0; i--)`.

## **Longest Consecutive Sequence**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 102541.png" />
</div>

#### Brute  
```java
public class LongestConsecutiveSequenceBrute {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentStreak = 1;
            int currentNumber = nums[i];
            while (contains(nums, currentNumber + 1)) {
                currentNumber++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    private static boolean contains(int[] nums, int i) {
        for (int n : nums) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}
```
>Time Complexity - O(n^2)
- while loop and contains method

>Space Complexity - O(1)

#### Explanation

-

#### Optimal - HashSet
```java
public class LongestConsecutiveSequenceOptimal {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int longestStreak = 0;
        for (int n : numSet) {
            // Check if this is the start of a sequence
            if (!numSet.contains(n - 1)) {
                int currentStreak = 1;
                int currentNumber = n;
                // Check the next numbers in the sequence
                while (numSet.contains(currentNumber + 1)) {
                    currentStreak = currentStreak + 1;
                    currentNumber = currentNumber + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
```
>Time Complexity - O(n)
- For Loop and lookup in HashSet

>Space Complexity - O(n)
- HashSet

#### Explanation
- 

## **Product of Array except self**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 155609.png" />
</div>

#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class ProductofArrayExceptSelfBrute {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] productofArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}
```
#### Explanation

-

#### Optimal 
```java
public class ProductofArrayExceptSelfOptimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] productofArrayExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1; // Initializing prefix product to 1
        for (int i = 0; i < n; i++) {
            output[i] = prefix; // Set the current index to the prefix product
            prefix *= nums[i]; // Update prefix to include nums[i]
        }

        int suffix = 1; // Initializing suffix product to 1
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix; // Multiply the current value in output with suffix
            suffix *= nums[i]; // Update suffix to include nums[i]
        }

        return output;
    }
}
```
>Time Complexity - O(n)
- for loops

>Space Complexity - O(1)
- no extra space -  The result array is not counted as extra space

#### Explanation
- Find prefix sums first
    - set prefix to 1.
    - set result as prefix.
    - update prefix by multiplying to the number
    - iterate until end of loop
- Find suffix sums next - (by iterating from back)
    - set suffix to 1.
    - multiply result to suffix.
    - update suffix by multiplying to the number
    - iterate until beginning of loop

## **Encode Decode String**
> Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

#### Optimal
```java
public class EncodeDecodeStringOptimal {
    public static void main(String[] args) {
        List<String> stringList = List.of("neet", "code", "love", "you");
        String encodeString = encodeString(stringList);
        System.out.println("Encoded String: " + encodeString);
        List<String> decodeString = decodeString(encodeString);
        System.out.println("Decoded String: " + decodeString);
    }

    private static String encodeString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringList) {
            stringBuilder.append(string.length()).append("#").append(string);
        }
        return stringBuilder.toString();
    }

    private static List<String> decodeString(String encodedString) {
        List<String> decodedString = new ArrayList<>();

        int i = 0;
        while (i < encodedString.length()) {
            int j = encodedString.indexOf("#", i);
            System.out.println("j - " + j);
            int length = Integer.parseInt(encodedString.substring(i, j));
            System.out.println("length - " + length);
            decodedString.add(encodedString.substring(j + 1, j + 1 + length));
            System.out.println("decodedString - " + decodedString);
            i = j + 1 + length;
        }
        return decodedString;
    }
}
/**
 * O/P
 * Encoded String: 4#neet4#code4#love3#you
 * Decoded String: [neet, code, love, you]
 */
```
>Time Complexity - O(n)
- for encoding O(n)
- for decoding O(n)
>Space Complexity - O(1)


## **Valid Sudoku**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 110358.png" />
</div>

#### Optimal - HashSet

```java
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        boolean result = validSudoku(board);
        System.out.println(result);
    }

    private static boolean validSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                // Ignore empty cells
                if (num == '.')
                    continue;

                // Calculate box index
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Invalid if duplicate found
                if (rows[r].contains(num) || cols[r].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }
                rows[r].add(num);
                cols[r].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }
}
```
>Time Complexity - O(1)
- Eventhough there is multiple times and there is a nested for loop, traversing happens for only O(9*9) or O(81) which is O(1).

>Space Complexity - O(1)
#### Explanation

-
