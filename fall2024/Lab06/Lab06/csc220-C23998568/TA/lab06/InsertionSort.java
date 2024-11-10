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
    	double answer = Math.pow(n, 2);
        return answer; // placeholder
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) {
        //TODO: Lab Part 4.2
    	long startTime = System.nanoTime();
    		sort(array);
    	long end = System.nanoTime();
    	double result = end - startTime;
    	result = result / 1000000;
    	
    	System.out.println("Time to run: " + result);
    	
    }

    /**
     * Predicts the running time of an insertion sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) {
        //TODO: Lab Part 4.3
    	double Double = O(n);
    	Double = Double/1000;
  
        return Double; // placeholder
    }

    /**
     * Sorts the input array using the insertion sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        //TODO: Lab Part 3
    	E[] sorted = array.clone();
        /* Handle case where length of array is 1 or less */    	
    	if(array.length <= 1) return sorted;
    	
    	for(int i = 0; i < sorted.length; i++) {
    		E dataSwitch = sorted[i];
    		if(i == 0) continue;
    		
    		for(int j = i - 1; j >= 0; j--) {
    			if (dataSwitch.compareTo(sorted[j]) < 0) {
        			E switcher = sorted[j];
    				sorted[j] = dataSwitch;
    				sorted[j + 1] = switcher;
    				
    				
    			}
    			
    		}
        	
        }

        return sorted; 
    }

}
