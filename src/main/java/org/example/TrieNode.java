package org.example;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<String,TrieNode> children;
    String value;

    TrieNode(){
        children = new HashMap<>();
    }
}
