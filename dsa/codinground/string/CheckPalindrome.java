package codinground.string;

public class CheckPalindrome {
    public static void main(String args[]){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(palindromeCheckerOptimal(s));
    }

    private static boolean palindromeCheckerOptimal(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            while(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean palindromeCheckerBrute(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        String cleanString = sb.toString();
        String revString = sb.reverse().toString();

        return cleanString.equals(revString);
    }
}
