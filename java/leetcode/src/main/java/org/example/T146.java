package org.example;

import java.util.HashMap;
import java.util.Map;

public class T146 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            unlinkNode(node);
            insertHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                unlinkNode(node);
                insertHead(node);
                return;
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            insertHead(newNode);
            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                unlinkNode(tail.prev);
            }
        }

        void unlinkNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void insertHead(Node node) {
            node.prev = head;
            node.next = head.next;
            node.prev.next = node;
            node.next.prev = node;
        }

        class Node {
            Node prev;
            Node next;
            int key;
            int value;
        }
    }
}
