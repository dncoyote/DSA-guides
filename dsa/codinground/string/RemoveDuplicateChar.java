package codinground.string;

import java.util.LinkedHashSet;

public class RemoveDuplicateChar {
    public static void main(String arg[]) {
        String s = "programming";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

}
