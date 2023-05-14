namespace Org.Example
{
    public struct Pair<K, V> : IPair<K, V>
    {
        public K Key { get; set; }

        public V Value { get; set; }

        public Pair(K key, V value)
        {
            Key = key;
            Value = value;
        }

        public void Deconstruct(out K key, out V value)
        {
            key = Key;
            value = Value;
        }
    }
}