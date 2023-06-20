namespace Org.Example
{
    public interface IEnumerator<out T>
    {
        T Current { get; }

        bool MoveNext();
    }
}