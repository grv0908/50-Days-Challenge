package com.grv.day01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Gaurav Rajput
 * Created on 30/12/19
 *
 * @link
 * https://leetcode.com/problems/word-search-ii/
 *
 *
 *
 */

class WordBoggle {
    HashSet<String> set;
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        set = new HashSet<>();
        for (String word : words) {
            t.insert(word);
        }

        traverse(t, board);
        return new ArrayList<>(set);
    }

    public void traverse(Trie t, char[][] board) {
        TrieNode root = t.root;

        boolean[][] visited = new boolean[board.length][board[0].length];
        String word = "";
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(root.children.containsKey(board[i][j])) {
                    find(i, j, root.children.get(board[i][j]), board, word + board[i][j], visited);
                    word = "";
                }
            }
        }
    }


    public boolean isSafe(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public void find(int i, int j, TrieNode root, char[][] board, String word, boolean[][] visited) {
        if(root.isWord) {
            set.add(word);
        }

        visited[i][j] = true;


        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            char c = entry.getKey();

            if(isSafe(i + 1, j, board) && !visited[i + 1][j] && board[i+1][j] == c) {
                find(i + 1,  j, root.children.get(c), board, word + c, visited);
            }
            if(isSafe(i - 1, j, board) && !visited[i - 1][j] && board[i-1][j] == c) {
                find(i - 1, j, root.children.get(c), board, word + c, visited);
            }
            if(isSafe(i, j + 1, board) && !visited[i][j + 1] && board[i][j + 1] == c) {
                find(i, j + 1, root.children.get(c), board, word + c, visited);
            }
            if(isSafe(i, j - 1, board) && !visited[i][j - 1] && board[i][j - 1] == c) {
                find(i, j - 1, root.children.get(c), board, word + c, visited);
            }
        }

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"oath","pea","eat","rain"};
        char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};


        WordBoggle wb = new WordBoggle();
        System.out.println(wb.findWords(board, arr));
    }
}