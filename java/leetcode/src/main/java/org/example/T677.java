package org.example;

import java.util.HashMap;
import java.util.Map;

public class T677 {
    class MapSum {
        Node root = new Node();

        public void insert(String key, int val) {
            Node find = getNode(key);
            int sum = val;
            if (find != null && find.isWord) {
                sum -= find.value;
            }
            Node curr = root;
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                Node next = curr.children.get(ch);
                if (next == null) {
                    next = new Node();
                    curr.children.put(ch, next);
                }
                curr = next;
                curr.sum += sum;
            }
            curr.isWord = true;
            curr.value = val;
        }

        public int sum(String prefix) {
            Node node = getNode(prefix);
            return node == null ? 0 : node.sum;
        }

        Node getNode(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                Node next = curr.children.get(prefix.charAt(i));
                if (next == null) {
                    return null;
                }
                curr = next;
            }
            return curr;
        }

        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
            int sum;
            int value;
        }
    }
}
