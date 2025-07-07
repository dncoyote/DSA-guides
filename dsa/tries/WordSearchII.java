package tries;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  String word = null;
}

public class WordSearchII {

  private List<String> result = new ArrayList<>();

  public static void main(String[] args) {
    WordSearchII solver = new WordSearchII();
    char[][] board = {
        { 'o', 'a', 'a', 'n' },
        { 'e', 't', 'a', 'e' },
        { 'i', 'h', 'k', 'r' },
        { 'i', 'f', 'l', 'v' }
    };

    String[] words = { "oath", "pea", "eat", "rain" };
    List<String> foundWords = solver.findWords(board, words);

    System.out.println("Words found: " + foundWords);
  }

  private List<String> findWords(char[][] board, String[] words) {
    TrieNode root = buildTrie(words);

    int rows = board.length;
    int cols = board[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        dfs(board, row, col, root);
      }
    }

    return result;
  }

  private void dfs(char[][] board, int row, int col, TrieNode node) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
      return;

    char c = board[row][col];

    if (c == '#' || node.children[c - 'a'] == null)
      return;

    node = node.children[c - 'a'];

    if (node.word != null) {
      result.add(node.word);
      node.word = null;
    }

    board[row][col] = '#';

    dfs(board, row + 1, col, node);
    dfs(board, row - 1, col, node);
    dfs(board, row, col + 1, node);
    dfs(board, row, col - 1, node);
    
    board[row][col] = c;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();

    for (String word : words) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (node.children[c - 'a'] == null) {
          node.children[c - 'a'] = new TrieNode();
        }
        node = node.children[c - 'a'];
      }
      node.word = word;
    }
    return root;
  }
}
