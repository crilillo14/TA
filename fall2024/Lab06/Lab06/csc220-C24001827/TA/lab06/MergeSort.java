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
     * For example, if the implementation is O(n log n), use n * log(n).
     *
     * @param n the input size
     * @return the value of the function of n inside the O() notation
     */
    public double O(int n) {
        return n * Math.log(n); // O(n log n) for merge sort
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        double timeElapsed = (endTime - startTime) / 1000.0; // Convert to microseconds
        c = timeElapsed / O(array.length); // Calculate constant c
    }

    /**
     * Predicts the running time of a merge sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        return c * O(n); // Use the constant c and O(n log n) to predict time
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
        if (first >= last)
            return;

        int middle = (first + last) / 2;
        sort(array1, array2, first, middle);
        sort(array1, array2, middle + 1, last);

        int i = first;
        int a = first;
        int b = middle + 1;
        while (a <= middle && b <= last) {
            // Copy the smaller of array1[a] or array1[b] to array2[i]
            if (array1[a].compareTo(array1[b]) <= 0) {
                array2[i] = array1[a];
                a++;
            } else {
                array2[i] = array1[b];
                b++;
            }
            i++;
        }

        // Copy the rest of a or b, whichever is not at the end.
        while (a <= middle) {
            array2[i] = array1[a];
            i++;
            a++;
        }
        while (b <= last) {
            array2[i] = array1[b];
            i++;
            b++;
        }

        // Copy the merged subarrays back into array1
        System.arraycopy(array2, first, array1, first, last - first + 1);
    }
}