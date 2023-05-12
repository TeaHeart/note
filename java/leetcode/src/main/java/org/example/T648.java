package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(trie.search(words[i]));
            if (i != words.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

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

        public String search(String word) {
            StringBuilder sb = new StringBuilder();
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node next = curr.children.get(ch);
                if (next == null) {
                    break;
                }
                sb.append(ch);
                curr = next;
                if (curr.isWord) {
                    return sb.toString();
                }
            }
            return word;
        }

        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
        }
    }
}
