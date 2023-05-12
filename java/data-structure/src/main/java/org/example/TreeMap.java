package org.example;

/**
 * 红黑树实有序映射表
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public class TreeMap<K, V> implements SortedMap<K, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private final Collection<K> keys = new KeyCollection();
    private final Collection<V> values = new ValueCollection();
    private final Collection<Entry<K, V>> entries = new EntryCollection();
    private final Comparator<? super K> comparator;
    private TreeNode<K, V> root;
    private int size;

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    private static void flipColors(TreeNode<?, ?> curr) {
        curr.color = RED;
        curr.left.color = BLACK;
        curr.right.color = BLACK;
    }

    private static boolean isColor(TreeNode<?, ?> curr, boolean color) {
        return curr != null && curr.color == color;
    }

    private static <K, V> TreeNode<K, V> getNextNode(TreeNode<K, V> curr) {
        if (curr == null) {
            return null;
        } else if (curr.right != null) {
            curr = curr.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        TreeNode<K, V> parent = curr.parent;
        while (parent != null && curr == parent.right) {
            curr = parent;
            parent = parent.parent;
        }
        return parent;
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
        TreeNode<K, V> next;
        for (TreeNode<K, V> curr = getFirst(); curr != null; curr = next) {
            next = getNextNode(curr);
            unlinkNode(curr, null);
        }
        root = null;
        size = 0;
    }

    @Override
    public Comparator<? super K> comparator() {
        return comparator;
    }

    @Override
    public V put(K key, V value) {
        TreeNode<K, V> curr = root;
        TreeNode<K, V> parent = null;
        int cmp = 0;
        while (curr != null) {
            parent = curr;
            cmp = comparator.compare(key, curr.key);
            if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            } else {
                return curr.setValue(value);
            }
        }
        curr = new TreeNode<>(key, value, parent);
        if (cmp < 0) {
            parent.left = curr;
        } else if (cmp > 0) {
            parent.right = curr;
        } else {
            root = curr;
        }
        size++;
        adjustBalance(parent, true);
        return null;
    }

    @Override
    public V get(K key) {
        TreeNode<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public V replace(K key, V value) {
        TreeNode<K, V> node = getNode(key);
        return node != null ? node.setValue(value) : null;
    }

    @Override
    public V remove(K key) {
        TreeNode<K, V> curr = getNode(key);
        if (curr == null) {
            return null;
        }
        V old = removeNode(curr);
        size--;
        return old;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (TreeNode<K, V> curr = getFirst(); curr != null; curr = getNextNode(curr)) {
            if (value == curr.value || value != null && value.equals(curr.value)) {
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

    @Override
    public K first() {
        check();
        return getFirst().key;
    }

    @Override
    public K last() {
        check();
        return getLast().key;
    }

    private void check() {
        if (size <= 0) {
            throw new RuntimeException("集合为空");
        }
    }

    private TreeNode<K, V> getFirst() {
        TreeNode<K, V> curr = root;
        if (curr != null) {
            while (curr.left != null) {
                curr = curr.left;
            }
        }
        return curr;
    }

    private TreeNode<K, V> getLast() {
        TreeNode<K, V> curr = root;
        if (curr != null) {
            while (curr.right != null) {
                curr = curr.right;
            }
        }
        return curr;
    }

    private TreeNode<K, V> getNode(K key) {
        TreeNode<K, V> curr = root;
        while (curr != null) {
            int cmp = comparator.compare(key, curr.key);
            if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

    private V removeNode(TreeNode<K, V> curr) {
        V value = curr.value;
        if (curr.left != null && curr.right != null) {
            TreeNode<K, V> next = getNextNode(curr);
            curr.key = next.key;
            curr.value = next.value;
            curr = next;
        }
        TreeNode<K, V> replace = curr.left != null ? curr.left : curr.right;
        if (replace != null) {
            unlinkNode(curr, replace);
            if (isColor(curr, BLACK)) {
                adjustBalance(replace, false);
            }
        } else if (curr.parent == null) {
            unlinkNode(root, null);
        } else {
            if (isColor(curr, BLACK)) {
                adjustBalance(curr, false);
            }
            unlinkNode(curr, null);
        }
        return value;
    }

    private void unlinkNode(TreeNode<K, V> curr, TreeNode<K, V> replace) {
        relink(curr, replace);
        curr.key = null;
        curr.value = null;
        curr.left = null;
        curr.right = null;
        curr.parent = null;
    }

    private TreeNode<K, V> relink(TreeNode<K, V> curr, TreeNode<K, V> replace) {
        if (replace != null) {
            replace.parent = curr.parent;
        }
        if (curr.parent == null) {
            root = replace;
        } else if (curr.parent.left == curr) {
            curr.parent.left = replace;
        } else {
            curr.parent.right = replace;
        }
        curr.parent = replace;
        return replace;
    }

    private TreeNode<K, V> rotateLeft(TreeNode<K, V> curr) {
        TreeNode<K, V> right = curr.right;
        curr.right = right.left;
        if (right.left != null) {
            right.left.parent = curr;
        }
        right.left = curr;
        right.color = curr.color;
        curr.color = RED;
        return relink(curr, right);
    }

    private TreeNode<K, V> rotateRight(TreeNode<K, V> curr) {
        TreeNode<K, V> left = curr.left;
        curr.left = left.right;
        if (left.right != null) {
            left.right.parent = curr;
        }
        left.right = curr;
        left.color = curr.color;
        curr.color = RED;
        return relink(curr, left);
    }

    private void adjustBalance(TreeNode<K, V> curr, boolean isAdd) {
        if (isAdd) {
            while (curr != null) {
                if (isColor(curr, BLACK) && isColor(curr.right, RED)) {
                    curr = rotateLeft(curr);
                }
                if (isColor(curr.left, RED) && isColor(curr.left.left, RED)) {
                    curr = rotateRight(curr);
                }
                if (isColor(curr.left, RED) && isColor(curr.right, RED)) {
                    flipColors(curr);
                }
                curr = curr.parent;
            }
        } else {
            // TODO 删除后平衡未实现
        }
        root.color = BLACK;
    }

    private static class TreeNode<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private TreeNode<K, V> left;
        private TreeNode<K, V> right;
        private TreeNode<K, V> parent;
        private boolean color = RED;

        private TreeNode(K key, V value, TreeNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public K setKey(K key) {
            K old = this.key;
            this.key = key;
            return old;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    private class NodeIter implements Iterator<TreeNode<K, V>> {
        private TreeNode<K, V> next = getFirst();

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public TreeNode<K, V> next() {
            if (!hasNext()) {
                throw new RuntimeException("没有下一个元素");
            }
            TreeNode<K, V> curr = next;
            next = getNextNode(next);
            return curr;
        }
    }

    private class EntryCollection implements Collection<Entry<K, V>> {
        @Override
        public int size() {
            return TreeMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
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
            TreeNode<K, V> node = getNode(entry.getKey());
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

    private class KeyCollection implements Collection<K> {
        @Override
        public int size() {
            return TreeMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
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
            return TreeMap.this.size();
        }

        @Override
        public boolean isEmpty() {
            return TreeMap.this.isEmpty();
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
