package codinground.array;

public class FindMaxElement {
    public static void main(String args[]) {
        int arr[] = { 3, 7, 2, 9, 5 };
        int largest = 0;
        for (int i : arr) {
            if (i > largest) {
                largest = i;
            }
        }
        System.out.println(largest);
    }
}
