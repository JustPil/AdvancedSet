package sets;

import nodes.Node;

import java.util.Comparator;
import java.util.Random;

public class AdvancedSetUnsortedArray<T> implements AdvancedSetInterface<T> {
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private T[] array = (T[])new Object[CAPACITY];
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public AdvancedSetUnsortedArray() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }
    /**
     * add Adds an element to the Set's internal array if the array is not full and the element is a unique value.
     * @param element The element to add into the Set's internal array.
     * @return True if the item is added, false if not.
     */
    public boolean add(T element) {
        if(isFull()) {
            return false;
        }
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0)
            {
                return false;
            }
        }
        array[totalItems] = element;
        totalItems++;
        return true;
    }

    /**
     * contains Searches the Set's internal array for an element.
     * @param element The element to search for in the Set's internal array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(T element) {
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * remove Removes a specified element from the Set's internal array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(T element) {
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0) {
                array[i] = array[totalItems - 1];
                array[totalItems - 1] = null;
                totalItems--;
                return true;
            }
        }
        return false;
    }

    /**
     * isFull Determines if the Set is full.
     * @return True if the Set is full, false otherwise.
     */
    public boolean isFull() {
        return totalItems == CAPACITY;
    }

    /**
     * isEmpty Determines if the Set is empty.
     * @return True if the Set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return totalItems == 0;
    }

    /**
     * size Determines the number of elements in the Set.
     * @return The number of elements in the Set.
     */
    public int size() {
        return totalItems;
    }

    /**
     * grab Grabs a random element from the Set.
     * @return The randomly chosen element.
     */
    public T grab() {
        return totalItems == 0 ? null : array[random.nextInt(totalItems)];
    }

    /**
     * clear Clears the Set of all elements.
     */
    public void clear() {
        array = (T[])new Object[CAPACITY];
        totalItems = 0;
    }

    /**
     * toString Outputs contents of the Set in a String.
     * @return A String containing the output of the Set elements.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < totalItems; i++) {
            str.append(array[i]);
            str.append(i != totalItems - 1 ? " " : "");
        }
        return str.append("]").toString();
    }

    /**
     * getArrayCopy A copy constructor providing access to a copy of the internal elements array.
     * @return A copy of the internal elements array.
     */
    public T[] getArrayCopy() {
        return array.clone();
    }

    /**
     * getLLCopy A copy constructor providing access to a copy of the internal elements linked list.
     * @return A copy of the internal elements linked list.
     */
    public Node<T> getLLCopy() {
        return null;
    }

    /**
     * union The union method creates a Set that contains all unique elements in the current Set and parameter s\Set.
     * @param set The second Set.
     * @return The union Set.
     */
    public AdvancedSetInterface<T> union(AdvancedSetInterface<T> set) {
        AdvancedSetInterface<T> union = new AdvancedSetUnsortedArray<>();
        for(int i = 0; i < this.size(); i++) {
            union.add(array[i]);
        }
        for(int i = 0; i < set.size(); i++) {
            union.add(set.getArrayCopy()[i]);
        }
        return union;
    }

    /**
     * intersection The intersection method creates a Set that contains all elements common to the current Set and
     * the parameter Set.
     * @param set The second Set.
     * @return The intersection Set.
     */
    public AdvancedSetInterface<T> intersection(AdvancedSetInterface<T> set) {
        AdvancedSetInterface<T> intersection = new AdvancedSetUnsortedArray<>();
        int minLength = Math.min(this.size(), set.size());
        for(int i = 0; i < minLength; i++) {
            if(set.contains(array[i])) {
                intersection.add(array[i]);
            }
        }
        return intersection;
    }

    /**
     * complement The complement method creates a Set that contains all elements in the current Set but not in the
     * parameter Set.
     * @param set The second Set.
     * @return The relative complement Set.
     */
    public AdvancedSetInterface<T> complement(AdvancedSetInterface<T> set) {
        AdvancedSetInterface<T> complement = new AdvancedSetUnsortedArray<>();
        int minLength = Math.min(this.size(), set.size());
        for(int i = 0; i < minLength; i++) {
            if(!set.contains(array[i])) {
                complement.add(array[i]);
            }
        }
        return complement;
    }
}
