namespace Org.Example
{
    public interface IList<T> : ICollection<T>
    {
        T this[int index] { get; set; }

        bool Insert(int index, T item);

        T RemoveAt(int index);

        int IndexOf(T item);
    }
}