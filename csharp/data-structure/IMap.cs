namespace Org.Example
{
    public interface IMap<K, V>
    {
        int Count { get; }

        bool IsEmpty { get; }

        void Clear();

        V this[K key] { get; set; }

        V Replace(K key, V value);

        V Remove(K key);

        bool ContainsKey(K key);

        bool ContainsValue(V value);

        ICollection<K> Keys { get; }

        ICollection<V> Values { get; }

        ICollection<IPair<K, V>> Pairs { get; }
    }
}