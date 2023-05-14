namespace Org.Example
{
    public interface IPair<K, V>
    {
        K Key { get; set; }

        V Value { get; set; }
    }
}