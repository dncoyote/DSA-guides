package codinground.string;

public class ReverseString {
    public static void main (String args[]){
        String s = "hello";
        System.out.println(reverseStringTwoPointer(s));
    }

    private static String reverseStringTwoPointer(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--; 
        }
        return new String(charArray);
    }

    private static String reverseStringSimple(String s) {
        // simple
       return new StringBuilder(s).reverse().toString();
    }
    
}
