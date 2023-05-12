package org.example;

/**
 * 红黑树实现有序集
 *
 * @param <T> 元素类型
 */
public class TreeSet<T> implements SortedSet<T> {
    private static final Object PRESENT = new Object();
    private final TreeMap<T, Object> map;

    public TreeSet(Comparator<? super T> comparator) {
        map = new TreeMap<>(comparator);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Comparator<? super T> comparator() {
        return map.comparator();
    }

    @Override
    public boolean add(T t) {
        return map.put(t, PRESENT) != PRESENT;
    }

    @Override
    public boolean contains(T t) {
        return map.containsKey(t);
    }

    @Override
    public boolean remove(T t) {
        return map.remove(t) == PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public T first() {
        return map.first();
    }

    @Override
    public T last() {
        return map.last();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keys().iterator();
    }

    @Override
    public Set<T> intersection(Set<? extends T> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<T> set = new TreeSet<>(comparator());
        Iterator<? extends T> it = other.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (contains(next)) {
                set.add(next);
            }
        }
        return set;
    }

    @Override
    public Set<T> union(Set<? extends T> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<T> set = new TreeSet<>(comparator());
        Iterator<T> it1 = iterator();
        while (it1.hasNext()) {
            set.add(it1.next());
        }
        Iterator<? extends T> it2 = other.iterator();
        while (it2.hasNext()) {
            set.add(it2.next());
        }
        return set;
    }

    @Override
    public Set<T> complement(Set<? extends T> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Iterator<? extends T> it2 = other.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return new TreeSet<>(comparator());
            }
        }
        return difference(other);
    }

    @Override
    public Set<T> difference(Set<? extends T> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<T> set = new TreeSet<>(comparator());
        Iterator<T> it1 = iterator();
        while (it1.hasNext()) {
            set.add(it1.next());
        }
        Iterator<? extends T> it2 = other.iterator();
        while (it2.hasNext()) {
            set.remove(it2.next());
        }
        return set;
    }

    @Override
    public Set<T> symmetric(Set<? extends T> other) {
        if (other == null) {
            throw new RuntimeException("必须有");
        }
        Set<T> set = union(other);
        Iterator<T> it = intersection(other).iterator();
        while (it.hasNext()) {
            set.remove(it.next());
        }
        return set;
    }
}
