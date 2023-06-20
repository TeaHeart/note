namespace Org.Example
{
    public class LinkedList<T> : IDeque<T>, IList<T>
    {
        private readonly Node head;
        private readonly Node tail;

        public LinkedList()
        {
            head = new Node(default);
            tail = new Node(default);
            head.next = tail;
            tail.prev = head;
        }

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            Node curr = head.next;
            while (curr != tail)
            {
                Node next = curr.next;
                UnlinkNode(curr, false);
                curr = next;
            }
            head.next = tail;
            tail.prev = head;
            Count = 0;
        }

        public bool Add(T item) => OfferLast(item);

        public bool Contains(T item) => IndexOf(item) >= 0;

        public bool Remove(T item)
        {
            Node curr = GetNode(item);
            if (curr == default)
            {
                return false;
            }
            UnlinkNode(curr, true);
            Count--;
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
            InsertPrev(head.next, item);
            Count++;
            return true;
        }

        public bool OfferLast(T item)
        {
            InsertPrev(tail, item);
            Count++;
            return true;
        }

        public T PeekFirst()
        {
            Check();
            return head.next.value;
        }

        public T PeekLast()
        {
            Check();
            return tail.prev.value;
        }

        public T PollFirst()
        {
            Check();
            T item = UnlinkNode(head.next, true);
            Count--;
            return item;
        }

        public T PollLast()
        {
            Check();
            T item = UnlinkNode(tail.prev, true);
            Count--;
            return item;
        }

        public T this[int index]
        {
            get
            {
                Check(index, false);
                return GetNode(index).value;
            }
            set
            {
                Check(index, false);
                GetNode(index).value = value;
            }
        }

        public bool Insert(int index, T item)
        {
            Check(index, true);
            Node node = GetNode(index);
            InsertPrev(node, item);
            Count++;
            return true;
        }

        public T RemoveAt(int index)
        {
            Check(index, false);
            Node node = GetNode(index);
            T item = UnlinkNode(node, true);
            Count--;
            return item;
        }

        public int IndexOf(T item)
        {
            int index = 0;
            for (Node curr = head.next; curr != tail; curr = curr.next)
            {
                if (Equals(item, curr.value))
                {
                    return index;
                }
                index++;
            }
            return -1;
        }

        public IEnumerator<T> GetEnumerator() => new Etor(this);

        private static T UnlinkNode(Node curr, bool isRelink)
        {
            if (isRelink)
            {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            T item = curr.value;
            curr.prev = default;
            curr.next = default;
            curr.value = default;
            return item;
        }

        private static void InsertPrev(Node curr, T item)
        {
            Node node = new Node(item, curr.prev, curr);
            node.prev.next = node;
            node.next.prev = node;
        }

        private Node GetNode(int index)
        {
            Node curr;
            if (index * 2 <= Count)
            {
                curr = head.next;
                while (index-- > 0)
                {
                    curr = curr.next;
                }
            }
            else
            {
                curr = tail;
                while (index++ < Count)
                {
                    curr = curr.prev;
                }
            }
            return curr;
        }

        private Node GetNode(T item)
        {
            for (Node curr = head.next; curr != tail; curr = curr.next)
            {
                if (Equals(item, curr.value))
                {
                    return curr;
                }
            }
            return default;
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
            else if (isAdd && index > Count)
            {
                throw new Exception("索引越界");
            }
            else if (!isAdd && index >= Count)
            {
                throw new Exception("索引越界");
            }
        }

        private class Node
        {
            public T value;

            public Node prev;

            public Node next;

            public Node(T value) : this(value, default, default) { }

            public Node(T value, Node prev, Node next)
            {
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }

        private struct Etor : IEnumerator<T>
        {
            private readonly LinkedList<T> self;
            private Node curr;

            public Etor(LinkedList<T> self)
            {
                this.self = self;
                curr = self.head;
            }

            public T Current => curr.value;

            public bool MoveNext()
            {
                if (curr.next == self.tail)
                {
                    return false;
                }
                curr = curr.next;
                return true;
            }
        }
    }
}