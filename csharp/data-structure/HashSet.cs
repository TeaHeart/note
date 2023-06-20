namespace Org.Example
{
    public class HashSet<T> : ISet<T>
    {
        private static readonly int CAPACITY = 1 << 3;
        private static readonly object PRESENT = new object();
        private readonly HashMap<T, object> map;

        public HashSet() : this(CAPACITY) { }

        public HashSet(int capacity) => map = new HashMap<T, object>(capacity);

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

        public IEnumerator<T> GetEnumerator() => map.Keys.GetEnumerator();
    }
}