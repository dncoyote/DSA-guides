# **Two Pointers**
## **Theory**
#### Constant Window

#### Longest sub-array/sub-string


## **Valid Palindrome**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 112512.png" />
</div>

#### Brute - 
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
>Time Complexity - O(n)

>Space Complexity - O(n)
- Additional space for filtered string and reversed string.

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

public class ThreeSum {
  public static void main(String[] args) {
    int[] arr = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = threeSumOptimal(arr);

    System.out.println(result);
  }

  private static List<List<Integer>> threeSumBrute(int[] arr) {
    HashSet<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int sum = arr[i] + arr[j] + arr[k];
          if (sum == 0) {
            List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
            Collections.sort(list);
            set.add(list);
          }
        }
      }
    }
    return new ArrayList<>(set);
  }
}
```
>Time Complexity - O(n<sup>3</sup>)

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
>Time Complexity - O(n<sup>2</sup>)
- Sorting - O(n log n)
- two pointer traversal O(n)
- Total - O(n<sup>2</sup>)

>Space Complexity - O(1)


#### Explanation

-

## **Container with most water**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 131159.png" />
</div>

#### Brute - 
```java
public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int maxArea = containerWithMaxAreaOptimal(heights);
    System.out.println(maxArea);
  }

  private static int containerWithMaxAreaBrute(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      for (int j = i + 1; j < heights.length; j++) {
        // width
        int w = j - i;
        // heights
        int h = Math.min(heights[i], heights[j]);
        int area = w * h;
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }
}
```
>Time Complexity - O(n<sup>2</sup>) 

>Space Complexity - O(1)
- Constant space is used
#### Explanation

-

#### Optimal -
```java

public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int maxArea = containerWithMaxAreaOptimal(heights);
    System.out.println(maxArea);
  }

  private static int containerWithMaxAreaOptimal(int[] heights) {
    int maxArea = 0;
    int left = 0;
    int right = heights.length - 1;
    while (left < right) {
      // width
      int w = right - left;
      // height
      int h = Math.min(heights[left], heights[right]);
      int area = w * h;
      maxArea = Math.max(maxArea, area);

      if (heights[left] < heights[right])
        left++;
      else
        right--;
    }
    return maxArea;
  }
}

```
>Time Complexity - O(n)

>Space Complexity - O(1)

#### Explanation

-

## **Two Sum II - Input array is sorted**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 152356.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSumII(nums, target);
        for (int n : res)
            System.out.println(n);
    }

    private static int[] twoSumII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            // sum is less than the target val, move pointer to the right increasing value
            if (sum < target) {
                left++;
                // sum is greater than the target val, move pointer to left decreasing value
            } else if (sum > target) {
                right--;
                // sum is equal to target
            } else {
                // Convert to 1-indexed, to return the correct index
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[0];
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)

## **Trapping Rain Water**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-22 155240.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class TrappingRainWater {
    public static void main(String[] args) {
        int heights[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = trap(heights);
        System.out.println(result);
    }

    private static int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int leftMax = heights[left];
        int rightMax = heights[right];

        int waterTrapped = 0;

        while (left < right) {
            // to determine which side of the array (left or right) to process next, if left is smaller then process left, else process right
            if (leftMax < rightMax) {
                left++;
                // Update the left maximum
                leftMax = Math.max(leftMax, heights[left]);

                waterTrapped += leftMax - heights[left];
            } else {
                right--;
                // Update the right maximum
                rightMax = Math.max(rightMax, heights[right]);

                waterTrapped += rightMax - heights[right];
            }
        }
        return waterTrapped;
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)

#### Explanation

- `if (leftMax < rightMax)` - If leftMax is smaller than rightMax, the amount of water trapped at the current position depends only on leftMax, since rightMax is taller and will not limit the water at this position.
