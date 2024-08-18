package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStringOptimal {
    public static void main(String[] args) {
        List<String> stringList = List.of("neet", "code", "love", "you");
        String encodeString = encodeString(stringList);
        System.out.println("Encoded String: " + encodeString);
        List<String> decodeString = decodeString(encodeString);
        System.out.println("Decoded String: " + decodeString);
    }

    private static String encodeString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringList) {
            stringBuilder.append(string.length()).append("#").append(string);
        }
        return stringBuilder.toString();
    }

    private static List<String> decodeString(String encodedString) {
        List<String> decodedString = new ArrayList<>();

        int i = 0;
        while (i < encodedString.length()) {
            int j = encodedString.indexOf("#", i);
            System.out.println("j - " + j);
            int length = Integer.parseInt(encodedString.substring(i, j));
            System.out.println("length - " + length);
            decodedString.add(encodedString.substring(j + 1, j + 1 + length));
            System.out.println("decodedString - " + decodedString);
            i = j + 1 + length;
        }
        return decodedString;
    }
}
/**
 * O/P
 * Encoded String: 4#neet4#code4#love3#you
 * Decoded String: [neet, code, love, you]
 */