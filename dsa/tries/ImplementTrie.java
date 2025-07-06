package tries;

class TrieNode {
  TrieNode[] children;
  boolean isEndOfWord;

  TrieNode() {
    children = new TrieNode[26];
    isEndOfWord = false;
  }
}

class Trie {
  private final TrieNode root;

  Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
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
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }
    return node.isEndOfWord;
  }

  public boolean startsWith(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }
    return true;
  }
}

public class ImplementTrie {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.startsWith("ap"));
  }
}
