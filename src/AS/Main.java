package AS;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String choice = "";
        Scanner scn = new Scanner(System.in);
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("Advanced Set ADT Implementations\n1 = Sorted Set (Array)\n2 - Sorted Set (Linked " +
                    "List)\n3 - Unsorted Set (Array)\nX - Terminate\nEnter choice: ");
            choice = scn.nextLine();
            if(choice.equals("1"))
            {
                sortedSet(scn);
            }
            else if(choice.equals("2"))
            {
                sortedLinkedSet(scn);
            }
            else if(choice.equals("3"))
            {
                unsortedSet(scn);
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
        scn.close();
    }

    /**
     * sortedSet A Test Driver for the Set ADT implemented with a sorted Array.
     * @param s A Scanner object to relay user input.
     */
    public static void sortedSet(Scanner s)
    {
        AdvancedSetInterface set = new AdvancedSetSortedArray();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Sorted Set (Sorted Array Implementation)\n1 - ADD - Adds a unique element to" +
                    " the set\n2 - CONTAINS - Checks if an element is contained in the set\n3 - REMOVE - Removes a " +
                    "specified element from the set\n4 - IS FULL - Checks if the set is full\n5 - IS EMPTY - Checks" +
                    " if the set if empty\n6 - SIZE - Reports the number of elements in the set\n7 - GRAB - Grabs a " +
                    "random element from the set\n8 - CLEAR - Empties the set\n9 - TO STRING - Lists all elements " +
                    "contained in the set sequentially\n10 - UNION - Creates a set that is a union of all elements " +
                    "contained in two sets\n11 - INTERSECTION - Creates a set that is an intersection of all " +
                    "elements commone to two sets\n12 - COMPLEMENT - Creates a set that is a relative complement of " +
                    "two sets\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + set.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + set.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bad: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + set.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full set: " + set.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty set: " + set.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + set.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the set: " + set.grab());
            }
            else if(choice.equals("8"))
            {
                set.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("9"))
            {
                System.out.println(set.toString());
            }
            else if(choice.equals("10"))
            {
                System.out.println("To perform a UNION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetSortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface union = set.union(set2);
                System.out.println("Performing UNION of SET 1 and SET 2:\n" + union.toString());
            }
            else if(choice.equals("11"))
            {
                System.out.println("To perform an INTERSECTION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetSortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface intersection = set.intersection(set2);
                System.out.println("Performing INTERSECTION of SET 1 and SET 2:\n" + intersection.toString());
            }
            else if(choice.equals("12"))
            {
                System.out.println("To perform a COMPLEMENT operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetSortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface complement = set.complement(set2);
                System.out.println("Performing COMPLEMENT of SET 1 and SET 2:\n" + complement.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * sortedLinkedSet A Test Driver for the Set ADT implemented with a sorted Linked List.
     * @param s A Scanner object to relay user input.
     */
    public static void sortedLinkedSet(Scanner s)
    {
        AdvancedSetInterface set = new AdvancedSetLinkedList();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Sorted Set (Linked List Implementation)\n1 - ADD - Adds a unique element to" +
                    " the set\n2 - CONTAINS - Checks if an element is contained in the set\n3 - REMOVE - Removes a " +
                    "specified element from the set\n4 - IS FULL - Checks if the set is full\n5 - IS EMPTY - Checks" +
                    " if the set if empty\n6 - SIZE - Reports the number of elements in the set\n7 - GRAB - Grabs a " +
                    "random element from the set\n8 - CLEAR - Empties the set\n9 - TO STRING - Lists all elements " +
                    "contained in the set sequentially\n10 - UNION - Creates a set that is a union of all elements " +
                    "contained in two sets\n11 - INTERSECTION - Creates a set that is an intersection of all " +
                    "elements commone to two sets\n12 - COMPLEMENT - Creates a set that is a relative complement of " +
                    "two sets\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + set.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + set.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bad: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + set.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full set: " + set.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty set: " + set.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + set.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the set: " + set.grab());
            }
            else if(choice.equals("8"))
            {
                set.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("9"))
            {
                System.out.println(set.toString());
            }
            else if(choice.equals("10"))
            {
                System.out.println("To perform a UNION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetLinkedList();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface union = set.union(set2);
                System.out.println("Performing UNION of SET 1 and SET 2:\n" + union.toString());
            }
            else if(choice.equals("11"))
            {
                System.out.println("To perform an INTERSECTION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetLinkedList();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface intersection = set.intersection(set2);
                System.out.println("Performing INTERSECTION of SET 1 and SET 2:\n" + intersection.toString());
            }
            else if(choice.equals("12"))
            {
                System.out.println("To perform a COMPLEMENT operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetLinkedList();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface complement = set.complement(set2);
                System.out.println("Performing COMPLEMENT of SET 1 and SET 2:\n" + complement.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * unsortedSet A Test Driver for the Set ADT implemented with an unsorted Array.
     * @param s A Scanner object to relay user input.
     */
    public static void unsortedSet(Scanner s)
    {
        AdvancedSetInterface set = new AdvancedSetUnsortedArray();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Sorted Set (Unsorted Array Implementation)\n1 - ADD - Adds a unique element to" +
                    " the set\n2 - CONTAINS - Checks if an element is contained in the set\n3 - REMOVE - Removes a " +
                    "specified element from the set\n4 - IS FULL - Checks if the set is full\n5 - IS EMPTY - Checks" +
                    " if the set if empty\n6 - SIZE - Reports the number of elements in the set\n7 - GRAB - Grabs a " +
                    "random element from the set\n8 - CLEAR - Empties the set\n9 - TO STRING - Lists all elements " +
                    "contained in the set sequentially\n10 - UNION - Creates a set that is a union of all elements " +
                    "contained in two sets\n11 - INTERSECTION - Creates a set that is an intersection of all " +
                    "elements commone to two sets\n12 - COMPLEMENT - Creates a set that is a relative complement of " +
                    "two sets\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + set.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the set: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + set.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bad: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + set.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full set: " + set.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty set: " + set.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + set.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the set: " + set.grab());
            }
            else if(choice.equals("8"))
            {
                set.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("9"))
            {
                System.out.println(set.toString());
            }
            else if(choice.equals("10"))
            {
                System.out.println("To perform a UNION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetUnsortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface union = set.union(set2);
                System.out.println("Performing UNION of SET 1 and SET 2:\n" + union.toString());
            }
            else if(choice.equals("11"))
            {
                System.out.println("To perform an INTERSECTION operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetUnsortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface intersection = set.intersection(set2);
                System.out.println("Performing INTERSECTION of SET 1 and SET 2:\n" + intersection.toString());
            }
            else if(choice.equals("12"))
            {
                System.out.println("To perform a COMPLEMENT operation we require two sets. Creating SET 2...");
                AdvancedSetInterface set2 = new AdvancedSetUnsortedArray();
                String input = "";
                while(!input.equalsIgnoreCase("X"))
                {
                    System.out.print("Enter values to add to SET 2: ");
                    input = s.nextLine();
                    set2.add(Integer.parseInt(input));
                    System.out.println("Continue [C] or Stop [X] ?");
                    input = s.nextLine();
                }
                AdvancedSetInterface complement = set.complement(set2);
                System.out.println("Performing COMPLEMENT of SET 1 and SET 2:\n" + complement.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}
