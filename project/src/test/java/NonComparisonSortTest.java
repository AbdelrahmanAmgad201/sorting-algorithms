import org.example.strategies.NonComparisonSort;
import org.example.strategies.SortingStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NonComparisonSortTest {

    void runTest(int[] input, int[] expected) {
        SortingStrategy sorter = NonComparisonSort.getInstance();

        long startTime = System.nanoTime();
        List<int[]> steps = sorter.sort(input.clone());
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Sorting execution time: " + duration / 1000 + " µs");

        assertNotNull(steps);
        assertFalse(steps.isEmpty());
        assertArrayEquals(expected, steps.get(steps.size() - 1));
    }

    @Test
    void testSmallNumbers() {
        runTest(new int[]{5, 3, 8, 1, 2}, new int[]{1, 2, 3, 5, 8});
    }

    @Test
    void testNegativeNumbers() {
        runTest(new int[]{-5, -10, -3, -1, -7}, new int[]{-10, -7, -5, -3, -1});
    }

    @Test
    void testMixedPositiveAndNegative() {
        runTest(new int[]{3, -2, -8, 10, 5}, new int[]{-8, -2, 3, 5, 10});
    }

    @Test
    void testDuplicates() {
        runTest(new int[]{5, 3, 8, 3, 2, 8, 1}, new int[]{1, 2, 3, 3, 5, 8, 8});
    }

    @Test
    void testSingleElement() {
        runTest(new int[]{42}, new int[]{42});
    }

    @Test
    void testAlreadySortedArray() {
        runTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    void testReversedArray() {
        runTest(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    void testLargeNumbers() {
        runTest(new int[]{9999, 10000, 5000, 7500, 2500}, new int[]{2500, 5000, 7500, 9999, 10000});
    }

    @Test
    void testCountingSortEfficiency() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9};
        int[] expected = input.clone();
        java.util.Arrays.sort(expected);
        runTest(input, expected);
    }

    @Test
    void testRadixSortEfficiency() {
        int[] input = {523112, 12987, 875342, 340876, 999124, 124876, 754643, 643987, 21876, 432543, 876234, 34298, 298765, 76123, 543321, 90876, 123432, 887543, 1000765, 654876, 234543, 876999, 98321, 321678, 765876, 567432, 432876, 345123, 987654, 21987, 134987, 876543, 345876, 789432, 456321, 234987, 678765, 567123, 123876, 987543, 345654};
        int[] expected = input.clone();
        java.util.Arrays.sort(expected);
        runTest(input, expected);
    }
}
