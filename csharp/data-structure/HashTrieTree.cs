using System.Text;

namespace Org.Example
{
    public class HashTrieTree : ITrieTree
    {
        private readonly Node root = new Node('\0');

        public int Count { get; private set; }

        public bool IsEmpty => Count == 0;

        public void Clear()
        {
            Clear(root, true);
            root.isWord = false;
            Count = 0;
        }

        public bool Add(string item)
        {
            if (item == default)
            {
                throw new Exception("必须有");
            }
            Node curr = root;
            foreach (char ch in item)
            {
                Node next = curr.map[ch];
                if (next == default)
                {
                    next = new Node(ch);
                    curr.map[ch] = next;
                }
                curr = next;
            }
            if (curr.isWord)
            {
                return false;
            }
            curr.isWord = true;
            Count++;
            return true;
        }

        public bool Contains(string item)
        {
            if (item == default)
            {
                throw new Exception("必须有");
            }
            Node node = GetNode(item);
            return node != default && node.isWord;
        }

        public bool Remove(string item)
        {
            if (item == default)
            {
                throw new Exception("必须有");
            }
            Node curr = GetNode(item);
            if (curr == default || !curr.isWord)
            {
                return false;
            }
            curr.isWord = false;
            Count--;
            Clear(root, false);
            return true;
        }

        public bool Intersection(ISet<string> other)
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

        public bool Union(ISet<string> other)
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

        public bool Complement(ISet<string> other)
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

        public bool Difference(ISet<string> other)
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

        public bool Symmetric(ISet<string> other)
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

        public bool ContainsPrefix(string prefix)
        {
            if (prefix == default)
            {
                throw new Exception("必须有");
            }
            return GetNode(prefix) != default;
        }

        public bool RemovePrefix(string prefix)
        {
            if (prefix == default)
            {
                throw new Exception("必须有");
            }
            Node node = GetNode(prefix);
            if (node == default)
            {
                return false;
            }
            Clear(node, true);
            if (node.isWord)
            {
                node.isWord = false;
                Count--;
            }
            Clear(root, false);
            if (root.isWord && "" == prefix)
            {
                root.isWord = false;
                Count--;
            }
            return true;
        }

        public ISet<string> MatchPrefix(string prefix)
        {
            if (prefix == default)
            {
                throw new Exception("必须有");
            }
            return BuildWord(GetNode(prefix), prefix);
        }

        public IEnumerator<string> GetEnumerator() => MatchPrefix("").GetEnumerator();

        private Node GetNode(string prefix)
        {
            Node curr = root;
            foreach (char c in prefix)
            {
                Node next = curr.map[c];
                if (next == default)
                {
                    return default;
                }
                curr = next;
            }
            return curr;
        }

        private bool Clear(Node curr, bool isDelete)
        {
            if (isDelete)
            {
                foreach (var item in curr.map.Values)
                {
                    if (item.isWord)
                    {
                        Count--;
                        item.isWord = false;
                    }
                    Clear(item, true);
                }
            }
            else
            {
                foreach (var item in curr.map.Values)
                {
                    if (Clear(item, false))
                    {
                        return true;
                    }
                }
                if (curr.isWord)
                {
                    return true;
                }
            }
            curr.map.Clear();
            return false;
        }

        private ISet<string> BuildWord(Node curr, string prefix)
        {
            ISet<string> set = new HashSet<string>();
            if (curr == default)
            {
                return set;
            }
            if (curr.isWord)
            {
                set.Add(prefix);
            }
            StringBuilder sb = new StringBuilder();
            foreach (var item in curr.map.Values)
            {
                BuildWord(item, prefix, sb, set);
            }
            return set;
        }

        private void BuildWord(Node curr, string prefix, StringBuilder sb, ISet<string> set)
        {
            sb.Append(curr.ch);
            if (curr.isWord)
            {
                set.Add(prefix + sb);
            }
            foreach (var item in curr.map.Values)
            {
                BuildWord(item, prefix, sb, set);
            }
            sb.Remove(sb.Length - 1, 1);
        }

        private class Node
        {
            public readonly IMap<char, Node> map = new HashMap<char, Node>();
            public readonly char ch;
            public bool isWord;

            public Node(char ch) => this.ch = ch;
        }
    }
}