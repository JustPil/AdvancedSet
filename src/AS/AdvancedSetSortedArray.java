package AS;

import java.util.Comparator;
import java.util.Random;

public class AdvancedSetSortedArray<T> implements AdvancedSetInterface<T>
{
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private T[] array = (T[])new Object[CAPACITY];
    private Random random = new Random();
    private int foundPosition;
    private int insertPosition;
    private boolean finder;
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public AdvancedSetSortedArray()
    {
        comp = new Comparator<T>()
        {
            public int compare(T o1, T o2)
            {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * binarySeach A binary search algorithm that finds the index of an element if contained in the array, or the
     * index that the element should be inserted if not present.
     * @param element The element to search in the array.
     */
    private void binarySearch(T element)
    {
        finder = false;
        int start = 0;
        int end = totalItems - 1;
        foundPosition = -1;
        while(!finder && start <= end)
        {
            int mid = start + (end - start) / 2;
            if(comp.compare(array[mid], element) == 0)
            {
                finder = true;
                foundPosition = mid;
                return;
            }
            else if(comp.compare(array[mid], element) < 0)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        insertPosition = start;
    }

    /**
     * add Adds an element to the array if the array is not full and the element is a unique value.
     * @param element The element to add into the array.
     * @return True if the item is added, false if not.
     */
    public boolean add(T element)
    {
        if(totalItems == 0)
        {
            array[0] = element;
        }
        else if(isFull())
        {
            return false;
        }
        else
        {
            binarySearch(element);
            if(finder)
            {
                return false;
            }
            for(int i = totalItems - 1; i >= insertPosition; i--)
            {
                array[i + 1] = array[i];
            }
            array[insertPosition] = element;
        }
        totalItems++;
        return true;
    }

    /**
     * contains Searches the array for an element.
     * @param element The element to search for in the array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(T element)
    {
        binarySearch(element);
        return finder;
    }

    /**
     * remove Removes a specified element from the array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(T element)
    {
        binarySearch(element);
        if(!finder)
        {
            return false;
        }
        else
        {
            boolean removeOnce = false;
            T[] newArray = (T[])new Object[CAPACITY];
            for(int i = 0; i < totalItems; i++)
            {
                if(comp.compare(array[i], element) == 0 && !removeOnce)
                {
                    removeOnce = true;
                }
                else if(!removeOnce)
                {
                    newArray[i] = array[i];
                }
                else
                {
                    newArray[i - 1] = array[i];
                }
            }
            array = newArray;
            totalItems--;
        }
        return true;
    }

    /**
     * isFull Determines if the array is full.
     * @return True if the array is full, false otherwise.
     */
    public boolean isFull()
    {
        return totalItems == CAPACITY;
    }

    /**
     * isEmpty Determines if the array is empty.
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return totalItems == 0;
    }

    /**
     * size Determines the number of elements in the array.
     * @return The number of elements in the array.
     */
    public int size()
    {
        return totalItems;
    }

    /**
     * grab Grabs a random element from the array.
     * @return The randomly chosen element.
     */
    public T grab()
    {
        return totalItems == 0 ? null : array[random.nextInt(totalItems)];
    }

    /**
     * clear Clears the array of all elements.
     */
    public void clear()
    {
        array = (T[])new Object[CAPACITY];
        totalItems = 0;
    }

    /**
     * toString Outputs contents of the array in a String.
     * @return A String containing the output of the array elements.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < totalItems; i++)
        {
            str.append(array[i]);
            str.append(i != totalItems - 1 ? " " : "");
        }
        return str.append("]").toString();
    }

    /**
     * getArrayCopy A copy constructor providing access to a copy of the internal elements array.
     * @return A copy of the internal elements array.
     */
    public T[] getArrayCopy()
    {
        return array.clone();
    }

    /**
     * getLLCopy A copy constructor providing access to a copy of the internal elements linked list.
     * @return A copy of the internal elements linked list.
     */
    public Node<T> getLLCopy()
    {
        return null;
    }

    /**
     * union The union method creates a set that contains all unique elements in the current set and parameter set.
     * @param set The second set.
     * @return The union set.
     */
    public AdvancedSetInterface<T> union(AdvancedSetInterface<T> set)
    {
        AdvancedSetInterface<T> union = new AdvancedSetSortedArray<>();
        for(int i = 0; i < this.size(); i++)
        {
            union.add(array[i]);
        }
        for(int i = 0; i < set.size(); i++)
        {
            union.add(set.getArrayCopy()[i]);
        }
        return union;
    }

    /**
     * intersection The intersection method creates a set that contains all elements common to the current set and
     * the parameter set.
     * @param set The second set.
     * @return The intersection set.
     */
    public AdvancedSetInterface<T> intersection(AdvancedSetInterface<T> set)
    {
        AdvancedSetInterface<T> intersection = new AdvancedSetSortedArray<>();
        int minLength = Math.min(this.size(), set.size());
        for(int i = 0; i < minLength; i++)
        {
            if(set.contains(array[i]))
            {
                intersection.add(array[i]);
            }
        }
        return intersection;
    }

    /**
     * complement The complement method creates a set that contains all elements in the current set but not in the
     * parameter set.
     * @param set The second set.
     * @return The relative complement set.
     */
    public AdvancedSetInterface<T> complement(AdvancedSetInterface<T> set)
    {
        AdvancedSetInterface<T> complement = new AdvancedSetSortedArray<>();
        int minLength = Math.min(this.size(), set.size());
        for(int i = 0; i < minLength; i++)
        {
            if(!set.contains(array[i]))
            {
                complement.add(array[i]);
            }
        }
        return complement;
    }
}
