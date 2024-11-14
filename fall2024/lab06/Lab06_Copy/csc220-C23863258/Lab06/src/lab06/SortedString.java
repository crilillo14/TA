package lab06;

import java.util.Arrays;

/**
 * This class represents a string and its sorted version.
 * It is used for comparing strings based on their sorted character order.
 */
public class SortedString implements Comparable<SortedString> {

    // The original unsorted string
    private String unsorted;
    
    // The sorted version of the original string
    private String sorted;

    /**
     * Constructor for SortedString.
     * Initializes the unsorted and sorted versions of the input string.
     *
     * @param unsorted the original unsorted string
     */
    public SortedString(String unsorted) {
        // TODO: Lab Part 1.1
    	
    	this.unsorted = unsorted;
    	this.sorted = "";
    	String[] strings = new String[this.unsorted.length()];
    	strings = this.unsorted.toLowerCase().split("");
    	Arrays.sort(strings);
    	for (int i = 0; i < this.unsorted.length(); i++) {
    		this.sorted += strings[i];
    	}
    	
    	
    	
    }

    /**
     * Convenience function to convert an array of strings to an array of SortedString.
     *
     * @param strings the input array of strings
     * @return the SortedString representation of the input strings
     */
    public static SortedString[] toSortedString(String[] strings) {
        SortedString[] out = new SortedString[strings.length];
        for (int i = 0; i < out.length; i++)
            out[i] = new SortedString(strings[i]);
        return out;
    }

    /**
     * Gets the sorted version of the original string.
     *
     * @return the sorted string
     */
    public String getSorted() {
        return sorted;
    }

    /**
     * Gets the original unsorted string.
     *
     * @return the unsorted string
     */
    public String getUnsorted() {
        return unsorted;
    }

    /**
     * Compares this SortedString with another SortedString based on their sorted values.
     *
     * @param other the other SortedString to compare to
     * @return a negative integer, zero, or a positive integer as this object's sorted 
     *         value is less than, equal to, or greater than the specified object's sorted value
     */
    public int compareTo(SortedString other) {
        // TODO: Lab Part 1.2
    	
    	
    	if (this.sorted.toLowerCase() == null || other.sorted.toLowerCase() == null) {
    		return -1;
    	}
    	
    	else if (this.sorted.toLowerCase().compareTo(other.sorted.toLowerCase()) > 0){
    		return 1;
    	}
    	else if (this.sorted.toLowerCase().compareTo(other.sorted.toLowerCase()) == 0){
    		return 0;
    	}
    	else {
    		return -1;
    	}
    	
    	
       
    }

    /**
     * Returns a string representation of the object.
     * The format is "unsorted/sorted".
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return unsorted + "/" + sorted;
    }
}
