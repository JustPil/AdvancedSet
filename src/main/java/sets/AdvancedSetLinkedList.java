package sets;

import nodes.Node;

import java.util.Comparator;
import java.util.Random;

public class AdvancedSetLinkedList<T> implements AdvancedSetInterface<T> {
    private Node<T> head;
    private Node<T> parser;
    private int totalNodes = 0;
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public AdvancedSetLinkedList() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * add Adds an element to the Set's internal linked list in sorted order if the element is unique.
     * @param element The element to add.
     * @return True if the new element is successfully added, false otherwise.
     */
    public boolean add(T element) {
        if(contains(element)) {
            return false;
        }
        Node<T> node = new Node<>(element);
        if(totalNodes == 0) {
            head = node;
        } else {
            parser = head;
            while(parser != null) {
                if(comp.compare(node.getData(), head.getData()) >= 0 && parser == head) {
                    node.setNext(head);
                    head = node;
                    break;
                } else if(comp.compare(node.getData(), parser.getData()) <= 0 && parser.getNext() == null) {
                    parser.setNext(node);
                    break;
                } else if(comp.compare(node.getData(), parser.getData()) < 0 &&
                        comp.compare(node.getData(), parser.getData()) >= 0) {
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
     * contains Searches the Set's internal linked list for a Node containing the specified element.
     * @param element The element to search for.
     * @return True if the eleent is found, false otherwise.
     */
    public boolean contains(T element) {
        parser = head;
        while(parser != null) {
            if(parser.getData() == element) {
                return true;
            } else {
                parser = parser.getNext();
            }
        }
        return false;
    }

    /**
     * remove Removes an element from the Set's internal linked list is present.
     * @param element The element to remove.
     * @return True if the element is found and removed, false otherwise.
     */
    public boolean remove(T element) {
        parser = head;
        while(parser.getNext() != null) {
            if(parser.getNext().getData() == element && parser != head) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            } else if(head.getData() == element) {
                head = head.getNext();
                totalNodes--;
                return true;
            } else if(parser == head && parser.getNext().getData() == element && head.getData() != element) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            parser = parser.getNext();
        }
        if(totalNodes == 1 && head.getData() == element) {
            head = null;
            totalNodes--;
            return true;
        }
        return false;
    }

    /**
     * isFull Determines if the Set is full.
     * @return False, a Set implemented with a linked list is never full.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * isEmpty Determines if the Set is empty.
     * @return True if the Set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return totalNodes == 0;
    }

    /**
     * size Determines the number of elements in the Set.
     * @return The number of elements in the Set.
     */
    public int size() {
        return totalNodes;
    }

    /**
     * grab Grabs a pseudorandom element from the Set.
     * @return The randomly chosen element.
     */
    public T grab() {
        if(totalNodes == 0) {
            return null;
        }
        int pick = random.nextInt(totalNodes);
        int tracker = 0;
        parser = head;
        T grabbedItem = null;
        while(parser != null) {
            if(tracker == pick) {
                grabbedItem = parser.getData();
                break;
            } else {
                parser = parser.getNext();
                tracker++;
            }
        }
        return grabbedItem;
    }

    /**
     * clear Clears the Set of all elements.
     */
    public void clear() {
        head = null;
        totalNodes = 0;
    }

    /**
     * toString Outputs the contents of the Set to a String.
     * @return A String containing the elements in the Set.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        parser = head;
        while(parser != null) {
            if(parser.getNext() != null) {
                str.append(parser.getData()).append(" ");
            } else {
                str.append(parser.getData());
            }
            parser = parser.getNext();
        }
        return str.append("]").toString();
    }

    /**
     * getArrayCopy A copy constructor providing access to a copy of the internal elements array, if used.
     * @return A copy of the internal elements array.
     */
    public T[] getArrayCopy() {
        return null;
    }

    /**
     * getLLCopy A copy constructor providing access to a copy of the internal elements linked list, if used.
     * @return A copy of the internal elements linked list.
     */
    public Node<T> getLLCopy() {
        Node<T> copyHead = new Node<>(head.getData());
        parser = head;
        Node<T> copyParser = copyHead;
        if(parser.getNext() != null) {
            parser = parser.getNext();
            while(parser != null) {
                copyParser.setNext(new Node<>(parser.getData()));
                copyParser = copyHead.getNext();
                parser = parser.getNext();
            }
        }
        return copyHead;
    }

    /**
     * union The union method creates a set that contains all unique elements in the current Set and parameter Set.
     * @param set The second Set.
     * @return The union Set.
     */
    public AdvancedSetInterface<T> union(AdvancedSetInterface<T> set) {
        AdvancedSetInterface<T> union = new AdvancedSetLinkedList<>();
        parser = head;
        while(parser != null) {
            union.add(parser.getData());
            parser = parser.getNext();
        }
        parser = set.getLLCopy();
        while(parser != null) {
            union.add(parser.getData());
            parser = parser.getNext();
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
        AdvancedSetInterface<T> intersection = new AdvancedSetLinkedList<>();
        parser = head;
        while(parser != null) {
            if(set.contains(parser.getData())) {
                intersection.add(parser.getData());
            }
            parser = parser.getNext();
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
        AdvancedSetInterface<T> complement = new AdvancedSetLinkedList<>();
        parser = head;
        while(parser != null) {
            if(!set.contains(parser.getData())) {
                complement.add(parser.getData());
            }
            parser = parser.getNext();
        }
        return complement;
    }
}
