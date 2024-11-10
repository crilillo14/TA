package lab06;

public class MergeSort<E extends Comparable<E>> {

    private double c; // Constant to predict runtime

    /**
     * Returns the order O(n log n) for MergeSort.
     * @param n the size of the input
     * @return the time complexity value O(n log n)
     */
    public double O(int n) {
        return n * Math.log(n) / Math.log(2); // O(n log n)
    }

    /**
     * Fits the constant c based on the input array size and the time taken to sort it.
     * @param array the array to be sorted and timed
     */
    public void fit(E[] array) {
        long startTime = System.nanoTime();
        sort(array); // Sort the array
        long endTime = System.nanoTime();
        
        long elapsedTime = endTime - startTime; // Time in nanoseconds
        double elapsedTimeInMicroseconds = elapsedTime / 1000.0; // Convert to microseconds
        
        int n = array.length;
        double order = O(n); // O(n log n) calculation
        this.c = elapsedTimeInMicroseconds / order; // Calculate the constant c
    }

    /**
     * Predicts the running time for an array of input size n.
     * @param n the input size
     * @return the predicted time in microseconds
     */
    public double predict(int n) {
        return this.c * O(n); // Predict time in microseconds for input size n
    }

    /**
     * Sorts the input array using MergeSort algorithm.
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        if (array.length <= 1)
            return array; // Return if the array is already sorted

        E[] sorted = array.clone();
        E[] array2 = sorted.clone(); // Temporary array for merging
        sort(sorted, array2, 0, array.length - 1);
        return sorted;
    }

    private void sort(E[] array1, E[] array2, int first, int last) {
        if (first >= last)
            return; // Base case

        int middle = (first + last) / 2; // Find the middle index
        sort(array1, array2, first, middle); // Sort the left half
        sort(array1, array2, middle + 1, last); // Sort the right half

        // Merge the sorted halves
        int i = first, a = first, b = middle + 1;

        while (a <= middle && b <= last) {
            if (array1[a].compareTo(array1[b]) <= 0) {
                array2[i++] = array1[a++];
            } else {
                array2[i++] = array1[b++];
            }
        }

        while (a <= middle) {
            array2[i++] = array1[a++];
        }

        while (b <= last) {
            array2[i++] = array1[b++];
        }

        System.arraycopy(array2, first, array1, first, last - first + 1);
    }
}
