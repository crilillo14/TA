package lab06;

/**
 * Implementation of the Insertion Sort algorithm with performance prediction functionality.
 * The class allows sorting of generic elements that implement the Comparable interface
 * and includes methods to estimate running time based on input size.
 *
 * @param <E> the type of elements to be sorted, which must implement Comparable
 */
public class InsertionSort<E extends Comparable<E>> 
{

    /** The constant used in the time formula t = c * O() */
    private double c;

    /**
     * Calculates the order O() of the implementation.
     * For example, if the implementation is O(n^2), use Math.pow(n, 2).
     *
     * @param n the input size
     * @return the value of the function of n inside the O() notation
     */
    public double O(int n) 
    {
        //TODO: Lab Part 4.1
        return Math.pow(n, 2); 
    }

    /**
     * Calculates the constant c using a given input array of type E.
     * Time units should be converted to microseconds for accurate predictions.
     *
     * @param array the input array used for timing the sort
     */
    public void fit(E[] array) 
    {
        //TODO: Lab Part 4.2
    	
    	if(array == null || array.length == 0)
    	{
    		throw new IllegalArgumentException("Array must be either null or empty!");
    	}
    	
    	int n = array.length;
    	
    	long startTime = System.nanoTime();
    	sort(array);
    	long endTime = System.nanoTime();
    	double elapsedTimeMicroseconds = (endTime - startTime) / 1000.0;
    	c = elapsedTimeMicroseconds / O(n);
    	
    }

    /**
     * Predicts the running time of an insertion sort for a given input size n.
     *
     * @param n the input size
     * @return the estimated time in microseconds to sort an array of size n
     */
    public double predict(int n) 
    {
        //TODO: Lab Part 4.3
        return c  * O(n); 
    }

    /**
     * Sorts the input array using the insertion sort algorithm.
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public E[] sort(E[] array) 
    {
        //TODO: Lab Part 3
    	
    	if(array == null)
    	{
    		throw new IllegalArgumentException("Array must not be null!");
    	}
    	
    	for(E element : array)
    	{
    		if(element == null)
    		{
    			throw new IllegalArgumentException("Array must contain a null element!");
    		}
    	}

        /* Handle case where length of array is 1 or less */
    	if(array.length <= 1)
    	{
    		return array;
    	}

        /* make a copy of the array to sort */
        E[] sorted = array.clone();

        /* Perform the insertion sort */
        for(int i=1; i < sorted.length; i++)
        {
        	E key = sorted[i];// The current element needs to be inserted
        	int j = i-1;
        	
        	// Shifting the elements of the sorted position of the array to the right, only until the correct position for 'key' is found.
        	while(j >= 0 && sorted[j].compareTo(key) > 0)
        	{
        		sorted[j+1] = sorted[j];
        		j--;
        	}
        	
        	sorted[j+1] = key; // After going through the conditional loop, insert 'key' at the correct position 
  
        }

        return sorted; 
    }

}
