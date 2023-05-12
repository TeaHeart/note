package org.example;

/**
 * 链表实现双端队列和列表
 *
 * @param <T> 元素类型
 */
public class LinkedList<T> implements Deque<T>, List<T> {
    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public LinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    private static <T> T unlinkNode(Node<T> curr, boolean isRelink) {
        if (isRelink) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        T t = curr.value;
        curr.prev = null;
        curr.next = null;
        curr.value = null;
        return t;
    }

    private static <T> void insertPrev(Node<T> curr, T t) {
        Node<T> node = new Node<>(t, curr.prev, curr);
        node.prev.next = node;
        node.next.prev = node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Node<T> curr = head.next;
        while (curr != tail) {
            Node<T> next = curr.next;
            unlinkNode(curr, false);
            curr = next;
        }
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public boolean add(T t) {
        return offerLast(t);
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) != -1;
    }

    @Override
    public boolean remove(T t) {
        Node<T> curr = getNode(t);
        if (curr == null) {
            return false;
        }
        unlinkNode(curr, true);
        size--;
        return true;
    }

    @Override
    public boolean offerFirst(T t) {
        return insert(0, t);
    }

    @Override
    public boolean offerLast(T t) {
        return insert(size(), t);
    }

    @Override
    public T peekFirst() {
        check();
        return get(0);
    }

    @Override
    public T peekLast() {
        check();
        return get(size() - 1);
    }

    @Override
    public T pollFirst() {
        check();
        return removeAt(0);
    }

    @Override
    public T pollLast() {
        check();
        return removeAt(size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    @Override
    public boolean insert(int index, T t) {
        check(index, true);
        Node<T> node = getNode(index);
        insertPrev(node, t);
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        check(index, false);
        return getNode(index).value;
    }

    @Override
    public T set(int index, T t) {
        check(index, false);
        Node<T> node = getNode(index);
        T old = node.value;
        node.value = t;
        return old;
    }

    @Override
    public T removeAt(int index) {
        check(index, false);
        Node<T> node = getNode(index);
        T t = unlinkNode(node, true);
        size--;
        return t;
    }

    @Override
    public int indexOf(T t) {
        int index = 0;
        for (Node<T> curr = head.next; curr != tail; curr = curr.next) {
            if (t == curr.value || t != null && t.equals(curr.value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean offer(T t) {
        return offerLast(t);
    }

    @Override
    public boolean push(T t) {
        return offerFirst(t);
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public T pop() {
        return pollFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    private void check() {
        if (size <= 0) {
            throw new RuntimeException("集合为空");
        }
    }

    private void check(int index, boolean isAdd) {
        if (index < 0) {
            throw new RuntimeException("索引必须为非负数");
        } else if (isAdd && index > size) {
            throw new RuntimeException("索引越界");
        } else if (!isAdd && index >= size) {
            throw new RuntimeException("索引越界");
        }
    }

    private Node<T> getNode(int index) {
        Node<T> curr;
        if (index * 2 <= size) {
            curr = head.next;
            while (index-- > 0) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            while (index++ < size) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    private Node<T> getNode(T t) {
        for (Node<T> curr = head.next; curr != tail; curr = curr.next) {
            if (t == curr.value || t != null && t.equals(curr.value)) {
                return curr;
            }
        }
        return null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private class Iter implements Iterator<T> {
        private Node<T> next = head.next;

        @Override
        public boolean hasNext() {
            return next != tail;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("没有下一个元素");
            }
            Node<T> curr = next;
            next = next.next;
            return curr.value;
        }
    }
}
