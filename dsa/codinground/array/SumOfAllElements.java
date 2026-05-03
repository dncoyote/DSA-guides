package codinground.array;

public class SumOfAllElements {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4 };
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.print(sum);
    }

}
