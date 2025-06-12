package arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
  public static void main(String[] args) {
    List<String> stringList = List.of("neet", "code", "love", "you");
    String encodeString = encodeStringBrute(stringList);
    System.out.println("Encoded String: " + encodeString);
    List<String> decodeString = decodeStringBrute(encodeString);
    System.out.println("Decoded String: " + decodeString);
  }

  private static String encodeStringBrute(List<String> stringList) {
    return String.join("#", stringList);
  }

  private static List<String> decodeStringBrute(String encodeString) {
    if (encodeString.isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.asList(encodeString.split("#"));
  }

  private static String encodeStringOptimal(List<String> stringList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : stringList) {
      stringBuilder.append(string.length()).append("#").append(string);
    }
    return stringBuilder.toString();
  }

  private static List<String> decodeStringOptimal(String encodeString) {
    List<String> decodeString = new ArrayList<>();
    int i = 0;
    while (i < encodeString.length()) {
      int j = encodeString.indexOf("#", i);
      int length = Integer.parseInt(encodeString.substring(i, j));
      decodeString.add(encodeString.substring(j + 1, j + 1 + length));
      i = j + 1 + length;
    }
    return decodeString;
  }

}
