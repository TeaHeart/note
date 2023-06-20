package org.example;

/**
 * 哈希实现映射表
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public class HashMap<K, V> implements Map<K, V> {
    private static final int CAPACITY = 1 << 3;
    private static final float LOAD_FACTOR = 0.75f;
    private final Collection<K> keys = new KetCollection();
    private final Collection<V> values = new ValueCollection();
    private final Collection<Entry<K, V>> entries = new EntryCollection();
    private Node<K, V>[] table;
    private int size;

    public HashMap() {
        this(CAPACITY);
    }

    public HashMap(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("必须为非负数");
        }
        table = newArray(multipleOfTwo(capacity));
    }

    private static <K, V> Node<K, V>[] newArray(int capacity) {
        return (Node<K, V>[]) new Node<?, ?>[capacity];
    }

    private static int multipleOfTwo(int capacity) {
        for (int i = 1; i <= 1 << 4; i <<= 1) {
            capacity |= capacity >>> i;
        }
        return ++capacity < 0 ? capacity >>> 1 : capacity;
    }

    private static <K> int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hash = key.hashCode();
        return hash ^ hash >>> 16;
    }

    private static <K, V> boolean keyEquals(int hash, K key, Node<K, V> node) {
        return node != null && hash == node.hash && (key == node.key || key != null && key.equals(node.key));
    }

    private static <K, V> Node<K, V> getNode(int hash, K key, Node<K, V> curr) {
        while (curr != null) {
            if (keyEquals(hash, key, curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private static <K, V> V unlinkNode(Node<K, V> prev, Node<K, V> curr) {
        if (prev != null) {
            prev.next = curr.next;
        }
        V value = curr.value;
        curr.value = null;
        curr.next = null;
        return value;
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
        for (int i = 0; i < table.length; i++) {
            Node<K, V> curr = table[i];
            while (curr != null) {
                Node<K, V> next = curr.next;
                unlinkNode(null, curr);
                curr = next;
            }
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        int slot = slot(hash);
        Node<K, V> node = getNode(hash, key, table[slot]);
        if (node != null) {
            return node.setValue(value);
        }
        table[slot] = new Node<>(hash, key, value, table[slot]);
        size++;
        adjustCapacityCheck(true);
        return null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public V replace(K key, V value) {
        Node<K, V> node = getNode(key);
        return node != null ? node.setValue(value) : null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        int slot = slot(hash);
        Node<K, V> dummy = new Node<>(table[slot]);
        Node<K, V> prev = dummy;
        Node<K, V> curr = dummy.next;
        while (curr != null) {
            if (keyEquals(hash, key, curr)) {
                V value = unlinkNode(prev, curr);
                size--;
                table[slot] = dummy.next;
                adjustCapacityCheck(false);
                return value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        NodeIter iter = new NodeIter();
        while (iter.hasNext()) {
            Node<K, V> next = iter.next();
            if (value == next.value || value != null && value.equals(next.value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<K> keys() {
        return keys;
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Collection<Entry<K, V>> entries() {
        return entries;
    }

    private int slot(int hash) {
        return hash & table.length - 1;
    }

    private Node<K, V> getNode(K key) {
        int hash = hash(key);
        return getNode(hash, key, table[slot(hash)]);
    }

    private void adjustCapacityCheck(boolean isAdd) {
        int n = table.length;
        if (isAdd && size == (int) (n * LOAD_FACTOR)) {
            adjustCapacity(n == 0 ? 1 : n * 2);
        } else if (!isAdd && size == (int) (n * (1 - LOAD_FACTOR))) {
            adjustCapacity(n == 1 ? 1 : n / 2);
        }
    }

    private void adjustCapacity(int newCapacity) {
        Node<K, V>[] old = table;
        table = newArray(newCapacity);
        for (Node<K, V> curr : old) {
            while (curr != null) {
                Node<K, V> next = curr.next;
                int slot = slot(curr.hash);
                curr.next = table[slot];
                table[slot] = curr;
                curr = next;
            }
        }
    }

    private static class Node<K, V> implements Entry<K, V> {
        private final int hash;
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(Node<K, V> next) {
            this(0, null, null, next);
        }

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public K setKey(K key) {
            throw new RuntimeException("不能修改键");
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    private class NodeIter implements Iterator<Node<K, V>> {
        private int slot;
        private Node<K, V> next = size != 0 ? nextSlot() : null;

        private Node<K, V> nextSlot() {
            while (slot < table.length) {
                if (table[slot] != null) {
                    return table[slot];
                }
                slot++;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Node<K, V> next() {
            if (!hasNext()) {
                throw new RuntimeException("没有下一个元素");
            }
            Node<K, V> curr = next;
            next = next.next;
            if (next == null) {
                slot++;
                next = nextSlot();
            }
            return curr;
        }
    }

    private class EntryCollection implements Collection<Entry<K, V>> {
        @Override
        public int size() {
            return HashMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return HashMap.this.isEmpty();
        }

        @Override
        public boolean add(Entry<K, V> entry) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public boolean contains(Entry<K, V> entry) {
            if (entry == null) {
                throw new RuntimeException("必须有");
            }
            Node<K, V> node = getNode(entry.getKey());
            if (node == null) {
                return false;
            }
            V value = entry.getValue();
            return value == node.value || value != null && value.equals(node.value);
        }

        @Override
        public boolean remove(Entry<K, V> entry) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public void clear() {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIter();
        }

        private class EntryIter implements Iterator<Entry<K, V>> {
            private final NodeIter iter = new NodeIter();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Entry<K, V> next() {
                return iter.next();
            }
        }
    }

    private class KetCollection implements Collection<K> {
        @Override
        public int size() {
            return HashMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return HashMap.this.isEmpty();
        }

        @Override
        public boolean add(K key) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public boolean contains(K key) {
            return containsKey(key);
        }

        @Override
        public boolean remove(K key) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public void clear() {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public Iterator<K> iterator() {
            return new KeyIter();
        }

        private class KeyIter implements Iterator<K> {
            private final NodeIter iter = new NodeIter();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public K next() {
                return iter.next().key;
            }
        }
    }

    private class ValueCollection implements Collection<V> {
        @Override
        public int size() {
            return HashMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return HashMap.this.isEmpty();
        }

        @Override
        public boolean add(V value) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public boolean contains(V value) {
            return containsValue(value);
        }

        @Override
        public boolean remove(V value) {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public void clear() {
            throw new RuntimeException("不支持该操作");
        }

        @Override
        public Iterator<V> iterator() {
            return new ValueIter();
        }

        private class ValueIter implements Iterator<V> {
            private final NodeIter iter = new NodeIter();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public V next() {
                return iter.next().value;
            }
        }
    }
}
