namespace Org.Example
{
    public interface ISortedSet<T> : ISet<T>
    {
        IComparer<T> Comparer { get; }

        T First { get; }

        T Last { get; }
    }
}