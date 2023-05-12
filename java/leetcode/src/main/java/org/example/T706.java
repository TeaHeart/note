package org.example;

public class T706 {
    class MyHashMap {
        Node[] table = new Node[16];
        int size;

        int slot(int key) {
            return key & table.length - 1;
        }

        void grow() {
            if (size == table.length / 2) {
                Node[] old = table;
                table = new Node[table.length * 2];
                for (Node curr : old) {
                    while (curr != null) {
                        Node next = curr.next;
                        int slot = slot(curr.key);
                        curr.next = table[slot];
                        table[slot] = curr;
                        curr = next;
                    }
                }
            }
        }

        Node getNode(int key, Node curr) {
            while (curr != null) {
                if (key == curr.key) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }

        public void put(int key, int value) {
            int slot = slot(key);
            Node node = getNode(key, table[slot]);
            if (node != null) {
                node.value = value;
                return;
            }
            table[slot] = new Node(key, value, table[slot]);
            size++;
            grow();
        }

        public void remove(int key) {
            int slot = slot(key);
            Node dummy = new Node(0, 0, table[slot]);
            for (Node prev = dummy; prev.next != null; prev = prev.next) {
                if (key == prev.next.key) {
                    prev.next = prev.next.next;
                    table[slot] = dummy.next;
                    return;
                }
            }
        }

        public int get(int key) {
            Node node = getNode(key, table[slot(key)]);
            return node != null ? node.value : -1;
        }

        class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }
    }
}
