package codinground.string;

public class ReverseWordsInString {
    public static void main(String args[]) {
        String s = "I love Java";
        System.out.println(reverseStringTwoPointer(s));
    }

    private static String reverseStringTwoPointer(String s) {
        String[] words = s.split(" ");

        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = "";
            temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);

    }
}
