namespace Org.Example
{
    public class ArrayPriorityQueue<T> : IPriorityQueue<T>
    {
        private static readonly int CAPACITY = 1 << 3;
        private T[] element;

        public ArrayPriorityQueue(IComparer<T> comparer) : this(CAPACITY, comparer) { }

        public ArrayPriorityQueue(int capacity, IComparer<T> comparer)
        {
            if (capacity < 0)
            {
                throw new Exception("必须为非负数");
            }
            Comparer = comparer ?? throw new Exception("必须有比较器");
            element = new T[MultipleOfTwo(capacity)];
        }

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            for (int i = 0; i < Count; i++)
            {
                element[i] = default;
            }
            Count = 0;
        }

        bool ICollection<T>.Add(T item) => Offer(item);

        public bool Contains(T item)
        {
            for (int i = 0; i < Count; i++)
            {
                if (Equals(item, element[i]))
                {
                    return true;
                }
            }
            return false;
        }

        public bool Remove(T item)
        {
            while (!IsEmpty)
            {
                T poll = Poll();
                if (Equals(item, poll))
                {
                    return true;
                }
            }
            return false;
        }

        public bool Offer(T item)
        {
            element[Count] = item;
            Swim(element, Count++, Comparer);
            AdjustCapacityCheck(true);
            return true;
        }

        public T Peek()
        {
            Check();
            return element[0];
        }

        public T Poll()
        {
            Check();
            T item = element[0];
            element[0] = element[--Count];
            element[Count] = default;
            Sink(element, 0, Count, Comparer);
            AdjustCapacityCheck(false);
            return item;
        }

        public IComparer<T> Comparer { get; }

        public IEnumerator<T> GetEnumerator() => new Etor(this);

        private static int MultipleOfTwo(int capacity)
        {
            for (int i = 1; i <= 1 << 4; i <<= 1)
            {
                capacity |= (int)((uint)capacity >> i);
            }
            return ++capacity < 0 ? (int)((uint)capacity >> 1) : capacity;
        }

        private static void Swim(T[] array, int k, IComparer<T> comparer)
        {
            T t = array[k];
            while (k > 0)
            {
                int parent = (k - 1) / 2;
                if (comparer.Compare(t, array[parent]) >= 0)
                {
                    break;
                }
                array[k] = array[parent];
                k = parent;
            }
            array[k] = t;
        }

        private static void Sink(T[] array, int k, int n, IComparer<T> comparer)
        {
            T t = array[k];
            while (k < n / 2)
            {
                int child = 2 * k + 1;
                if (child + 1 < n && comparer.Compare(array[child], array[child + 1]) > 0)
                {
                    child++;
                }
                if (comparer.Compare(t, array[child]) < 0)
                {
                    break;
                }
                array[k] = array[child];
                k = child;
            }
            array[k] = t;
        }

        private void Check()
        {
            if (Count <= 0)
            {
                throw new Exception("集合为空");
            }
        }

        private void AdjustCapacityCheck(bool isAdd)
        {
            int n = element.Length;
            if (isAdd && Count == n)
            {
                AdjustCapacity(n == 0 ? 1 : n * 2);
            }
            else if (!isAdd && Count == n / 4)
            {
                AdjustCapacity(n == 1 ? 1 : n / 2);
            }
        }

        private void AdjustCapacity(int newCapacity)
        {
            T[] old = element;
            element = new T[newCapacity];
            for (int i = 0; i < Count; i++)
            {
                element[i] = old[i];
            }
        }

        private struct Etor : IEnumerator<T>
        {
            private readonly ArrayPriorityQueue<T> self;
            private readonly int fence;
            private int cursor;

            public Etor(ArrayPriorityQueue<T> self)
            {
                this.self = self;
                fence = self.Count;
                cursor = -1;
            }

            public T Current
            {
                get
                {
                    if (cursor < 0 || cursor > fence)
                    {
                        throw new Exception("索引越界");
                    }
                    return self.element[cursor];
                }
            }

            public bool MoveNext()
            {
                if (cursor + 1 == fence)
                {
                    return false;
                }
                cursor++;
                return true;
            }
        }
    }
}