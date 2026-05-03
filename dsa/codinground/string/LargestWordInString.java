package codinground.string;

public class LargestWordInString {
    public static void main(String args[]) {
        String s = "Java is powerful and widely used";
        String largest = "";

        String[] words = s.split(" ");

        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }
        System.out.println(largest);
    }

}
