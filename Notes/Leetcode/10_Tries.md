# **Tries**
- They are also known as _Prefix Trees_.

## **Implement Trie**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-17 221939.png" />
</div>

#### Brute -
```java
class TrieBrute {
    List<String> words;

    public TrieBrute() {
        words = new ArrayList<>();
    }

    public void insert(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String w : words) {
            if (w.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
```

>Time Complexity - 
- insert - `O(1)`
- search - `O(n x k)`
- startsWith - `O(n x k)`
- `n` is number of words
- `k` is length of words being inserted.
>Space Complexity - 
- startsWith - `O(k)`
- worst case - O(n x k)

#### Optimal -

```java
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
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

public class ImplementTries {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("ap"));
    }
}
```
>Time Complexity - 
- insert - `O(k)`
- search - `O(k)`
- startsWith - `O(k)`
- `k` is length of words being inserted.
>Space Complexity - 
- insert - `O(k)`
- search - `O(k)`
- startsWith - `O(k)`
- worst case - O(n x k)
- `k` is length of words being inserted.
- `n` is average length of words.
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Design Add and Search Words Data Structure**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-17 230111.png" />
</div>

#### Brute - 

```java

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
```
>Time Complexity - 
- addWord - O(1)
- search - O(n x k)
- n is number of stored words;
- k is length of search word.
>Space Complexity - O(n x k)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
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

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index]; // Move node forward
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null)
            return false;
        if (index == word.length())
            return node.isEndOfWord;
        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (node != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }
}

public class AddAndSearchWords {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.insert("bad");
        wordDictionary.insert("dad");
        wordDictionary.insert("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
```
>Time Complexity -
- addWord - O(k)
- search - O(26<sup>m</sup>)
- m is search word length

>Space Complexity - O(n x k) 
#### Explanation

-

#### Steps

-

#### Follow up 

-
