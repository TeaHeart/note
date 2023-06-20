namespace Org.Example
{
    public interface ISet<T> : ICollection<T>
    {
        bool Intersection(ISet<T> other);

        bool Union(ISet<T> other);

        bool Complement(ISet<T> other);

        bool Difference(ISet<T> other);

        bool Symmetric(ISet<T> other);
    }
}