package AS;

public interface AdvancedSetInterface
{
    boolean add(int element);
    boolean contains(int element);
    boolean remove(int element);
    boolean isFull();
    boolean isEmpty();
    int size();
    int grab();
    void clear();
    String toString();
    AdvancedSetInterface union(AdvancedSetInterface set);
    AdvancedSetInterface intersection(AdvancedSetInterface set);
    AdvancedSetInterface complement(AdvancedSetInterface set);
}
