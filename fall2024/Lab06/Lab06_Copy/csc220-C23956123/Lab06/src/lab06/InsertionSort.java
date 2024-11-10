package lab06;

/**
 * Implementation of the Insertion Sort algorithm with performance prediction functionality.
 * The class allows sorting of generic elements that implement the Comparable interface
 * and includes methods to estimate running time based on input size.
 *
 * @param <E> the type of elements to be sorted, which must implement Comparable
 */
public class InsertionSort<E extends Comparable<E>> {

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
        //TODO: Lab Part 4.1 DONE
            // Insertion sort is O(n^2)
            return Math.pow(n, 2);
        
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        //TODO: Lab Part 4.2 DONE
    	long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        
        
        long timeTotal = endTime - startTime;  // Time in nanoseconds
        
        // Convert time to microseconds for more readable results
        timeTotal = timeTotal / 1000;

        int n = array.length;
        c = (double) timeTotal / O(n);
    }

    /**
     * Predicts the running time of an insertion sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        //TODO: Lab Part 4.3 DONE
    	return c * O(n);
    }

    /**
     * Sorts the input array using the insertion sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        //TODO: Lab Part 3 DONE
    	
        /* Handle case where length of array is 1 or less */

        /* make a copy of the array to sort */

        if (array.length <= 1) {
            return array;
        }

        E[] sorted = array.clone();
        /* Perform the insertion sort */
        for (int i = 1; i < sorted.length; i++) {
            E key = sorted[i];
            int j = i - 1;
         // Shift elements of sorted[0..i-1], that are greater than current, to one position ahead of their current position
            while (j >= 0 && sorted[j].compareTo(key) > 0) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            //Place the correct element at the correct position
            sorted[j + 1] = key;
        }

        return sorted;
    }

}
