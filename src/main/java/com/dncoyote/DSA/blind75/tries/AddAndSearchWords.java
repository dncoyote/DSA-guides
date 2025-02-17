package com.dncoyote.DSA.blind75.tries;

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
