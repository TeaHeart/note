package org.example;

public class T707 {
    class MyLinkedList {
        Node tail;
        Node head;
        int size;

        public MyLinkedList() {
            head = new Node(0, null, null);
            tail = new Node(0, null, null);
            head.next = tail;
            tail.prev = head;
        }

        Node getNode(int index) {
            Node curr;
            if (index * 2 > size) {
                for (curr = tail; index < size; index++) {
                    curr = curr.prev;
                }
            } else {
                for (curr = head.next; index > 0; index--) {
                    curr = curr.next;
                }
            }
            return curr;
        }

        public int get(int index) {
            return !(0 <= index && index < size) ? -1 : getNode(index).value;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (!(0 <= index && index <= size)) {
                return;
            }
            Node curr = getNode(index);
            Node node = new Node(val, curr.prev, curr);
            curr.prev.next = node;
            node.next.prev = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (!(0 <= index && index < size)) {
                return;
            }
            Node curr = getNode(index);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            size--;
        }

        class Node {
            int value;
            Node prev;
            Node next;

            public Node(int value, Node prev, Node next) {
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
    }
}
