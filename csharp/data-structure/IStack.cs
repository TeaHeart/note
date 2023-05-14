namespace Org.Example
{
    public interface IStack<T> : ICollection<T>
    {
        bool Push(T item);

        T Peek();

        T Pop();
    }
}