package lab06;

/**
 * Implementation of the Insertion Sort algorithm with performance prediction functionality.
 * The class allows sorting of generic elements that implement the Comparable interface
 * and includes methods to estimate running time based on input size.
 *
 * @param <E> the type of elements to be sorted, which must implement Comparable
 */
public class InsertionSort<E extends Comparable<E>> {

    /**
     * Calculates the order O() of the implementation.
     * For example, if the implementation is O(n^2), use Math.pow(n, 2).
     *
     * @param n the input size
     * @return the value of the function of n inside the O() notation
     */
    public double O(int n) {
    	
        return Math.pow(n, 2);
        
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
    	
    	double elapsedTime = (endTime - startTime) / 1e9; // this will convert time to seconds
    	
    	double nSquared = O(array.length); 
    	
    	double c = elapsedTime / nSquared;
    	
    	System.out.println("The fitted constant c: " + c);

    	
    	
    }

    /**
     * Predicts the running time of an insertion sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    
    public double predict(int n) {
    	
    	double c = 1;
    	
    	return c * O(n);

    }

    /**
     * Sorts the input array using the insertion sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    
    
    public E[] sort(E[] array) {
    	
    	E[] sortedArray = array.clone();
    	
    	for (int i = 1; i < sortedArray.length; i++) {
    		
    		E key = sortedArray[i];
    		
    		int j = i - 1;
    		
    		while (j >= 0 && sortedArray[j].compareTo(key) > 0) {
    			
    			sortedArray[j + 1] = sortedArray[j];
    			
    			j = j - 1;
    		}
    		
    		
    		sortedArray[j + 1] = key;
    		
    	}
    	
    	return sortedArray; 
    	
    }
}
