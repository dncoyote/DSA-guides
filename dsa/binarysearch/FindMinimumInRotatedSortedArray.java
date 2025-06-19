package binarysearch;

public class FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    int[] arr = { 4, 5, 6, 7, 1, 2 };
    System.out.println(findMinimumInRotatedSortedArrayOptimal(arr));
  }

  private static int findMinimumInRotatedSortedArrayOptimal(int[] arr) {
    int low = 0;
    int high = arr.length-1;

    while(low<high){
      int mid = (high+low)/2;
      if(arr[mid]>arr[high]){
        low = mid+1;
      }else{
        high = mid;
      }
    }
    return arr[high];
  }

  private static int findMinimumInRotatedSortedArrayBrute(int[] arr) {
    int min = arr[0];
    for(int i = 0;i<arr.length;i++){
      if(arr[i]<min){
        min = arr[i];
      }
    }
    return min;
  }

}
