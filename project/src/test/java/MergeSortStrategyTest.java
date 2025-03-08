
import org.example.strategies.MergeSortStrategy;
import org.example.strategies.SortingStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortStrategyTest {
    @Test
    void testMergeSortWithTime() {
        SortingStrategy mergeSort = new MergeSortStrategy();
        int[] input = {5, 3, 8, 1, 2};

        long startTime = System.nanoTime();  // Start time
        List<int[]> steps = mergeSort.sort(input.clone());
        long endTime = System.nanoTime();  // End time

        long duration = endTime - startTime;  // Time in nanoseconds
        double durationMs = duration / 1_000_000.0;  // Convert to milliseconds

        assertNotNull(steps);
        assertFalse(steps.isEmpty());

        int[] sortedArray = steps.get(steps.size() - 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, sortedArray);

        System.out.println("MergeSort Execution Time: " + durationMs + " ms");
    }
}
