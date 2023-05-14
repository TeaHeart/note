namespace Org.Example
{
    public interface ITrieTree : ISet<string>
    {
        bool ContainsPrefix(string prefix);

        bool RemovePrefix(string prefix);

        ISet<string> MatchPrefix(string prefix);
    }
}