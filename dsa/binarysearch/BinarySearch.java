package binarysearch;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
    int target = 17;
    System.out.println(binarySearch(arr, target));
  }

  private static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (target == arr[mid]) {
        return mid;
      } else if (target > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

}
