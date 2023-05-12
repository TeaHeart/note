package org.example;

/**
 * 哈希实现字典树
 */
public class HashTrieTree implements TrieTree {
    private final Node root = new Node('\0');
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(String word) {
        if (word == null) {
            throw new RuntimeException("必须有");
        }
        Node curr = root;
        for (char ch : word.toCharArray()) {
            Node next = curr.map.get(ch);
            if (next == null) {
                next = new Node(ch);
                curr.map.put(ch, next);
            }
            curr = next;
        }
        if (curr.isWord) {
            return false;
        }
        curr.isWord = true;
        size++;
        return true;
    }

    @Override
    public boolean contains(String word) {
        if (word == null) {
            throw new RuntimeException("必须有");
        }
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    @Override
    public boolean remove(String word) {
        if (word == null) {
            throw new RuntimeException("必须有");
        }
        Node curr = getNode(word);
        if (curr == null || !curr.isWord) {
            return false;
        }
        curr.isWord = false;
        size--;
        clear(root, false);
        return true;
    }

    @Override
    public void clear() {
        clear(root, true);
        root.isWord = false;
        size = 0;
    }

    @Override
    public boolean containsPrefix(String prefix) {
        if (prefix == null) {
            throw new RuntimeException("必须有");
        }
        return getNode(prefix) != null;
    }

    @Override
    public boolean removePrefix(String prefix) {
        if (prefix == null) {
            throw new RuntimeException("必须有");
        }
        Node node = getNode(prefix);
        if (node == null) {
            return false;
        }
        clear(node, true);
        if (node.isWord) {
            node.isWord = false;
            size--;
        }
        clear(root, false);
        if (root.isWord && "".equals(prefix)) {
            root.isWord = false;
            size--;
        }
        return true;
    }

    @Override
    public Set<String> matchPrefix(String prefix) {
        if (prefix == null) {
            throw new RuntimeException("必须有");
        }
        return buildWord(getNode(prefix), prefix);
    }

    @Override
    public Iterator<String> iterator() {
        return buildWord(root, "").iterator();
    }

    private Node getNode(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            Node next = curr.map.get(c);
            if (next == null) {
                return null;
            }
            curr = next;
        }
        return curr;
    }

    private boolean clear(Node curr, boolean isDelete) {
        Iterator<Node> it = curr.map.values().iterator();
        if (isDelete) {
            while (it.hasNext()) {
                Node next = it.next();
                if (next.isWord) {
                    size--;
                    next.isWord = false;
                }
                clear(next, true);
            }
        } else {
            while (it.hasNext()) {
                if (clear(it.next(), false)) {
                    return true;
                }
            }
            if (curr.isWord) {
                return true;
            }
        }
        curr.map.clear();
        return false;
    }

    private Set<String> buildWord(Node curr, String prefix) {
        Set<String> set = new HashSet<>();
        if (curr == null) {
            return set;
        }
        if (curr.isWord) {
            set.add(prefix);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Node> it = curr.map.values().iterator();
        while (it.hasNext()) {
            buildWord(it.next(), prefix, sb, set);
        }
        return set;
    }

    private void buildWord(Node curr, String prefix, StringBuilder sb, Set<String> set) {
        sb.append(curr.ch);
        if (curr.isWord) {
            set.add(prefix + sb);
        }
        Iterator<Node> it = curr.map.values().iterator();
        while (it.hasNext()) {
            buildWord(it.next(), prefix, sb, set);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    @Override
    public Set<String> intersection(Set<? extends String> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<String> set = new HashSet<>();
        Iterator<? extends String> it = other.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (contains(next)) {
                set.add(next);
            }
        }
        return set;
    }

    @Override
    public Set<String> union(Set<? extends String> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<String> set = new HashSet<>();
        Iterator<String> it1 = iterator();
        while (it1.hasNext()) {
            set.add(it1.next());
        }
        Iterator<? extends String> it2 = other.iterator();
        while (it2.hasNext()) {
            set.add(it2.next());
        }
        return set;
    }

    @Override
    public Set<String> complement(Set<? extends String> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Iterator<? extends String> it2 = other.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return new HashSet<>();
            }
        }
        return difference(other);
    }

    @Override
    public Set<String> difference(Set<? extends String> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<String> set = new HashSet<>();
        Iterator<String> it1 = iterator();
        while (it1.hasNext()) {
            set.add(it1.next());
        }
        Iterator<? extends String> it2 = other.iterator();
        while (it2.hasNext()) {
            set.remove(it2.next());
        }
        return set;
    }

    @Override
    public Set<String> symmetric(Set<? extends String> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<String> set = union(other);
        Iterator<String> it = intersection(other).iterator();
        while (it.hasNext()) {
            set.remove(it.next());
        }
        return set;
    }

    private static class Node {
        private final Map<Character, Node> map = new HashMap<>();
        private final char ch;
        private boolean isWord;

        private Node(char ch) {
            this.ch = ch;
        }
    }
}
