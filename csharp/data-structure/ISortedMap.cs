namespace Org.Example
{
    public interface ISortedMap<K, V> : IMap<K, V>
    {
        IComparer<K> Comparer { get; }

        K First { get; }

        K Last { get; }
    }
}