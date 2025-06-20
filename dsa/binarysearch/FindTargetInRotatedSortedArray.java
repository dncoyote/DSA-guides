package binarysearch;

public class FindTargetInRotatedSortedArray {
  public static void main(String[] args) {
    int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
    int target = 1;
    System.out.println(findTargetInRotatedSortedArrayOptimal(arr, target));
  }

  private static int findTargetInRotatedSortedArrayOptimal(int[] arr, int target) {
    int low = 0;
    int high = arr.length-1;

    while(low<=high){
      int mid = (high+low)/2;
      if(arr[mid]==target){
        return mid;
      }if(arr[mid]>=arr[low]){
        if(target<=arr[mid]&&arr[low]<=target){
          high = mid -1;
        }else{
          low = mid+1;
        }
      }else{
        if(target>=arr[mid]&&arr[high]>=target){
          low = mid+1;
        }else{
          high = mid-1;
        }
      }
    }
    return -1;
  }

  private static int findTargetInRotatedSortedArrayBrute(int[] arr, int target) {
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        index = i;
      }
    }
    return index;
  }

}
