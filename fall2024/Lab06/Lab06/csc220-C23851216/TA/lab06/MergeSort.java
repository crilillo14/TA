package lab06;

import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> {

    private double c; // Constant for time prediction

    /**
     * Sorts the input array using merge sort.
     * @param array the input array to be sorted
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        E[] left = Arrays.copyOfRange(array, 0, mid);
        E[] right = Arrays.copyOfRange(array, mid, array.length);

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     * @param left the left half of the array
     * @param right the right half of the array
     * @return the merged sorted array
     */
    private E[] merge(E[] left, E[] right) {
        E[] result = Arrays.copyOf(left, left.length + right.length);
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    /**
     * Measures the complexity of merge sort.
     * @param n the input size
     * @return the O(n) complexity for merge sort
     */
    public double O(int n) {
        return n * Math.log(n);
    }

    /**
     * Fits the constant c for time prediction.
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();

        double timeTaken = (endTime - startTime) / 1e6; // Time in milliseconds
        c = timeTaken / O(array.length);  // Calculate the constant c
    }

    /**
     * Predicts the runtime for an array of size n using the fitted constant c.
     * @param n the input size
     * @return the predicted runtime in milliseconds
     */
    public double predict(int n) {
        return c * O(n);
    }
}
