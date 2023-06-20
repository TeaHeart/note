namespace Org.Example
{
    public class HashMap<K, V> : IMap<K, V>
    {
        private static readonly int CAPACITY = 1 << 3;
        private static readonly float LOAD_FACTOR = 0.75f;
        private Node[] table;

        public HashMap() : this(CAPACITY) { }

        public HashMap(int capacity)
        {
            if (capacity < 0)
            {
                throw new Exception("必须为非负数");
            }
            table = new Node[MultipleOfTwo(capacity)];
            Keys = new KeyCollection(this);
            Values = new ValueCollection(this);
            Pairs = new PairCollection(this);
        }

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            for (int i = 0; i < table.Length; i++)
            {
                Node curr = table[i];
                while (curr != default)
                {
                    Node next = curr.next;
                    UnlinkNode(default, curr);
                    curr = next;
                }
                table[i] = default;
            }
            Count = 0;
        }

        public V this[K key]
        {
            get
            {
                Node node = GetNode(key);
                return node != default ? node.value : default;
            }
            set
            {
                int hash = Hash(key);
                int slot = Slot(hash);
                Node node = GetNode(hash, key, table[slot]);
                if (node != default)
                {
                    node.value = value;
                    return;
                }
                table[slot] = new Node(hash, key, value, table[slot]);
                Count++;
                AdjustCapacityCheck(true);
            }
        }

        public V Replace(K key, V newValue)
        {
            Node node = GetNode(key);
            if (node == default)
            {
                return default;
            }
            V value = node.value;
            node.value = newValue;
            return value;
        }

        public V Remove(K key)
        {
            int hash = Hash(key);
            int slot = Slot(hash);
            Node dummy = new Node(table[slot]);
            Node prev = dummy;
            Node curr = dummy.next;
            while (curr != default)
            {
                if (KeyEquals(hash, key, curr))
                {
                    V value = UnlinkNode(prev, curr);
                    Count--;
                    table[slot] = dummy.next;
                    AdjustCapacityCheck(false);
                    return value;
                }
                prev = curr;
                curr = curr.next;
            }
            return default;
        }

        public bool ContainsKey(K key) => GetNode(key) != default;

        public bool ContainsValue(V value)
        {
            NodeEtor etor = new NodeEtor(this);
            while (etor.MoveNext())
            {
                if (Equals(value, etor.Current))
                {
                    return true;
                }
            }
            return false;
        }

        public ICollection<K> Keys { get; }

        public ICollection<V> Values { get; }

        public ICollection<IPair<K, V>> Pairs { get; }

        private static int Hash(K key)
        {
            int hash = key?.GetHashCode() ?? 0;
            return hash ^ (int)((uint)hash >> 16);
        }

        private static bool KeyEquals(int hash, K key, Node node) => node != default && hash == node.hash && Equals(key, node.key);

        private static Node GetNode(int hash, K key, Node curr)
        {
            while (curr != default)
            {
                if (KeyEquals(hash, key, curr))
                {
                    return curr;
                }
                curr = curr.next;
            }
            return default;
        }

        private static V UnlinkNode(Node prev, Node curr)
        {
            if (prev != default)
            {
                prev.next = curr.next;
            }
            V value = curr.value;
            curr.value = default;
            curr.next = default;
            return value;
        }

        private static int MultipleOfTwo(int capacity)
        {
            for (int i = 1; i <= 1 << 4; i <<= 1)
            {
                capacity |= (int)((uint)capacity >> i);
            }
            return ++capacity < 0 ? (int)((uint)capacity >> 1) : capacity;
        }

        private int Slot(int hash) => hash & table.Length - 1;

        private Node GetNode(K key)
        {
            int hash = Hash(key);
            return GetNode(hash, key, table[Slot(hash)]);
        }

        private void AdjustCapacityCheck(bool isAdd)
        {
            int n = table.Length;
            if (isAdd && Count == (int)(n * LOAD_FACTOR))
            {
                AdjustCapacity(n == 0 ? 1 : n * 2);
            }
            else if (!isAdd && Count == (int)(n * (1 - LOAD_FACTOR)))
            {
                AdjustCapacity(n == 1 ? 1 : n / 2);
            }
        }

        private void AdjustCapacity(int newCapacity)
        {
            Node[] old = table;
            table = new Node[newCapacity];
            for (int i = 0; i < old.Length; i++)
            {
                Node curr = old[i];
                while (curr != default)
                {
                    Node next = curr.next;
                    int slot = Slot(curr.hash);
                    curr.next = table[slot];
                    table[slot] = curr;
                    curr = next;
                }
            }
        }

        private class NodeEtor : IEnumerator<Node>
        {
            private readonly HashMap<K, V> self;
            private readonly int fence;
            private int slot;
            private Node curr;

            public NodeEtor(HashMap<K, V> self)
            {
                this.self = self;
                fence = self.table.Length;
                slot = -1;
                curr = new Node(default);
            }

            public Node Current => curr;

            public bool MoveNext()
            {
                if (curr.next == default)
                {
                    if (slot == fence)
                    {
                        return false;
                    }
                    slot++;
                    curr = new Node(NextSlot());
                    return MoveNext();
                }
                curr = curr.next;
                return true;
            }

            private Node NextSlot()
            {
                while (slot < fence)
                {
                    if (self.table[slot] != default)
                    {
                        return self.table[slot];
                    }
                    slot++;
                }
                return default;
            }

        }

        private class KeyCollection : ICollection<K>
        {
            private readonly HashMap<K, V> self;

            public KeyCollection(HashMap<K, V> self) => this.self = self;

            public int Count => self.Count;

            public bool IsEmpty => self.IsEmpty;

            public void Clear() => throw new Exception("不支持该操作");

            public bool Add(K item) => throw new Exception("不支持该操作");

            public bool Contains(K item) => self.ContainsKey(item);

            public bool Remove(K item) => throw new Exception("不支持该操作");

            public IEnumerator<K> GetEnumerator() => new KeyEtor(self);

            private struct KeyEtor : IEnumerator<K>
            {
                private readonly NodeEtor etor;

                public KeyEtor(HashMap<K, V> self) => etor = new NodeEtor(self);

                public K Current => etor.Current.key;

                public bool MoveNext() => etor.MoveNext();
            }
        }

        private class ValueCollection : ICollection<V>
        {
            private readonly HashMap<K, V> self;

            public ValueCollection(HashMap<K, V> self) => this.self = self;

            public int Count => self.Count;

            public bool IsEmpty => self.IsEmpty;

            public void Clear() => throw new Exception("不支持该操作");

            public bool Add(V item) => throw new Exception("不支持该操作");

            public bool Contains(V item) => self.ContainsValue(item);

            public bool Remove(V item) => throw new Exception("不支持该操作");

            public IEnumerator<V> GetEnumerator() => new ValueEtor(self);

            private struct ValueEtor : IEnumerator<V>
            {
                private readonly NodeEtor etor;

                public ValueEtor(HashMap<K, V> self) => etor = new NodeEtor(self);

                public V Current => etor.Current.value;

                public bool MoveNext() => etor.MoveNext();
            }
        }

        private class PairCollection : ICollection<IPair<K, V>>
        {
            private readonly HashMap<K, V> self;

            public PairCollection(HashMap<K, V> self) => this.self = self;

            public int Count => self.Count;

            public bool IsEmpty => self.IsEmpty;

            public void Clear() => throw new Exception("不支持该操作");

            public bool Add(IPair<K, V> item) => throw new Exception("不支持该操作");

            public bool Contains(IPair<K, V> item)
            {
                if (item == default)
                {
                    throw new Exception("必须有");
                }
                Node node = self.GetNode(item.Key);
                if (node == default)
                {
                    return false;
                }
                return Equals(item.Value, node.value);
            }

            public bool Remove(IPair<K, V> item) => throw new Exception("不支持该操作");

            public IEnumerator<IPair<K, V>> GetEnumerator() => new PairEtor(self);

            private struct PairEtor : IEnumerator<IPair<K, V>>
            {
                private readonly NodeEtor etor;

                public PairEtor(HashMap<K, V> self) => etor = new NodeEtor(self);

                public IPair<K, V> Current => new Pair<K, V>(etor.Current.key, etor.Current.value);

                public bool MoveNext() => etor.MoveNext();
            }
        }

        private class Node
        {
            public readonly int hash;
            public readonly K key;
            public V value;
            public Node next;

            public Node(Node next) : this(default, default, default, next) { }

            public Node(int hash, K key, V value, Node next)
            {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }
    }
}