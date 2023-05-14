namespace Org.Example
{
    public interface IQueue<T> : ICollection<T>
    {
        bool Offer(T item);

        T Peek();

        T Poll();
    }
}