namespace Org.Example
{
    public class TreeSet<T> : ISortedSet<T>
    {
        private static readonly object PRESENT = new object();
        private readonly TreeMap<T, object> map;

        public TreeSet(IComparer<T> comparer) => map = new TreeMap<T, object>(comparer);

        public int Count => map.Count;

        public bool IsEmpty => map.IsEmpty;

        public void Clear() => map.Clear();

        public bool Add(T item)
        {
            if (map[item] != default)
            {
                return false;
            }
            map[item] = PRESENT;
            return true;
        }

        public bool Contains(T item) => map.ContainsKey(item);

        public bool Remove(T item) => map.Remove(item) == PRESENT;

        public bool Intersection(ISet<T> other)
        {
            if (other == default)
            {
                throw new Exception("必须有");
            }
            bool flag = false;
            foreach (var item in this)
            {
                if (!other.Contains(item))
                {
                    flag |= Remove(item);
                }
            }
            return flag;
        }

        public bool Union(ISet<T> other)
        {
            if (other == default)
            {
                throw new Exception("必须有");
            }
            bool flag = false;
            foreach (var item in other)
            {
                flag |= Add(item);
            }
            return flag;
        }

        public bool Complement(ISet<T> other)
        {
            if (other == default)
            {
                throw new Exception("必须有");
            }
            foreach (var item in other)
            {
                if (!Contains(item))
                {
                    return false;
                }
            }
            return Difference(other);
        }

        public bool Difference(ISet<T> other)
        {
            if (other == default)
            {
                throw new Exception("必须有");
            }
            bool flag = false;
            foreach (var item in other)
            {
                flag |= Remove(item);
            }
            return flag;
        }

        public bool Symmetric(ISet<T> other)
        {
            if (other == default)
            {
                throw new Exception("必须有");
            }
            bool flag = false;
            foreach (var item in other)
            {
                flag |= Contains(item) ? Remove(item) : Add(item);
            }
            return flag;
        }

        public IComparer<T> Comparer => map.Comparer;

        public T First => map.First;

        public T Last => map.Last;

        public IEnumerator<T> GetEnumerator() => map.Keys.GetEnumerator();
    }
}