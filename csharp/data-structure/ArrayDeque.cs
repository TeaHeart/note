namespace Org.Example
{
    public class ArrayDeque<T> : IDeque<T>, IList<T>
    {
        private static readonly int CAPACITY = 1 << 3;
        private T[] element;
        private int head;
        private int tail;

        public ArrayDeque() : this(CAPACITY) { }

        public ArrayDeque(int capacity)
        {
            if (capacity < 0)
            {
                throw new Exception("必须为非负数");
            }
            element = new T[MultipleOfTwo(capacity)];
        }

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            int mask = element.Length - 1;
            for (int i = head; i != tail; i = i + 1 & mask)
            {
                element[i] = default;
            }
            head = tail = Count = 0;
        }

        public bool Add(T item) => OfferLast(item);

        public bool Contains(T item) => IndexOf(item) >= 0;

        public bool Remove(T item)
        {
            int index = IndexOf(item);
            if (index < 0)
            {
                return false;
            }
            RemoveAt(index);
            return true;
        }

        bool IStack<T>.Push(T item) => OfferFirst(item);

        T IStack<T>.Peek() => PeekFirst();

        T IStack<T>.Pop() => PollFirst();

        bool IQueue<T>.Offer(T item) => OfferLast(item);

        T IQueue<T>.Peek() => PeekFirst();

        T IQueue<T>.Poll() => PollFirst();

        public bool OfferFirst(T item)
        {
            head = head - 1 & element.Length - 1;
            element[head] = item;
            Count++;
            AdjustCapacityCheck(true);
            return true;
        }

        public bool OfferLast(T item)
        {
            element[tail] = item;
            tail = tail + 1 & element.Length - 1;
            Count++;
            AdjustCapacityCheck(true);
            return true;
        }

        public T PeekFirst()
        {
            Check();
            return element[head];
        }

        public T PeekLast()
        {
            Check();
            return element[tail - 1 & element.Length - 1];
        }

        public T PollFirst()
        {
            Check();
            T item = element[head];
            element[head] = default;
            head = head + 1 & element.Length - 1;
            Count--;
            AdjustCapacityCheck(false);
            return item;
        }

        public T PollLast()
        {
            Check();
            tail = tail - 1 & element.Length - 1;
            T item = element[tail];
            element[tail] = default;
            Count--;
            AdjustCapacityCheck(false);
            return item;
        }

        public T this[int index]
        {
            get
            {
                index = IndexOffset(index);
                Check(index, false);
                return element[index];
            }
            set
            {
                index = IndexOffset(index);
                Check(index, false);
                element[index] = value;
            }
        }

        public bool Insert(int index, T item)
        {
            index = IndexOffset(index);
            Check(index, true);
            int mask = element.Length - 1;
            for (int i = tail; i != index; i = i - 1 & mask)
            {
                element[i] = element[i - 1 & mask];
            }
            tail = tail + 1 & mask;
            element[index] = item;
            Count++;
            AdjustCapacityCheck(true);
            return true;
        }

        public T RemoveAt(int index)
        {
            index = IndexOffset(index);
            Check(index, false);
            T item = element[index];
            int mask = element.Length - 1;
            for (int i = index; i != tail; i = i + 1 & mask)
            {
                element[i] = element[i + 1 & mask];
            }
            tail = tail - 1 & mask;
            element[tail] = default;
            Count--;
            AdjustCapacityCheck(false);
            return item;
        }

        public int IndexOf(T item)
        {
            int index = 0;
            int mask = element.Length - 1;
            for (int i = head; i != tail; i = i + 1 & mask, index++)
            {
                if (Equals(item, element[i]))
                {
                    return index;
                }
            }
            return -1;
        }

        public IEnumerator<T> GetEnumerator() => new Etor(this);

        private static int MultipleOfTwo(int capacity)
        {
            for (int i = 1; i <= 1 << 4; i <<= 1)
            {
                capacity |= (int)((uint)capacity >> i);
            }
            return ++capacity < 0 ? (int)((uint)capacity >> 1) : capacity;
        }

        private int IndexOffset(int index)
        {
            if (index < 0)
            {
                throw new Exception("索引必须为非负数");
            }
            return index + head & element.Length - 1;
        }

        private void Check()
        {
            if (Count <= 0)
            {
                throw new Exception("集合为空");
            }
        }

        private void Check(int index, bool isAdd)
        {
            if (index < 0)
            {
                throw new Exception("索引必须为非负数");
            }
            else if (isAdd && (head <= tail && (index < head || index > tail) || head > tail && index < head && index > tail))
            {
                throw new Exception("索引越界");
            }
            else if (!isAdd && (head <= tail && (index < head || index >= tail) || head > tail && index < head && index >= tail))
            {
                throw new Exception("索引越界");
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
            int mask = old.Length - 1;
            for (int i = 0; i < Count; i++)
            {
                element[i] = old[i + head & mask];
            }
            head = 0;
            tail = Count;
        }

        private struct Etor : IEnumerator<T>
        {
            private readonly ArrayDeque<T> self;
            private readonly int head;
            private readonly int tail;
            private readonly int mask;
            private int cursor;

            public Etor(ArrayDeque<T> self)
            {
                this.self = self;
                head = self.head;
                tail = self.tail;
                mask = self.element.Length - 1;
                cursor = head - 1 & mask;
            }

            public T Current
            {
                get
                {
                    if (head <= tail && (cursor < head || cursor > tail) || head > tail && cursor < head && cursor > tail)
                    {
                        throw new Exception("索引越界");
                    }
                    return self.element[cursor];
                }
            }

            public bool MoveNext()
            {
                if (cursor + 1 == tail)
                {
                    return false;
                }
                cursor = cursor + 1 & mask;
                return true;
            }
        }
    }
}