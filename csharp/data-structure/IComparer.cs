namespace Org.Example
{
    public interface IComparer<T>
    {
        int Compare(T x, T y);
    }
}