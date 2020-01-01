package com.grv.day01;

import java.util.HashMap;

/**
 * @author Gaurav Rajput
 * Created on 30/12/19
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children;
    boolean isWord;

    TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
        this.isWord = false;
    }
}
