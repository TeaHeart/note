namespace Org.Example
{
    public interface IDeque<T> : IStack<T>, IQueue<T>
    {
        bool OfferFirst(T item);

        bool OfferLast(T item);

        T PeekFirst();

        T PeekLast();

        T PollFirst();

        T PollLast();
    }
}