namespace Org.Example
{
    public class TreeMap<K, V> : ISortedMap<K, V>
    {
        private static readonly bool RED = true;
        private static readonly bool BLACK = false;
        private TreeNode root;

        public TreeMap(IComparer<K> comparer)
        {
            Comparer = comparer ?? throw new Exception("必须有比较器");
            Keys = new KeyCollection(this);
            Values = new ValueCollection(this);
            Pairs = new PairCollection(this);
        }

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            TreeNode next;
            for (TreeNode curr = GetFirst(); curr != default; curr = next)
            {
                next = GetNextNode(curr);
                UnlinkNode(curr, default);
            }
            root = default;
            Count = 0;
        }

        public V this[K key]
        {
            get
            {
                TreeNode node = GetNode(key);
                return node == default ? default : node.value;
            }
            set
            {
                TreeNode curr = root;
                TreeNode parent = default;
                int cmp = 0;
                while (curr != default)
                {
                    parent = curr;
                    cmp = Comparer.Compare(key, curr.key);
                    if (cmp < 0)
                    {
                        curr = curr.left;
                    }
                    else if (cmp > 0)
                    {
                        curr = curr.right;
                    }
                    else
                    {
                        curr.value = value;
                        return;
                    }
                }
                curr = new TreeNode(key, value, parent);
                if (cmp < 0)
                {
                    parent.left = curr;
                }
                else if (cmp > 0)
                {
                    parent.right = curr;
                }
                else
                {
                    root = curr;
                }
                Count++;
                AdjustBalance(parent, true);
            }
        }

        public V Replace(K key, V newValue)
        {
            TreeNode node = GetNode(key);
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
            TreeNode curr = GetNode(key);
            if (curr == default)
            {
                return default;
            }
            V value = RemoveNode(curr);
            Count--;
            return value;
        }

        public bool ContainsKey(K key) => GetNode(key) != default;

        public bool ContainsValue(V value)
        {
            for (TreeNode curr = GetFirst(); curr != default; curr = GetNextNode(curr))
            {
                if (Equals(value, curr.value))
                {
                    return true;
                }
            }
            return false;
        }

        public ICollection<K> Keys { get; }

        public ICollection<V> Values { get; }

        public ICollection<IPair<K, V>> Pairs { get; }

        public IComparer<K> Comparer { get; }

        public K First
        {
            get
            {
                Check();
                return GetFirst().key;
            }
        }

        public K Last
        {
            get
            {
                Check();
                return GetLast().key;
            }
        }

        private static void FlipColors(TreeNode curr)
        {
            curr.color = RED;
            curr.left.color = BLACK;
            curr.right.color = BLACK;
        }

        private static bool IsColor(TreeNode curr, bool color)
        {
            return curr != default && curr.color == color;
        }

        private static TreeNode GetNextNode(TreeNode curr)
        {
            if (curr == default)
            {
                return default;
            }
            else if (curr.right != default)
            {
                curr = curr.right;
                while (curr.left != default)
                {
                    curr = curr.left;
                }
                return curr;
            }
            TreeNode parent = curr.parent;
            while (parent != default && curr == parent.right)
            {
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }

        private void Check()
        {
            if (Count <= 0)
            {
                throw new Exception("集合为空");
            }
        }

        private TreeNode GetFirst()
        {
            TreeNode curr = root;
            if (curr != default)
            {
                while (curr.left != default)
                {
                    curr = curr.left;
                }
            }
            return curr;
        }

        private TreeNode GetLast()
        {
            TreeNode curr = root;
            if (curr != default)
            {
                while (curr.right != default)
                {
                    curr = curr.right;
                }
            }
            return curr;
        }

        private TreeNode GetNode(K key)
        {
            TreeNode curr = root;
            while (curr != default)
            {
                int cmp = Comparer.Compare(key, curr.key);
                if (cmp < 0)
                {
                    curr = curr.left;
                }
                else if (cmp > 0)
                {
                    curr = curr.right;
                }
                else
                {
                    return curr;
                }
            }
            return default;
        }

        private V RemoveNode(TreeNode curr)
        {
            V value = curr.value;
            if (curr.left != default && curr.right != default)
            {
                TreeNode next = GetNextNode(curr);
                curr.key = next.key;
                curr.value = next.value;
                curr = next;
            }
            TreeNode replace = curr.left != default ? curr.left : curr.right;
            if (replace != default)
            {
                UnlinkNode(curr, replace);
                if (IsColor(curr, BLACK))
                {
                    AdjustBalance(replace, false);
                }
            }
            else if (curr.parent == default)
            {
                UnlinkNode(root, default);
            }
            else
            {
                if (IsColor(curr, BLACK))
                {
                    AdjustBalance(curr, false);
                }
                UnlinkNode(curr, default);
            }
            return value;
        }

        private void UnlinkNode(TreeNode curr, TreeNode replace)
        {
            Relink(curr, replace);
            curr.key = default;
            curr.value = default;
            curr.left = default;
            curr.right = default;
            curr.parent = default;
        }

        private TreeNode Relink(TreeNode curr, TreeNode replace)
        {
            if (replace != default)
            {
                replace.parent = curr.parent;
            }
            if (curr.parent == default)
            {
                root = replace;
            }
            else if (curr.parent.left == curr)
            {
                curr.parent.left = replace;
            }
            else
            {
                curr.parent.right = replace;
            }
            curr.parent = replace;
            return replace;
        }

        private TreeNode RotateLeft(TreeNode curr)
        {
            TreeNode right = curr.right;
            curr.right = right.left;
            if (right.left != default)
            {
                right.left.parent = curr;
            }
            right.left = curr;
            right.color = curr.color;
            curr.color = RED;
            return Relink(curr, right);
        }

        private TreeNode RotateRight(TreeNode curr)
        {
            TreeNode left = curr.left;
            curr.left = left.right;
            if (left.right != default)
            {
                left.right.parent = curr;
            }
            left.right = curr;
            left.color = curr.color;
            curr.color = RED;
            return Relink(curr, left);
        }

        private void AdjustBalance(TreeNode curr, bool isAdd)
        {
            if (isAdd)
            {
                while (curr != default)
                {
                    if (IsColor(curr, BLACK) && IsColor(curr.right, RED))
                    {
                        curr = RotateLeft(curr);
                    }
                    if (IsColor(curr.left, RED) && IsColor(curr.left.left, RED))
                    {
                        curr = RotateRight(curr);
                    }
                    if (IsColor(curr.left, RED) && IsColor(curr.right, RED))
                    {
                        FlipColors(curr);
                    }
                    curr = curr.parent;
                }
            }
            else
            {
                // TODO 删除后平衡未实现
            }
            root.color = BLACK;
        }

        private class TreeNode
        {
            public K key;
            public V value;
            public TreeNode left;
            public TreeNode right;
            public TreeNode parent;
            public bool color = RED;

            public TreeNode(K key, V value, TreeNode parent)
            {
                this.key = key;
                this.value = value;
                this.parent = parent;
            }
        }

        private class NodeEtor : IEnumerator<TreeNode>
        {
            private readonly TreeMap<K, V> self;
            private TreeNode curr;

            public NodeEtor(TreeMap<K, V> self)
            {
                this.self = self;
                curr = new TreeNode(default, default, self.GetFirst());
            }

            public TreeNode Current => curr;

            public bool MoveNext()
            {
                TreeNode next = GetNextNode(curr);
                if (next == default)
                {
                    return false;
                }
                curr = next;
                return true;
            }
        }

        private class KeyCollection : ICollection<K>
        {
            private readonly TreeMap<K, V> self;

            public KeyCollection(TreeMap<K, V> self) => this.self = self;

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

                public KeyEtor(TreeMap<K, V> self) => etor = new NodeEtor(self);

                public K Current => etor.Current.key;

                public bool MoveNext() => etor.MoveNext();
            }
        }

        private class ValueCollection : ICollection<V>
        {
            private readonly TreeMap<K, V> self;

            public ValueCollection(TreeMap<K, V> self) => this.self = self;

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

                public ValueEtor(TreeMap<K, V> self) => etor = new NodeEtor(self);

                public V Current => etor.Current.value;

                public bool MoveNext() => etor.MoveNext();
            }
        }

        private class PairCollection : ICollection<IPair<K, V>>
        {
            private readonly TreeMap<K, V> self;

            public PairCollection(TreeMap<K, V> self) => this.self = self;

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
                TreeNode node = self.GetNode(item.Key);
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

                public PairEtor(TreeMap<K, V> self) => etor = new NodeEtor(self);

                public IPair<K, V> Current => new Pair<K, V>(etor.Current.key, etor.Current.value);

                public bool MoveNext() => etor.MoveNext();
            }
        }
    }
}