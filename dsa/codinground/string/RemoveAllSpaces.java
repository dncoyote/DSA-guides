package codinground.string;

public class RemoveAllSpaces {
    public static void main(String args[]) {
        String s = "hello world java";
        s = s.replaceAll(" ", "");
        System.out.print(s);
    }
}
