namespace Org.Example
{
    public interface IPriorityQueue<T> : IQueue<T>
    {
        IComparer<T> Comparer { get; }
    }
}