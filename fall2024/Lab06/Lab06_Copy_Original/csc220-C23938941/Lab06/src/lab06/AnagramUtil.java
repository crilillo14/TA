package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utility class for handling anagram-related operations such as determining
 * if two strings are anagrams and finding the largest group of anagrams from
 * a list.
 * @param <E>
 */
public class AnagramUtil<E> {

    /**
     * Determines if two SortedString objects are anagrams of each other.
     *
     * @param str1 the first SortedString
     * @param str2 the second SortedString
     * @return true if the two strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(SortedString str1, SortedString str2){
        // TODO: Lab Part 2
        return str1.getSorted().equals(str2.getSorted()); // placeholder
    }

    /**
     * Finds the largest group of anagrams in a file. The file should contain one
     * word per line.
     *
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename){
        
    	
    	SortedString[] words = readFile(filename);
    	
        String[] toReturn = getLargestAnagramGroup(words);
        return toReturn;
    }

    /**
     * Finds the largest group of anagrams in a list of SortedString objects.
     *
     * @param stringList an array of SortedString objects
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(SortedString[] stringList){

        //TODO Assignment Part 1

        /* Initialize a sorting algorithm of type SortedString using either
         MergeSort or InsertionSort */
    	
    	SortedString[] sorted = stringList.clone();

         /* Perform the insertion sort */
         for(int i = 1; i < sorted.length; i++) {
        	 SortedString current = sorted[i];
             int j = i - 1;
             
             while (j >= 0 && sorted[j].compareTo(current) > 0) {
             	sorted[j + 1] = sorted[j];
             	j = j - 1;
             }
             
             sorted[j + 1] = current;
             
         }
         
         int maxCount = 0;
         int indexOfMax = 0;
         int count=0;
         
         for(int i = 0; i < sorted.length-1; i++) {
        	 
        	 if(sorted[i].getSorted().equals(sorted[i+1].getSorted())) {
        		 count++;
        	 }
        	 else
        	 {
        		 count = 0;
        	 }
        	 if(count > maxCount) {
        		 maxCount = count;
        		 indexOfMax = i;
        	 }
        	 
        	 
         }
         
         String[] anagramList = new String[maxCount +1];
         int x = 0;
         for(int i = indexOfMax - maxCount + 1; i <= indexOfMax +1; i++) {
        	 anagramList[x] = sorted[i].getUnsorted();
        	 x++;
         }


        /* sort the input string list */


        /* The case where stringList is of size 1 or less */


        /* The variables for the logic following */
        int end = 0, length = 1, i = 0, maxLength = 0;

        /* Loop through stringList.

           If stringList[i] and stringList[i + 1] are anagrams, increment the
           length of this anagram group.

           Otherwise, check to see if the length of this anagram group is longer
           than the currently known maximum group length. Update variables
           accordingly (see end, length, i, and MaxLength).

        */


        /* Don't forget one last check for the end:
           if the longest list is the last group.
           As before, update variables accordingly.
        */


        /* Prepare to return. The following is almost the answer except
           for one thing...
        */
     //   String[] toReturn = new String[maxLength];
     //   for (int j = 0; j < maxLength; j++)
     //       toReturn[j] = stringList[j+end-maxLength+1];

        return anagramList; // return the right thing
    }

    /**
     * Reads a list of words from a file, where each line of the file contains a single word.
     * Converts the words to SortedString objects.
     *
     * @param filename the name of the file to read from
     * @return an array of SortedString objects representing the words in the file
     */
    public static SortedString[] readFile(String filename) {
        ArrayList<SortedString> results = new ArrayList<SortedString>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            while(input.ready()) {
                results.add(new SortedString(input.readLine()));
            }
            input.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        SortedString[] retval = new SortedString[1];
        return results.toArray(retval);
    }
    
    
    /*
    
    public <E> E[] sort(E[] array) {
        // check base case
    	if (array.length <= 1) {
            return array; 
        }

        // Split the array into two parts
        int mid = array.length / 2;
        E[] left = Arrays.copyOfRange(array, 0, mid);
        E[] right = Arrays.copyOfRange(array, mid, array.length);

        // sort both using recursion
        left = sort(left);
        right = sort(right);

        // merge back together using private helper method 
        return merge(left, right);
    }

  

	// helper method for the merge sort algorithm 
    private E[] merge(E[] left, E[] right) {
    	
        // uses comparable to sort
        E[] result = (E[]) new Comparable[left.length + right.length];

        int i = 0, j = 0, k = 0;

        
        while (i < left.length && j < right.length) {
            if ((left[i]).compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // copy the rest of the array on the left
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // copy the rest of the array on the right
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
    */

}
