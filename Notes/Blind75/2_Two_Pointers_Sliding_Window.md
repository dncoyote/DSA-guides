# **Two Pointers & Sliding Window**
## **Theory**
#### Constant Window

#### Longest sub-array/sub-string


## **Valid Palindrome**
> Given a string `s`, return `true` if it is a palindrome, otherwise return `false`.
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
>Time Complexity - 

>Space Complexity - 

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
#### Explanation

-

## **Three Sum**
> Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` where `nums[i] + nums[j] + nums[k] == 0`, and the indices `i`, `j` and `k` are all distinct.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
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
#### Explanation

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
        System.out.println(nums.length - 2);
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
#### Explanation

-