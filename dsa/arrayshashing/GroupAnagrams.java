package arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
    List<List<String>> result = groupAnagramsBrute(val);
    for (List<String> s : result)
      System.out.println(s);
  }

  private static List<List<String>> groupAnagramsBrute(String[] val) {
    List<List<String>>groups = new ArrayList<>();

    for(String str:val){
      boolean foundGroup = false;
      for(List<String>group:groups){
        if(isAnagram(str, group.get(0))){
          foundGroup=true;
          group.add(str);
          break;
        }
      }
      if(!foundGroup){
        List<String>newGroup = new ArrayList<>();
        newGroup.add(str);
        groups.add(newGroup);
      }
    }
  return groups;
  }

  private static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;

    char[] a = str1.toCharArray();
    char[] b = str2.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);

    return Arrays.equals(a, b);
  }

  private static List<List<String>> groupAnagramsOptimal(String[] val) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (String str : val) {
      int[] count = new int[26];
      for (int i = 0; i < str.length(); i++) {
        count[str.charAt(i) - 'a']++;
      }
      String key = Arrays.toString(count);
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(str);
    }
    return new ArrayList<>(map.values());
  }

}
