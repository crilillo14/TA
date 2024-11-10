package lab06;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        // PART 1: SortedString and AnagramUtil Tests
        System.out.println("===== PART 1: SortedString and AnagramUtil Tests =====\n");

        // Part 1.1: Testing the SortedString constructor and getSorted/getUnsorted methods
        System.out.println(">>> Test A1: SortedString constructor <<<");
        SortedString str1 = new SortedString("carets");
        SortedString str2 = new SortedString("Caters");

        System.out.println("Original (carets): " + str1.getUnsorted());
        System.out.println("Sorted (carets): " + str1.getSorted());
        System.out.println("Original (Caters): " + str2.getUnsorted());
        System.out.println("Sorted (Caters): " + str2.getSorted());
        System.out.println();

        // Part 1.2: Testing compareTo method of SortedString
        System.out.println(">>> Test A2: SortedString.compareTo <<<");
        System.out.println("Comparing 'carets' and 'Caters': " + str1.compareTo(str2));
        System.out.println();

        // Part 2: Testing AnagramUtil.areAnagrams
        System.out.println(">>> Test B1: AnagramUtil.areAnagrams <<<");
        boolean result = AnagramUtil.areAnagrams(str1, str2);
        System.out.println("Are 'carets' and 'Caters' anagrams? " + result);
        System.out.println();

        // Testing AnagramUtil.getLargestAnagramGroup with a sample word list
        System.out.println(">>> Test B2: AnagramUtil.getLargestAnagramGroup <<<");
        SortedString[] stringList = {
                new SortedString("carets"), new SortedString("Caters"),
                new SortedString("caster"), new SortedString("traces"),
                new SortedString("crates"), new SortedString("React"),
                new SortedString("notanagram"), new SortedString("recast")
        };

        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(stringList);
        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup));
        System.out.println();

        // PART 3: MergeSort Tests
        System.out.println("===== PART 3: MergeSort Tests =====\n");
        MergeSort<Integer> mergeSort = new MergeSort<>();

        // Test Case 1: Small array
        System.out.println(">>> Test C1: MergeSort with a small array <<<");
        Integer[] smallArray = {5, 2, 9, 3, 1, 4};
        System.out.println("Original array: " + Arrays.toString(smallArray));
        Integer[] sortedSmallArray = mergeSort.sort(smallArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedSmallArray));
        System.out.println();

        // Test Case 2: Already sorted array
        System.out.println(">>> Test C2: MergeSort with an already sorted array <<<");
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};
        System.out.println("Original array: " + Arrays.toString(sortedArray));
        Integer[] resultSortedArray = mergeSort.sort(sortedArray);
        System.out.println("Sorted array: " + Arrays.toString(resultSortedArray));
        System.out.println();

        // Test Case 3: Reverse sorted array
        System.out.println(">>> Test C3: MergeSort with a reverse sorted array <<<");
        Integer[] reverseSortedArray = {9, 7, 5, 3, 2, 1};
        System.out.println("Original array: " + Arrays.toString(reverseSortedArray));
        Integer[] resultReverseArray = mergeSort.sort(reverseSortedArray);
        System.out.println("Sorted array: " + Arrays.toString(resultReverseArray));
        System.out.println();

        // Test Case 4: Single element array
        System.out.println(">>> Test C4: MergeSort with a single element array <<<");
        Integer[] singleElementArray = {42};
        System.out.println("Original array: " + Arrays.toString(singleElementArray));
        Integer[] sortedSingleElementArray = mergeSort.sort(singleElementArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedSingleElementArray));
        System.out.println();

        // Test Case 5: Empty array
        System.out.println(">>> Test C5: MergeSort with an empty array <<<");
        Integer[] emptyArray = {};
        System.out.println("Original array: " + Arrays.toString(emptyArray));
        Integer[] sortedEmptyArray = mergeSort.sort(emptyArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedEmptyArray));
        System.out.println();

        // PART 3: MergeSort Performance Prediction
        System.out.println("===== PART 3: MergeSort Performance Prediction =====\n");

        // Test 3.1: O(n log n) complexity for MergeSort
        System.out.println(">>> Test C6: MergeSort O(n log n) <<<");
        int n = 10;
        double expectedO = n * Math.log(n) / Math.log(2);
        double actualO = mergeSort.O(n);
        System.out.println("Expected O(" + n + ") = " + expectedO);
        System.out.println("Actual O(" + n + ") = " + actualO);
        System.out.println("O(n log n) test passed? " + (Math.abs(expectedO - actualO) < 0.0001));
        System.out.println();

        // Test 3.2: fit() - calculate constant c for MergeSort
        System.out.println(">>> Test C7: MergeSort.fit() to calculate constant c <<<");
        Integer[] arrayToFit = {10, 1, 23, 7, 9, 2, 18, 5};
        System.out.println("Array before sorting: " + Arrays.toString(arrayToFit));
        mergeSort.fit(arrayToFit);
        System.out.println("Array after sorting: " + Arrays.toString(mergeSort.sort(arrayToFit)));
        System.out.println("Constant c calculated successfully.");
        System.out.println();

        // Test 3.3: predict() - predict sorting time for a larger array
        System.out.println(">>> Test C8: MergeSort.predict() for larger input sizes <<<");
        int largeN = 100000;
        double predictedTime = mergeSort.predict(largeN);
        System.out.println("Predicted time to sort an array of size " + largeN + ": " + predictedTime + " microseconds");
        System.out.println();

        // PART 4: InsertionSort Tests and Performance Prediction
        System.out.println("===== PART 4: InsertionSort Tests and Performance Prediction =====\n");

        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        // Test 4.1: O(n^2) complexity for InsertionSort
        System.out.println(">>> Test D1: InsertionSort O(n^2) <<<");
        n = 10;
        expectedO = Math.pow(n, 2);
        actualO = insertionSort.O(n);
        System.out.println("Expected O(" + n + ") = " + expectedO);
        System.out.println("Actual O(" + n + ") = " + actualO);
        System.out.println("O(n^2) test passed? " + (Math.abs(expectedO - actualO) < 0.0001));
        System.out.println();

        // Test 4.2: fit() - calculate constant c for InsertionSort
        System.out.println(">>> Test D2: InsertionSort.fit() to calculate constant c <<<");
        arrayToFit = new Integer[]{10, 1, 23, 7, 9, 2, 18, 5};
        System.out.println("Array before sorting: " + Arrays.toString(arrayToFit));
        insertionSort.fit(arrayToFit);
        System.out.println("Array after sorting: " + Arrays.toString(insertionSort.sort(arrayToFit)));
        System.out.println("Constant c calculated successfully.");
        System.out.println();

        // Test 4.3: predict() - predict sorting time for a larger array
        System.out.println(">>> Test D3: InsertionSort.predict() for larger input sizes <<<");
        largeN = 100000;
        predictedTime = insertionSort.predict(largeN);
        System.out.println("Predicted time to sort an array of size " + largeN + ": " + predictedTime + " microseconds");
        System.out.println();
    }
}

