package org.example;

import java.util.HashMap;
import java.util.Map;

public class T211 {
    class WordDictionary {
        Node root = new Node();

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node next = curr.children.get(ch);
                if (next == null) {
                    next = new Node();
                    curr.children.put(ch, next);
                }
                curr = next;
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return dfs(root, word, 0);
        }

        boolean dfs(Node curr, String word, int i) {
            if (i == word.length()) {
                return curr.isWord;
            }
            if (word.charAt(i) != '.') {
                Node node = curr.children.get(word.charAt(i));
                return node != null && dfs(node, word, i + 1);
            }
            for (Node node : curr.children.values()) {
                if (dfs(node, word, i + 1)) {
                    return true;
                }
            }
            return false;
        }

        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
        }
    }
}
