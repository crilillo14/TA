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
        //TODO: Lab Part 4.1
        return Math.pow(n,2); // placeholder
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        //TODO: Lab Part 4.2
    	long start = System.nanoTime();
    	sort(array);
    	long end = System.nanoTime();
    	this.c = (double)(end - start) / 1000.0;
    	
    	// Remember this.c should b equal to C 
    	// conert UNIX time to MICRO seconds (factor of 10^3 i thinks)f
    }// end of fit

    /**
     * Predicts the running time of an insertion sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        //TODO: Lab Part 4.3
    	
    	// t = O(n) * c
    	// => c = t / O(n)
        return this.c * O(n); // placeholder
    }

    /**
     * Sorts the input array using the insertion sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        //TODO: Lab Part 3

        /* Handle case where length of array is 1 or less */
    	if(array.length <= 1) {
    		return array;
    	}
        /* make a copy of the array to sort */
        E[] sorted = array.clone();

        /* Perform the insertion sort */
        for(int index=1; index < sorted.length; index++)
        	
        	
        {
            // FILL IN
        	E key = sorted[index];
        	int jdex = index;
        	while(jdex > 0 && sorted[jdex - 1].compareTo(key) > 0) {
        		
        		sorted[jdex] = sorted[jdex - 1];
        		jdex--;
        		
        	}// end of while
        	
        	sorted[jdex] = key;
        	
        }// end of for

        return sorted; //placeholder
    }

}
