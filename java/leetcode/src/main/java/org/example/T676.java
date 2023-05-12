package org.example;

import java.util.HashMap;
import java.util.Map;

public class T676 {

    class MagicDictionary {
        Node root = new Node();

        public void buildDict(String[] dict) {
            for (String s : dict) {
                Node curr = root;
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    Node node = curr.map.get(ch);
                    if (node == null) {
                        node = new Node();
                        curr.map.put(ch, node);
                    }
                    curr = node;
                }
                curr.isWord = true;
            }
        }

        public boolean search(String word) {
            return dfs(root, word, 0, false);
        }

        boolean dfs(Node curr, String word, int i, boolean modified) {
            if (i == word.length()) {
                return modified && curr.isWord;
            }
            Node next = curr.map.get(word.charAt(i));
            if (next != null) {
                if (dfs(next, word, i + 1, modified)) {
                    return true;
                }
            }
            if (!modified) {
                for (Map.Entry<Character, Node> entry : curr.map.entrySet()) {
                    char key = entry.getKey();
                    Node value = entry.getValue();
                    if (key != word.charAt(i)) {
                        if (dfs(value, word, i + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        class Node {
            boolean isWord;
            HashMap<Character, Node> map = new HashMap<>();
        }
    }
}
