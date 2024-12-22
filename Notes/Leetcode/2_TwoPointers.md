# **Two Pointers**
## **Theory**
#### Constant Window

#### Longest sub-array/sub-string


## **Valid Palindrome**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 112512.png" />
</div>

#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class ValidPalindromeBrute {
    public static void main(String[] args) {
        String string = "Was it a car or a cat I saw?";
        System.out.println(validPalindrome(string));
    }

    private static boolean validPalindrome(String string) {
        String cleanString = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(cleanString);
        String reverseString = stringBuilder.reverse().toString();
        return cleanString.equals(reverseString);
    }
}
```
#### Explanation

-

#### Better - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Optimal -

```java
public class ValidPalindromeOptimal {
    public static void main(String[] args) {
        String string = "Was it a car or a cat I saw?";
        System.out.println(validPalindrome(string));
    }

    private static boolean validPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(string.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(string.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
>Time Complexity - O(n)
- n is length of String

>Space Complexity - O(1)

#### Explanation

-

## **Three Sum**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 123440.png" />
</div>

#### Brute - 
```java
public class ThreeSumBrute {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        return result;
    }
}
```
>Time Complexity - O(n^3)

>Space Complexity - O(1)
#### Explanation

-

#### Optimal 
```java
public class ThreeSumOptimal {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        //we need to leave room for two additional elements to form a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates

            //Set pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right + 1])
                        right--; // Skip duplicates
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```
>Time Complexity - O(n^2)
- Sorting - O(n log n)
- two pointer traversal O(n)
- Total - O(n^2)

>Space Complexity - O(1)


#### Explanation

-

## **Container with most water**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 131159.png" />
</div>

#### Brute - 
```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Optimal -
```java
public class ContainerWithMostWaterOptimal {
    public static void main(String[] args) {
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6 };
        int maxArea = containerWithMaxArea(heights);
        System.out.println(maxArea);
    }

    private static int containerWithMaxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left
            // We use Math.min to ensure that the water height is determined by the shorter line, water will overflow if we use longer line
            int area = Math.min(heights[left], heights[right])
                    * (width);

            maxArea = Math.max(maxArea, area);

            // Move the shorter pointer
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)

#### Explanation

-