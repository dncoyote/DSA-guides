package tries;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
  TrieNode[] children;
  boolean isEndOfWord;

  TrieNode() {
    children = new TrieNode[26];
    isEndOfWord = false;
  }
}

class WordDictionary {
  TrieNode root;

  WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    return dfs(word, 0, root);
  }

  private boolean dfs(String word, int index, TrieNode node) {
    if (node == null) {
      return false;
    }
    if (index == word.length()) {
      return node.isEndOfWord;
    }
    char c = word.charAt(index);
    if (c == '.') {
      for (TrieNode child : node.children) {
        if (child != null && dfs(word, index + 1, child)) {
          return true;
        }
      }
      return false;
    } else {
      return dfs(word, index + 1, node.children[c - 'a']);
    }
  }
}

class WordDictionaryBrute {
  private List<String> words;

  public WordDictionaryBrute() {
    words = new ArrayList<>();
  }

  // Add word to list
  public void addWord(String word) {
    words.add(word);
  }

  // Search with '.' wildcard support
  public boolean search(String word) {
    for (String w : words) {
      if (matches(w, word)) {
        return true;
      }
    }
    return false;
  }

  // Helper method to check if stored word matches search word with '.' wildcard
  private boolean matches(String word, String pattern) {
    if (word.length() != pattern.length()) {
      return false;
    }
    for (int i = 0; i < word.length(); i++) {
      if (pattern.charAt(i) != '.' && word.charAt(i) != pattern.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}

public class AddAndSearchWord {
  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad"));
    System.out.println(wordDictionary.search("bad"));
    System.out.println(wordDictionary.search(".ad"));
    System.out.println(wordDictionary.search("b.."));
  }
}
