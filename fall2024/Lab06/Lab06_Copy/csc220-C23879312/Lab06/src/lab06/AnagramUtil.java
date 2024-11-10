package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Utility class for handling anagram-related operations such as determining
 * if two strings are anagrams and finding the largest group of anagrams from
 * a list.
 */
public class AnagramUtil {

    /**
     * Determines if two SortedString objects are anagrams of each other.
     *
     * @param str1 the first SortedString
     * @param str2 the second SortedString
     * @return true if the two strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(SortedString str1, SortedString str2){
        // TODO: Lab Part 2
    	if(str1.compareTo(str2) == 0) {
    		return true;
    	}
    	
        return false; // placeholder
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
    	
    	//MergeSort<SortedString> mergeSort = new MergeSort<>(); // initializing my mergesort
    	
//    	InsertionSort<SortedString> insertSort = new InsertionSort<SortedString>();
//    
//        /* sort the input string list */
//    	SortedString[] sortedList = insertSort.sort(stringList); 
    	
    	MergeSort<SortedString> mergeSort = new MergeSort<SortedString>();
        
        /* sort the input string list */
    	SortedString[] sortedList = mergeSort.sort(stringList);
    	// putting the stringList of type SortedString into the mergeSort (remember that the SortedString type is already mixing around the letters for us)
    	


        /* The case where stringList is of size 1 or less */
    	if(stringList.length <= 1) {
    		return new String[0]; // we are returning an empty array because no string groups will be possible
    	}


        /* The variables for the logic following */
        int end = 0, length = 1, maxLength = 0;

        /* Loop through stringList.

           If stringList[i] and stringList[i + 1] are anagrams, increment the
           length of this anagram group.

           Otherwise, check to see if the length of this anagram group is longer
           than the currently known maximum group length. Update variables
           accordingly (see end, length, i, and MaxLength).

        */
        
        // we only need to do sortedList - 1 because we are going to always get to i+1 in the if-statement check. if we didn't do -1, we would access a nonexistent index
        for(int i = 0; i < sortedList.length - 1; i++) {
        	// our if statement checks if the two adjacent items are equal
        	if(sortedList[i].compareTo(sortedList[i+1]) == 0) {
        		// if this is met, it means we have found a set of anagrams
        		length++;
        	} else {
        		// now we need to see if this group is larger than the previously found maxLength
        		if(length > maxLength) {
        			maxLength = length;
        			end = i; // this marks the end index (of that group)
        		}
        		
        		length = 1; //reset so the next group can build too!
        	}
        	
        }
        /* Don't forget one last check for the end:
           if the longest list is the last group.
           As before, update variables accordingly.
        */
        
        // this is our last check for the last group
        if(length > maxLength) {
        	maxLength = length;
        	end = sortedList.length - 1;
        }
        /* Prepare to return. The following is almost the answer except
           for one thing...
        */
        String[] toReturn = new String[maxLength];
        //uncomment for ASSIGNMENT
        for (int j = 0; j < maxLength; j++) {
        	toReturn[j] = sortedList[j+end-maxLength+1].getUnsorted();
        }
        

        return toReturn; // return the right thing
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
}
