namespace Org.Example
{
    public interface ICollection<T> : IEnumerable<T>
    {
        int Count { get; }

        bool IsEmpty { get; }

        void Clear();

        bool Add(T item);

        bool Contains(T item);

        bool Remove(T item);
    }
}