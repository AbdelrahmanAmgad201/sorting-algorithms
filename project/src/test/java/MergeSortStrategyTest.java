import org.example.strategies.MergeSortStrategy;
import org.example.strategies.SortingStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortStrategyTest {

    @Test
    void testMergeSortWithSingleElement() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {100};

        long startTime = System.nanoTime();
        List<int[]> steps = mergeSort.sort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        double durationMs = duration / 1_000_000.0;

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{100}, sortedArray);

        System.out.println("MergeSort Execution Time (Single Element): " + durationMs + " ms");
    }

    @Test
    void testMergeSortWithMultipleElements() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {5, 3, 8, 1, 2};

        List<int[]> steps = mergeSort.sort(input);

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, sortedArray);
    }

    @Test
    void testMergeSortWithSortedArray() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {1, 2, 3, 4, 5};

        List<int[]> steps = mergeSort.sort(input);

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray);
    }

    @Test
    void testMergeSortWithReverseSortedArray() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {9, 7, 5, 3, 1};

        List<int[]> steps = mergeSort.sort(input);

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, sortedArray);
    }

    @Test
    void testMergeSortWithDuplicates() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {4, 2, 2, 4, 1};

        List<int[]> steps = mergeSort.sort(input);

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, sortedArray);
    }

    @Test
    void testMergeSortWithEmptyArray() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {};

        List<int[]> steps = mergeSort.sort(input);

        assertNotNull(steps);
        assertTrue(steps.isEmpty() || steps.get(steps.size() - 1).length == 0);
    }
}
