package AS;

import java.util.Comparator;
import java.util.Random;

public class AdvancedSetLinkedList<T> implements AdvancedSetInterface<T>
{
    private Node<T> head;
    private Node<T> parser;
    private int totalNodes = 0;
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public AdvancedSetLinkedList()
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
     * add Adds an element to the linked list in sorted order if the element is unique.
     * @param element The data for the new node to hold.
     * @return True if the new node is successfully added, false otherwise.
     */
    public boolean add(T element)
    {
        if(contains(element))
        {
            return false;
        }
        Node<T> node = new Node<>(element);
        if(totalNodes == 0)
        {
            head = node;
        }
        else
        {
            parser = head;
            while(parser != null)
            {
                if(comp.compare(node.getData(), head.getData()) >= 0 && parser == head)
                {
                    node.setNext(head);
                    head = node;
                    break;
                }
                else if(comp.compare(node.getData(), parser.getData()) <= 0 && parser.getNext() == null)
                {
                    parser.setNext(node);
                    break;
                }
                else if(comp.compare(node.getData(), parser.getData()) < 0 &&
                        comp.compare(node.getData(), parser.getData()) >= 0)
                {
                    Node<T> helper = parser.getNext();
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
    public boolean contains(T element)
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
    public boolean remove(T element)
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
    public T grab()
    {
        if(totalNodes == 0)
        {
            return null;
        }
        int pick = random.nextInt(totalNodes);
        int tracker = 0;
        parser = head;
        T grabbedItem = null;
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
        StringBuilder str = new StringBuilder("[");
        parser = head;
        while(parser != null)
        {
            if(parser.getNext() != null)
            {
                str.append(parser.getData()).append(" ");
            }
            else
            {
                str.append(parser.getData());
            }
            parser = parser.getNext();
        }
        return str.append("]").toString();
    }

    /**
     * getArrayCopy A copy constructor providing access to a copy of the internal elements array.
     * @return A copy of the internal elements array.
     */
    public T[] getArrayCopy()
    {
        return null;
    }

    /**
     * getLLCopy A copy constructor providing access to a copy of the internal elements linked list.
     * @return A copy of the internal elements linked list.
     */
    public Node<T> getLLCopy()
    {
        Node<T> copyHead = new Node<>(head.getData());
        Node<T> parser = head, copyParser = copyHead;
        if(parser.getNext() != null)
        {
            parser = parser.getNext();
            while(parser != null)
            {
                copyParser.setNext(new Node<>(parser.getData()));
                copyParser = copyHead.getNext();
                parser = parser.getNext();
            }
        }
        return copyHead;
    }

    /**
     * union The union method creates a set that contains all unique elements in the current set and parameter set.
     * @param set The second set.
     * @return The union set.
     */
    public AdvancedSetInterface<T> union(AdvancedSetInterface<T> set)
    {
        AdvancedSetInterface<T> union = new AdvancedSetLinkedList<>();
        Node<T> parser = head;
        while(parser != null)
        {
            union.add(parser.getData());
            parser = parser.getNext();
        }
        parser = set.getLLCopy();
        while(parser != null)
        {
            union.add(parser.getData());
            parser = parser.getNext();
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
        AdvancedSetInterface<T> intersection = new AdvancedSetLinkedList<>();
        Node<T> parser = head;
        while(parser != null)
        {
            if(set.contains(parser.getData()))
            {
                intersection.add(parser.getData());
            }
            parser = parser.getNext();
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
        AdvancedSetInterface<T> complement = new AdvancedSetLinkedList<>();
        Node<T> parser = head;
        while(parser != null)
        {
            if(!set.contains(parser.getData()))
            {
                complement.add(parser.getData());
            }
            parser = parser.getNext();
        }
        return complement;
    }
}
