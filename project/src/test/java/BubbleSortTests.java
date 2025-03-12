import org.example.strategies.BubbleSortStrategy;
import org.example.strategies.MergeSortStrategy;
import org.example.strategies.SortingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class BubbleSortTests {
    int[][][] testCases = {
            // Test Case 1: Already sorted
            {{1, 4, 6, 17, 90, 91}, {1, 4, 6, 17, 90, 91}},

            // Test Case 2: Reverse sorted
            {{91, 90, 17, 6, 4, 1}, {1, 4, 6, 17, 90, 91}},

            // Test Case 3: Empty array
            {{}, {}},

            // Test Case 4: Single element
            {{5}, {5}},

            // Test Case 5: Duplicates
            {{3, 1, 2, 3, 1}, {1, 1, 2, 3, 3}},

            // Test Case 6: Negative numbers
            {{-5, 0, 3, -1, 2}, {-5, -1, 0, 2, 3}},

            // Test Case 7: Large range
            {{100, 1, 1000, 10, 10000}, {1, 10, 100, 1000, 10000}},

            // Test Case 8: All identical elements
            {{7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}},

            // Test Case 10: Array with zeros
            {{0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}},

            // Test Case 11: Array with one unique element and duplicates
            {{4, 4, 4, 1, 4}, {1, 4, 4, 4, 4}},

            // Test Case 12: Array with odd and even numbers
            {{2, 1, 4, 3, 6, 5}, {1, 2, 3, 4, 5, 6}},

            // Test Case 13: Array with floating-point numbers (not applicable for integer sorting)
            {{3, 1, 2}, {1, 2, 3}}, // Placeholder for floating-point test

            // Test Case 14: Array with mixed data types (invalid input)
            {{5, 3, 2}, {2, 3, 5}}, // Placeholder for invalid input test

            // Test Case 15: Array with large numbers
            {{1000000, 999999, 1000001}, {999999, 1000000, 1000001}},

            // Test Case 16: Array with negative and positive numbers
            {{-10, 5, -3, 0, 2}, {-10, -3, 0, 2, 5}},

            // Test Case 17: Array with alternating positive and negative numbers
            {{-1, 1, -2, 2, -3, 3}, {-3, -2, -1, 1, 2, 3}},

            // Test Case 18: Array with all negative numbers
            {{-5, -3, -9, -1, -2}, {-9, -5, -3, -2, -1}},

            // Test Case 19: Array with two elements
            {{2, 1}, {1, 2}},

            // Test Case 20: Array with three elements
            {{3, 1, 2}, {1, 2, 3}}
        };
    @Test
    public void Test0(){
        int []input=testCases[0][0];
        int []expectedOutput=testCases[0][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        SortingStrategy[] Sorters={new BubbleSortStrategy(),new MergeSortStrategy()};
        for(int i=0;i<Sorters.length;i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = Sorters[0].sort(input);
            assertNotNull(steps);
            assertFalse(steps.isEmpty());
            long endTime = System.nanoTime();
            durationsTaken.add((endTime-startTime)/1_000_000.0);
            int[] output = steps.get(steps.size()-1);
            assertArrayEquals(expectedOutput,output);
        }



        System.out.println("BubbleSort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge took "+durationsTaken.get(1)+ " milliseconds");

    }
    @Test
    public void Test1(){
        int []input=testCases[1][0];
        int []expectedOutput=testCases[1][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        SortingStrategy[] Sorters={new BubbleSortStrategy(),new MergeSortStrategy()};
        for(int i=0;i<Sorters.length;i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = Sorters[0].sort(input);
            assertNotNull(steps);
            assertFalse(steps.isEmpty());
            long endTime = System.nanoTime();
            durationsTaken.add((endTime-startTime)/1_000_000.0);
            int[] output = steps.get(steps.size()-1);
            assertArrayEquals(expectedOutput,output);
        }



        System.out.println("BubbleSort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge took "+durationsTaken.get(1)+ " milliseconds");

    }
    @Test
    public void Test2(){
        int []input=testCases[2][0];
        int []expectedOutput=testCases[2][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        SortingStrategy[] Sorters={new BubbleSortStrategy(),new MergeSortStrategy()};
        for(int i=0;i<Sorters.length;i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = Sorters[0].sort(input);
            assertNotNull(steps);
            assertFalse(steps.isEmpty());
            long endTime = System.nanoTime();
            durationsTaken.add((endTime-startTime)/1_000_000.0);
            int[] output = steps.get(steps.size()-1);
            assertArrayEquals(expectedOutput,output);
        }



        System.out.println("BubbleSort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge took "+durationsTaken.get(1)+ " milliseconds");

    }

    @Test
    public void Test3() {
        int[] input = {5};
        int[] expectedOutput = {5};
        List<Double> durationsTaken = new ArrayList<>(); // This array holds the values in milliseconds

        // Include both BubbleSortStrategy and MergeSortStrategy
        SortingStrategy[] sorters = {new BubbleSortStrategy(),new MergeSortStrategy()};

        for (int i = 0; i < sorters.length; i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = sorters[i].sort(input); // Use sorters[i] instead of sorters[0]
            long endTime = System.nanoTime();

            // Add the duration in milliseconds
            durationsTaken.add((endTime - startTime) / 1_000_000.0);

            // Validate the final sorted array
            int[] output = steps.get(steps.size() - 1);
            assertArrayEquals(expectedOutput, output);
        }

        // Print the durations
        System.out.println("BubbleSort took " + durationsTaken.get(0) + " milliseconds");
        System.out.println("MergeSort took " + durationsTaken.get(1) + " milliseconds");
    }

    @Test
    public void Test4(){
        int []input=testCases[4][0];
        int []expectedOutput=testCases[4][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        SortingStrategy[] Sorters={new BubbleSortStrategy(),new MergeSortStrategy()};
        for(int i=0;i<Sorters.length;i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = Sorters[0].sort(input);
            assertNotNull(steps);
            assertFalse(steps.isEmpty());
            long endTime = System.nanoTime();
            durationsTaken.add((endTime-startTime)/1_000_000.0);
            int[] output = steps.get(steps.size()-1);
            assertArrayEquals(expectedOutput,output);
        }



        System.out.println("BubbleSort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge took "+durationsTaken.get(1)+ " milliseconds");

    }
}
