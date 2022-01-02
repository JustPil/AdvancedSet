package AS;

import java.util.Random;

public class AdvancedSetUnsortedArray implements AdvancedSetInterface
{
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private int[] array = new int[CAPACITY];
    private Random random = new Random();

    /**
     * add Adds an element to the array if the array is not full and the element is a unique value.
     * @param element The element to add into the array.
     * @return True if the item is added, false if not.
     */
    public boolean add(int element)
    {
        if(isFull())
        {
            return false;
        }
        for(int i = 0; i < totalItems; i++)
        {
            if(array[i] == element)
            {
                return false;
            }
        }
        array[totalItems] = element;
        totalItems++;
        return true;
    }

    /**
     * contains Searches the array for an element.
     * @param element The element to search for in the array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(int element)
    {
        for(int i = 0; i < totalItems; i++)
        {
            if(array[i] == element)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * remove Removes a specified element from the array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(int element)
    {
        for(int i = 0; i < totalItems; i++)
        {
            if(array[i] == element)
            {
                array[i] = array[totalItems - 1];
                array[totalItems - 1] = 0;
                totalItems--;
                return true;
            }
        }
        return false;
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
    public int grab()
    {
        if(totalItems == 0)
        {
            return 0;
        }
        int pick = random.nextInt(totalItems);
        return array[pick];
    }

    /**
     * clear Clears the array of all elements.
     */
    public void clear()
    {
        array = new int[CAPACITY];
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
     * union The union method creates a set that contains all unique elements in the current set and parameter set.
     * @param set The second set.
     * @return The union set.
     */
    public AdvancedSetInterface union(AdvancedSetInterface set)
    {
        AdvancedSetInterface union = new AdvancedSetUnsortedArray();
        String str1 = this.toString();
        String str2 = set.toString();
        str1 = str1.replace("[", "");
        str1 = str1.replace("]", "");
        str2 = str2.replace("[", "");
        str2 = str2.replace("]", "");
        String[] split1 = str1.split(" ");
        int[] arr1 = new int[split1.length];
        String[] split2 = str2.split(" ");
        int[] arr2 = new int[split2.length];
        for(int i = 0; i < split1.length; i++)
        {
            arr1[i] = Integer.parseInt(split1[i]);
        }
        for(int i = 0; i < split2.length; i++)
        {
            arr2[i] = Integer.parseInt(split2[i]);
        }
        for(int i : arr1)
        {
            union.add(i);
        }
        for(int i : arr2)
        {
            union.add(i);
        }
        return union;
    }

    /**
     * intersection The intersection method creates a set that contains all elements common to the current set and
     * the parameter set.
     * @param set The second set.
     * @return The intersection set.
     */
    public AdvancedSetInterface intersection(AdvancedSetInterface set)
    {
        AdvancedSetInterface intersection = new AdvancedSetUnsortedArray();
        String str1 = this.toString();
        str1 = str1.replace("[", "");
        str1 = str1.replace("]", "");
        String[] split1 = str1.split(" ");
        int[] arr1 = new int[split1.length];
        for(int i = 0; i < split1.length; i++)
        {
            arr1[i] = Integer.parseInt(split1[i]);
        }
        for(int i : arr1)
        {
            if (set.contains(i))
            {
                intersection.add(i);
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
    public AdvancedSetInterface complement(AdvancedSetInterface set)
    {
        AdvancedSetInterface complement = new AdvancedSetUnsortedArray();
        String str1 = this.toString();
        str1 = str1.replace("[", "");
        str1 = str1.replace("]", "");
        String[] split1 = str1.split(" ");
        int[] arr1 = new int[split1.length];
        for(int i = 0; i < split1.length; i++)
        {
            arr1[i] = Integer.parseInt(split1[i]);
        }
        for(int i : arr1)
        {
            if(!set.contains(i))
            {
                complement.add(i);
            }
        }
        return complement;
    }
}
