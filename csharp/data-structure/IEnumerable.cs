namespace Org.Example
{
    public interface IEnumerable<out T>
    {
        IEnumerator<T> GetEnumerator();
    }
}