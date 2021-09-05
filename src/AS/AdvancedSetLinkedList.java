package AS;

import java.util.Random;

public class AdvancedSetLinkedList implements AdvancedSetInterface
{
    private Node head;
    private Node parser;
    private int totalNodes = 0;
    Random random = new Random();

    /**
     * add Adds an element to the linked list in sorted order if the element is unique.
     * @param element The data for the new node to hold.
     * @return True if the new node is successfully added, false otherwise.
     */
    public boolean add(int element)
    {
        if(contains(element))
        {
            return false;
        }
        Node node = new Node(element);
        if(totalNodes == 0)
        {
            head = node;
        }
        else
        {
            parser = head;
            while(parser != null)
            {
                if(node.getData() <= head.getData() && parser == head)
                {
                    node.setNext(head);
                    head = node;
                    break;
                }
                else if(node.getData() >= parser.getData() && parser.getNext() == null)
                {
                    parser.setNext(node);
                    break;
                }
                else if(node.getData() > parser.getData() && node.getData() <= parser.getNext().getData())
                {
                    Node helper = parser.getNext();
                    parser.setNext(node);
                    node.setNext(helper);
                    break;
                }
                parser = parser.getNext();
            }
        }
        totalNodes++;
        return true;
    }

    /**
     * contains Searches the linked list for a Node containing the specified data.
     * @param element The data to search for.
     * @return True if a Node containing the data is found, false otherwise.
     */
    public boolean contains(int element)
    {
        parser = head;
        while(parser != null)
        {
            if(parser.getData() == element)
            {
                return true;
            }
            else
            {
                parser = parser.getNext();
            }
        }
        return false;
    }

    /**
     * remove Removes a Node from the linked list if holding the specified element.
     * @param element The data to search for.
     * @return True if the Node is found and removed, false otherwise.
     */
    public boolean remove(int element)
    {
        parser = head;
        while(parser.getNext() != null)
        {
            if(parser.getNext().getData() == element && parser != head)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            else if(head.getData() == element)
            {
                head = head.getNext();
                totalNodes--;
                return true;
            }
            else if(parser == head && parser.getNext().getData() == element && head.getData() != element)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            parser = parser.getNext();
        }
        if(totalNodes == 1 && head.getData() == element)
        {
            head = null;
            totalNodes--;
            return true;
        }
        return false;
    }

    /**
     * isFull Determines if the linked list is full.
     * @return False, a linked list is never full.
     */
    public boolean isFull()
    {
        return false;
    }

    /**
     * isEmpty Determines if the linked list is empty.
     * @return True if the linked list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return totalNodes == 0;
    }

    /**
     * size Determines the number of Nodes in the linked list.
     * @return The total Nodes contained in the linked list.
     */
    public int size()
    {
        return totalNodes;
    }

    /**
     * grab Grabs a random Node from the linked list.
     * @return The data contained in the randomly selected Node.
     */
    public int grab()
    {
        if(totalNodes == 0)
        {
            return 0;
        }
        int pick = random.nextInt(totalNodes);
        int tracker = 0;
        parser = head;
        int grabbedItem = 0;
        while(parser != null)
        {
            if(tracker == pick)
            {
                grabbedItem = parser.getData();
                break;
            }
            else
            {
                parser = parser.getNext();
                tracker++;
            }
        }
        return grabbedItem;
    }

    /**
     * clear Clears the linked list of all Nodes.
     */
    public void clear()
    {
        head = null;
        totalNodes = 0;
    }

    /**
     * toString Outputs the contents of the linked list to a String.
     * @return A String containing the sequential data held by the Nodes.
     */
    public String toString()
    {
        String str = "[";
        parser = head;
        while(parser != null)
        {
            String spacing = parser.getNext() == null ? "" : " ";
            str += parser.getData() + spacing;
            parser = parser.getNext();
        }
        return str + "]";
    }

    /**
     * union The union method creates a set that contains all unique elements in the current set and parameter set.
     * @param set The second set.
     * @return The union set.
     */
    public AdvancedSetInterface union(AdvancedSetInterface set)
    {
        AdvancedSetInterface union = new AdvancedSetLinkedList();
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
        AdvancedSetInterface intersection = new AdvancedSetLinkedList();
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
        AdvancedSetInterface complement = new AdvancedSetLinkedList();
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
