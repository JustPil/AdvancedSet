package AS;

public interface AdvancedSetInterface<T>
{
    boolean add(T element);
    boolean contains(T element);
    boolean remove(T element);
    boolean isFull();
    boolean isEmpty();
    int size();
    T grab();
    void clear();
    String toString();
    T[] getArrayCopy();
    Node<T> getLLCopy();
    AdvancedSetInterface<T> union(AdvancedSetInterface<T> set);
    AdvancedSetInterface<T> intersection(AdvancedSetInterface<T> set);
    AdvancedSetInterface<T> complement(AdvancedSetInterface<T> set);
}
