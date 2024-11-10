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
        return (str1.compareTo(str2) == 0);
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
    	InsertionSort<SortedString> insertionSort = new InsertionSort<SortedString>();

        /* sort the input string list */
    	SortedString[] sortedStrings = insertionSort.sort(stringList);

        /* The case where stringList is of size 1 or less */
    	if (sortedStrings.length == 1) {
    		if (stringList[0] != null) {
    			String[] strings = new String[1];
    			strings[0] = stringList[0].getUnsorted();
    			return strings;
    		}
    		else {
    			return new String[0];
    		}
    	}
    	else if (sortedStrings.length == 0) {
    		return new String[0];
    	}

        /* The variables for the logic following */
        int end = 0, length = 1, start = 0, maxLength = 0;

        /* Loop through stringList.

           If stringList[i] and stringList[i + 1] are anagrams, increment the
           length of this anagram group.

           Otherwise, check to see if the length of this anagram group is longer
           than the currently known maximum group length. Update variables
           accordingly (see end, length, i, and MaxLength).

        */

        for (int index = 0; index < sortedStrings.length - 1; index++) {

        	// if the next is the same as current, we gotta add one to length
        	if (sortedStrings[index].getSorted().equals(sortedStrings[index + 1].getSorted())) {
        		length += 1;
        	}
        	// if the next isnt equal, then the group of anagrams ends
        	else {
        		// if the length of that anagram group is bigger than current max,
        		// we need to set the start equal to the start of anagram group
        		if (length >= maxLength) {
        			maxLength = length;
        			end = index;
        		}

        		length = 1;
        	}
        }

        start = end - maxLength + 1;

//        System.out.println(start + " " + end + " " + maxLength);
        // should print 6 to 12 please dude

        /* Don't forget one last check for the end:
           if the longest list is the last group.
           As before, update variables accordingly.
        */
        length = 1;
        for (int index = sortedStrings.length - 1; index != 0; index--) {
        	if (sortedStrings[index].getSorted().equals(sortedStrings[index - 1].getSorted())) {
        		length += 1;
        	}
        	else {
        		// we only really want the length of the last group
        		start = index;
        		break; // just saves some time i guess
        	}
        }

        // if the last group's length is indeed bigger, we gotta change the end and max to this
        if (length >= maxLength) {
        	maxLength = length;
        	end = sortedStrings.length - 1;
        }

        /* Prepare to return. The following is almost the answer except
           for one thing...
        */
        String[] toReturn = new String[maxLength];
        // UNCOMMENT FOR ASSIGNMENT
        for (int j = 0; j < maxLength; j++) {
            toReturn[j] = sortedStrings[j+end-maxLength+1].getUnsorted();
        }

        return toReturn;
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
