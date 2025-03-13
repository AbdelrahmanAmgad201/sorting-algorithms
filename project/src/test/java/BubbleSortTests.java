import org.example.strategies.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class BubbleSortTests {
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

    void HelperFunction(List<Double> durationsTaken,int []input,int[]expectedOutput){
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
        System.out.println("BubbleSort took "+durationsTaken.get(0)+ " milliseconds");
        System.out.println("Merge took "+durationsTaken.get(1)+ " milliseconds");
        System.out.println("Quick Sort took "+durationsTaken.get(2)+ " milliseconds");
        System.out.println("Radix Sort took "+durationsTaken.get(3)+ " milliseconds");
    }
    @Test
    public void Test0(){
        int []input=testCases[0][0];
        int []expectedOutput=testCases[0][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }
    @Test
    public void Test1(){
        int []input=testCases[1][0];
        int []expectedOutput=testCases[1][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);


    }
    @Test
    public void Test2(){
        int []input=testCases[2][0];
        int []expectedOutput=testCases[2][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }

    @Test
    public void Test3() {
        int[] input = {5};
        int[] expectedOutput = {5};
        List<Double> durationsTaken = new ArrayList<>(); // This array holds the values in milliseconds

        // Include both BubbleSortStrategy and MergeSortStrategy
        SortingStrategy[] sorters = {new BubbleSortStrategy(),new MergeSortStrategy(),new QuickSortStrategy(), NonComparisonSort.getInstance()};

       HelperFunction(durationsTaken,input,expectedOutput);
    }

    @Test
    public void Test4(){
        int []input=testCases[4][0];
        int []expectedOutput=testCases[4][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);
    }
    @Test
    public void Test5(){
        int []input=testCases[5][0];
        int []expectedOutput=testCases[5][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }
    @Test
    public void Test6(){
        int []input=testCases[6][0];
        int []expectedOutput=testCases[6][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);


    }
    @Test
    public void Test7(){
        int []input=testCases[7][0];
        int []expectedOutput=testCases[7][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }

    @Test
    public void Test8() {
        int []input=testCases[8][0];
        int []expectedOutput=testCases[8][1];
        List<Double> durationsTaken = new ArrayList<>(); // This array holds the values in milliseconds

        // Include both BubbleSortStrategy and MergeSortStrategy
        SortingStrategy[] sorters = {new BubbleSortStrategy(),new MergeSortStrategy(),new QuickSortStrategy(), NonComparisonSort.getInstance()};

       HelperFunction(durationsTaken,input,expectedOutput);
    }

    @Test
    public void Test9(){
        int []input=testCases[9][0];
        int []expectedOutput=testCases[9][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);
    }
    @Test
    public void Test10(){
        int []input=testCases[10][0];
        int []expectedOutput=testCases[10][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }
    @Test
    public void Test11(){
        int []input=testCases[11][0];
        int []expectedOutput=testCases[11][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);


    }
    @Test
    public void Test12(){
        int []input=testCases[12][0];
        int []expectedOutput=testCases[12][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }

    @Test
    public void Test13() {
        int []input=testCases[13][0];
        int []expectedOutput=testCases[13][1];
        List<Double> durationsTaken = new ArrayList<>(); // This array holds the values in milliseconds

        // Include both BubbleSortStrategy and MergeSortStrategy
        SortingStrategy[] sorters = {new BubbleSortStrategy(),new MergeSortStrategy(),new QuickSortStrategy(), NonComparisonSort.getInstance()};

       HelperFunction(durationsTaken,input,expectedOutput);
    }

    @Test
    public void Test14(){
        int []input=testCases[14][0];
        int []expectedOutput=testCases[14][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);
    }
    @Test
    public void Test15(){
        int []input=testCases[15][0];
        int []expectedOutput=testCases[15][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }
    @Test
    public void Test16(){
        int []input=testCases[16][0];
        int []expectedOutput=testCases[16][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);
    }
    @Test
    public void Test17(){
        int []input=testCases[17][0];
        int []expectedOutput=testCases[17][1];
        List<Double> durationsTaken=new ArrayList<>(); //this array holds the values in milliseconds;
        HelperFunction(durationsTaken,input,expectedOutput);

    }

    @Test
    public void Test18() {
        int []input=testCases[18][0];
        int []expectedOutput=testCases[18][1];
        List<Double> durationsTaken = new ArrayList<>(); // This array holds the values in milliseconds

        // Include both BubbleSortStrategy and MergeSortStrategy
        SortingStrategy[] sorters = {new BubbleSortStrategy(),new MergeSortStrategy(),new QuickSortStrategy(), NonComparisonSort.getInstance()};

       HelperFunction(durationsTaken,input,expectedOutput);
    }
}
