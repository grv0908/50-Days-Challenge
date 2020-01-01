package com.grv.day01;

import java.util.Map;

/**
 * @author Gaurav Rajput
 * Created on 30/12/19
 */
public class Trie {
    public TrieNode root;
    private int size;
    private int totalChars;

    Trie() {
        this.root = new TrieNode('/');
        this.size = 0;
    }

    public void insert(String word) {
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        if(word.length() == 0) {
            if(!root.isWord) {
                root.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(0);
        if(!root.children.containsKey(c)) {
            TrieNode newNode = new TrieNode(c);
            totalChars++;
            root.children.put(c, newNode);
        }
        insert(root.children.get(c), word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isWord;
        }

        char c = word.charAt(0);
        if(root.children.containsKey(c)) {
            return search(root.children.get(c), word.substring(1));
        }
        return false;
    }

    public void traverse() {
        traverse(root, "");
    }

    private void traverse(TrieNode root, String word) {
        if(root.isWord) {
            System.out.println(word);
        }

        if(root.children.size() == 0)
            return;

        for(Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            char c = entry.getKey();

            traverse(root.children.get(c), word + c);
        }
    }

    public void removeWord(String word) {
        
    }

    public int getSize() {
        return size;
    }

    public int getTotalChars() {
        return totalChars;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("good");
        t.insert("goodword");
        t.insert("goodie");

        System.out.println(t.totalChars + " " + t.size);
        t.traverse();

        t.insert("fog");
        t.insert("forgive");

        System.out.println(t.totalChars + " " + t.size);

        System.out.println(t.search("goodi"));
        System.out.println(t.search("goodie"));
        System.out.println(t.search("forgi"));

        t.traverse();
    }
}
