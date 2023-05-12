package org.example;

import java.util.HashMap;
import java.util.Map;

public class T208 {
    class Trie {
        Node root = new Node();

        public void insert(String word) {
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

        Node getNode(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                Node next = curr.children.get(c);
                if (next == null) {
                    return null;
                }
                curr = next;
            }
            return curr;
        }

        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
        }
    }
}
