package lab06;

/**
 * Implementation of the Merge Sort algorithm with performance prediction functionality.
 * The class allows sorting of generic elements that implement the Comparable interface
 * and includes methods to estimate running time based on input size.
 *
 * @param <E> the type of elements to be sorted, which must implement Comparable
 */
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
        // TODO: Assignment Part 3.1
        return 0; // placeholder
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        // TODO: Assignment Part 3.2
    }

    /**
     * Predicts the running time of a merge sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        // TODO: Assignment Part 3.3
        return Double.POSITIVE_INFINITY; // placeholder
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
        E[] array2 = sorted.clone();
        sort(sorted, array2, 0, array.length - 1);
        return sorted;
    }

    /**
     * Recursively sorts the input array using merge sort.
     *
     * @param array1 the input array to be sorted
     * @param array2 a temporary array used for merging
     * @param first the starting index of the range to sort
     * @param last the ending index of the range to sort
     */
    private void sort(E[] array1, E[] array2, int first, int last) {
        // TODO: Assignment Part 2
        if (first >= last)
            return;

        int middle = (first + last) / 2;
        sort(array1, array2, first, middle);
        sort(array1, array2, middle + 1, last);

        int i = first;
        int a = first;
        int b = middle + 1;
        while (a <= middle && b <= last) {
            // EXERCISE

            // Copy the smaller of array1[a] or array1[b] to array2[i]
            // (in case of a tie, copy array1[a])
            // and increment i and a or b (the one you copied).
            break; // DELETE this break after implementing
        }

        // EXERCISE
        // Copy the rest of a or b, whichever is not at the end.

        // Copy the merged subarrays back into array1
        System.arraycopy(array2, first, array1, first, last - first + 1);
    }
}
