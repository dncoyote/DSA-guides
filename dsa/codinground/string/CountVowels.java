package codinground.string;

public class CountVowels {
    public static void main(String args[]) {
        String s = "programming";
        s = s.toLowerCase();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
