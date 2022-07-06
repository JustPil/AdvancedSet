package settests;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import sets.AdvancedSetInterface;
import sets.AdvancedSetUnsortedArray;

public class AdvancedSetUnsortedArrayTests {
    private final AdvancedSetInterface<Integer> set = new AdvancedSetUnsortedArray<>();

    @Test
    public void addInitialElement() {
        set.add(1);
        var result = set.size() == 1 && set.contains(1) && !set.isEmpty();
        Assertions.assertTrue(result);
    }
    @Test
    public void addSeveralElements() {
        for(int i = 0; i < 25; i++) {
            set.add(i);
        }
        var result = set.size();
        Assertions.assertEquals(25, result);
    }
    @Test
    public void removeElementResultingInEmptySet() {
        set.add(1);
        set.remove(1);
        var result = set.isEmpty() && set.size() == 0;
        Assertions.assertTrue(result);
    }
    @Test
    public void removeMiddleElementInNonEmptySet() {
        for(int i = 0; i < 3; i++) {
            set.add(i);
        }
        var result = set.remove(1) && !set.contains(1) && set.size() == 2;
        Assertions.assertTrue(result);
    }
    @Test
    public void removeFrontElementInNonEmptySet() {
        set.add(1);
        set.add(2);
        var result = set.remove(1) && !set.contains(1) && set.size() == 1;
        Assertions.assertTrue(result);
    }
    @Test
    public void removeRearElementInNonEmptySet() {
        set.add(1);
        set.add(2);
        var result = set.remove(2) && !set.contains(2) && set.size() == 1;
        Assertions.assertTrue(result);
    }
    @Test
    public void checkIfElementIsPresentInSet() {
        set.add(1);
        var result = set.contains(1);
        Assertions.assertTrue(result);
    }
    @Test
    public void checkIfElementIsPresentInEmptySet() {
        var result = set.contains(1);
        Assertions.assertFalse(result);
    }
    @Test
    public void checkIfWrongElementIsPresentInNonEmptySet() {
        for(int i = 0; i < 2; i++) {
            set.add(i);
        }
        var result = set.contains(5);
        Assertions.assertFalse(result);
    }
    @Test
    public void checkSizeAfterMultipleAdditionsAndRemovals() {
        for(int i = 0; i < 25; i++) {
            set.add(i);
        }
        for(int i = 0; i < 15; i++) {
            set.remove(i);
        }
        var result = set.size();
        Assertions.assertEquals(10, result);
    }
    @Test
    public void grabAnElementInPopulatedSet() {
        for(int i = 0; i < 15; i++) {
            set.add(i);
        }
        var result = set.grab();
        Assertions.assertNotNull(result);
    }
    @Test
    public void grabAnElementInEmptySet() {
        var result = set.grab();
        Assertions.assertNull(result);
    }
    @Test
    public void grabAnElementInSetOfSizeOne() {
        set.add(1);
        var result = set.grab();
        Assertions.assertEquals(1, result);
    }
    @Test
    public void clearSet() {
        for(int i = 0; i < 5; i++) {
            set.add(i);
        }
        set.clear();
        var result = set.isEmpty();
        Assertions.assertTrue(result);
    }
    @Test
    public void getAllElementsAsString() {
        for(int i = 0; i < 5; i++) {
            set.add(i + 1);
        }
        var result = set.toString();
        Assertions.assertEquals("[1 2 3 4 5]", result);
    }
    @Test
    public void getAllElementsAsStringInEmptySet() {
        var result = set.toString();
        Assertions.assertEquals("[]", result);
    }
    @Test
    public void performUnionOfSetsWithDistinctElements() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(2);
        AdvancedSetInterface<Integer> unionSet = set.union(tempSet);
        var result = unionSet.contains(1) && unionSet.contains(2);
        Assertions.assertTrue(result);
    }
    @Test
    public void performUnionOfSetsWithDuplicateElements() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(1);
        AdvancedSetInterface<Integer> unionSet = set.union(tempSet);
        var result = unionSet.size();
        Assertions.assertEquals(1, result);
    }
    @Test
    public void performIntersectionOfSetsWithDistinctElements() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(2);
        AdvancedSetInterface<Integer> intersectionSet = set.intersection(tempSet);
        var result = intersectionSet.size();
        Assertions.assertEquals(0, result);
    }
    @Test
    public void performIntersectionOfSetsWithDuplicateElements() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(1);
        AdvancedSetInterface<Integer> intersectionSet = set.intersection(tempSet);
        var result = intersectionSet.size();
        Assertions.assertEquals(1, result);
    }
    @Test
    public void performComplementOfSets() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(2);
        AdvancedSetInterface<Integer> complementSet = set.complement(tempSet);
        var result = complementSet.size() == 1 && complementSet.contains(1);
        Assertions.assertTrue(result);
    }
    @Test
    public void performComplementOfSetsWithDuplicateElements() {
        set.add(1);
        AdvancedSetInterface<Integer> tempSet = new AdvancedSetUnsortedArray<>();
        tempSet.add(1);
        AdvancedSetInterface<Integer> complementSet = set.complement(tempSet);
        var result = complementSet.size() == 0 && !complementSet.contains(1) && complementSet.isEmpty();
        Assertions.assertTrue(result);
    }
}
