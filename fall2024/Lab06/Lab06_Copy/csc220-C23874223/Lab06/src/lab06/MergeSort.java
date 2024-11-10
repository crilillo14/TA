package lab06;

public class MergeSort<E extends Comparable<E>> {

    /** The constant used in the time formula t = c * O() */
    private double c;

    /**
     * Calculates the order O() of the implementation.
     * For example, if the implementation is O(n^2), use Math.pow(n, 2).
     *
     * @param n the input size
     * @return the value of the function of n inside the O() notation
     */
    public double O(int n) {
        return n * Math.log(n) / Math.log(2);  // O(n log n)
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        long startTime = System.nanoTime();
        sort(array);  // Sort the array to time it
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1000.0;  // Convert to microseconds
        c = timeTaken / O(array.length);  // Calculate the constant c
    }

    /**
     * Predicts the running time of a merge sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        return c * O(n);  // Estimate the time based on O(n log n) and constant c
    }

    /**
     * Sorts the input array using the merge sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        if (array.length <= 1)
            return array;
        E[] sorted = array.clone();
        E[] tempArray = sorted.clone();  // Temporary array used for merging
        mergeSort(sorted, tempArray, 0, array.length - 1);  // Fixed: call the new mergeSort method
        return sorted;
    }

    /**
     * Recursively sorts the input array using merge sort.
     *
     * @param array1 the input array to be sorted
     * @param tempArray a temporary array used for merging
     * @param left the starting index of the range to sort
     * @param right the ending index of the range to sort
     */
    private void mergeSort(E[] array1, E[] tempArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        // Sort both halves
        mergeSort(array1, tempArray, left, middle);   // Sort the left half
        mergeSort(array1, tempArray, middle + 1, right);  // Sort the right half

        // Merge the sorted halves
        merge(array1, tempArray, left, middle, right);
    }

    private void merge(E[] array1, E[] tempArray, int left, int middle, int right) {
        int i = left, leftIndex = left, rightIndex = middle + 1;

        // Copy elements into tempArray while comparing left and right subarrays
        while (leftIndex <= middle && rightIndex <= right) {
            if (array1[leftIndex].compareTo(array1[rightIndex]) <= 0) {
                tempArray[i++] = array1[leftIndex++];
            } else {
                tempArray[i++] = array1[rightIndex++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (leftIndex <= middle) {
            tempArray[i++] = array1[leftIndex++];
        }

        // Copy any remaining elements from the right subarray
        while (rightIndex <= right) {
            tempArray[i++] = array1[rightIndex++];
        }

        // Copy back the merged subarrays into the original array
        System.arraycopy(tempArray, left, array1, left, right - left + 1);
    }
}

