namespace Org.Example
{
    public class Comparer<T> : IComparer<T>
    {
        private readonly Comparison<T> comparison;

        public Comparer(Comparison<T> comparison) => this.comparison = comparison ?? throw new Exception("必须有");

        public int Compare(T x, T y) => comparison(x, y);
    }
}