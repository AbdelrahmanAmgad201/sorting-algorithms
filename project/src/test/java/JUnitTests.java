import org.example.strategies.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class JUnitTests {
    SortingStrategy[] Sorters={new BubbleSortStrategy(),new MergeSortStrategy(),new QuickSortStrategy(),NonComparisonSort.getInstance()};
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

            // Test Case 9: Array with zeros
            {{0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}},

            // Test Case 10: Array with one unique element and duplicates
            {{4, 4, 4, 1, 4}, {1, 4, 4, 4, 4}},

            // Test Case 11: Array with odd and even numbers
            {{2, 1, 4, 3, 6, 5}, {1, 2, 3, 4, 5, 6}},

            // Test Case 12: Array with floating-point numbers (not applicable for integer sorting)
            {{3, 1, 2}, {1, 2, 3}}, // Placeholder for floating-point test

            // Test Case 13: Array with mixed data types (invalid input)
            {{5, 3, 2}, {2, 3, 5}}, // Placeholder for invalid input test

            // Test Case 14: Array with large numbers
            {{1000000, 999999, 1000001}, {999999, 1000000, 1000001}},

            // Test Case 15: Array with negative and positive numbers
            {{-10, 5, -3, 0, 2}, {-10, -3, 0, 2, 5}},

            // Test Case 16: Array with alternating positive and negative numbers
            {{-1, 1, -2, 2, -3, 3}, {-3, -2, -1, 1, 2, 3}},

            // Test Case 17: Array with all negative numbers
            {{-5, -3, -9, -1, -2}, {-9, -5, -3, -2, -1}},

            // Test Case 18: Array with two elements
            {{2, 1}, {1, 2}},

            // Test Case 19: Array with three elements
            {{3, 1, 2}, {1, 2, 3}}
    };

    void HelperFunction(int []input,int[]expectedOutput){
        List<Double> durationsTaken =new ArrayList<>();
        for(int i=0;i<Sorters.length;i++) {
            long startTime = System.nanoTime();
            List<int[]> steps = Sorters[i].sort(input);
            assertNotNull(steps);
            assertFalse(steps.isEmpty());
            long endTime = System.nanoTime();
            durationsTaken.add((endTime-startTime)/1_000_000.0);
            int[] output = steps.get(steps.size()-1);
            assertArrayEquals(expectedOutput,output);
        }
        System.out.println("Bubble Sort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge Sort took "+durationsTaken.get(1)+ " milliseconds");
        System.out.println("Quick took "+durationsTaken.get(2)+ " milliseconds");
        System.out.println("Non comparison sort took "+durationsTaken.get(3)+ " milliseconds");


    }
    @Test
    public void Test0() {
        // Test Case 0: Already sorted array
        // Input: [1, 4, 6, 17, 90, 91]
        // Expected Output: [1, 4, 6, 17, 90, 91]
        int[] input = testCases[0][0];
        int[] expectedOutput = testCases[0][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test1() {
        // Test Case 1: Reverse sorted array
        // Input: [91, 90, 17, 6, 4, 1]
        // Expected Output: [1, 4, 6, 17, 90, 91]
        int[] input = testCases[1][0];
        int[] expectedOutput = testCases[1][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test2() {
        // Test Case 2: Empty array
        // Input: []
        // Expected Output: []
        int[] input = testCases[2][0];
        int[] expectedOutput = testCases[2][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test3() {
        // Test Case 3: Single element array
        // Input: [5]
        // Expected Output: [5]
        int[] input = testCases[3][0];
        int[] expectedOutput = testCases[3][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test4() {
        // Test Case 4: Array with duplicate elements
        // Input: [3, 1, 2, 3, 1]
        // Expected Output: [1, 1, 2, 3, 3]
        int[] input = testCases[4][0];
        int[] expectedOutput = testCases[4][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test5() {
        // Test Case 5: Array with negative numbers
        // Input: [-5, 0, 3, -1, 2]
        // Expected Output: [-5, -1, 0, 2, 3]
        int[] input = testCases[5][0];
        int[] expectedOutput = testCases[5][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test6() {
        // Test Case 6: Array with a large range of numbers
        // Input: [100, 1, 1000, 10, 10000]
        // Expected Output: [1, 10, 100, 1000, 10000]
        int[] input = testCases[6][0];
        int[] expectedOutput = testCases[6][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test7() {
        // Test Case 7: Array with all identical elements
        // Input: [7, 7, 7, 7, 7]
        // Expected Output: [7, 7, 7, 7, 7]
        int[] input = testCases[7][0];
        int[] expectedOutput = testCases[7][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test8() {
        // Test Case 8: Array with zeros
        // Input: [0, 0, 0, 1, 0]
        // Expected Output: [0, 0, 0, 0, 1]
        int[] input = testCases[8][0];
        int[] expectedOutput = testCases[8][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test9() {
        // Test Case 9: Array with one unique element and duplicates
        // Input: [4, 4, 4, 1, 4]
        // Expected Output: [1, 4, 4, 4, 4]
        int[] input = testCases[9][0];
        int[] expectedOutput = testCases[9][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test10() {
        // Test Case 10: Array with odd and even numbers
        // Input: [2, 1, 4, 3, 6, 5]
        // Expected Output: [1, 2, 3, 4, 5, 6]
        int[] input = testCases[10][0];
        int[] expectedOutput = testCases[10][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test11() {
        // Test Case 11: Array with floating-point numbers (placeholder for integer sorting)
        // Input: [3, 1, 2]
        // Expected Output: [1, 2, 3]
        int[] input = testCases[11][0];
        int[] expectedOutput = testCases[11][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test12() {
        // Test Case 12: Array with mixed data types (invalid input placeholder)
        // Input: [5, 3, 2]
        // Expected Output: [2, 3, 5]
        int[] input = testCases[12][0];
        int[] expectedOutput = testCases[12][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test13() {
        // Test Case 13: Array with large numbers
        // Input: [1000000, 999999, 1000001]
        // Expected Output: [999999, 1000000, 1000001]
        int[] input = testCases[13][0];
        int[] expectedOutput = testCases[13][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test14() {
        // Test Case 14: Array with negative and positive numbers
        // Input: [-10, 5, -3, 0, 2]
        // Expected Output: [-10, -3, 0, 2, 5]
        int[] input = testCases[14][0];
        int[] expectedOutput = testCases[14][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test15() {
        // Test Case 15: Array with alternating positive and negative numbers
        // Input: [-1, 1, -2, 2, -3, 3]
        // Expected Output: [-3, -2, -1, 1, 2, 3]
        int[] input = testCases[15][0];
        int[] expectedOutput = testCases[15][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test16() {
        // Test Case 16: Array with all negative numbers
        // Input: [-5, -3, -9, -1, -2]
        // Expected Output: [-9, -5, -3, -2, -1]
        int[] input = testCases[16][0];
        int[] expectedOutput = testCases[16][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test17() {
        // Test Case 17: Array with two elements
        // Input: [2, 1]
        // Expected Output: [1, 2]
        int[] input = testCases[17][0];
        int[] expectedOutput = testCases[17][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test18() {
        // Test Case 18: Array with three elements
        // Input: [3, 1, 2]
        // Expected Output: [1, 2, 3]
        int[] input = testCases[18][0];
        int[] expectedOutput = testCases[18][1];
        HelperFunction(input, expectedOutput);
    }

    @Test
    public void Test19() {
        // Test Case 19: Large array with random elements
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9};
        int[] expected = input.clone();
        java.util.Arrays.sort(expected);
        HelperFunction(input, expected);
    }

    @Test
    public void Test20() {
        // Test Case 20: Large array with large numbers
        // Expected Output: Sorted version of the input array
        int[] input = {523112, 12987, 875342, 340876, 999124, 124876, 754643, 643987, 21876, 432543, 876234, 34298, 298765, 76123, 543321, 90876, 123432, 887543, 1000765, 654876, 234543, 876999, 98321, 321678, 765876, 567432, 432876, 345123, 987654, 21987, 134987, 876543, 345876, 789432, 456321, 234987, 678765, 567123, 123876, 987543, 345654};
        int[] expected = input.clone();
        java.util.Arrays.sort(expected);
        HelperFunction(input, expected);
    }

}
