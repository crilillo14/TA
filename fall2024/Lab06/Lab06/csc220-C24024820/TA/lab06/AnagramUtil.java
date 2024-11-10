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
    	if(str1.getSorted().compareTo(str2.getSorted())==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
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
    	
    	MergeSort<SortedString> is = new MergeSort<SortedString>();
        /* sort the input string list */
    	
		stringList = is.sort(stringList);
        
        /* The case where stringList is of size 1 or less */
		if(stringList.length<=1) {
			return new String[0];
		}

        /* The variables for the logic following */
        int end = 0, length = 1, i = 0, maxLength = 0;

        /* Loop through stringList.

           If stringList[i] and stringList[i + 1] are anagrams, increment the
           length of this anagram group.

           Otherwise, check to see if the length of this anagram group is longer
           than the currently known maximum group length. Update variables
           accordingly (see end, length, i, and MaxLength).

        */
        for(int k=0;k<stringList.length;k++) {
        	if(k==stringList.length-1) {
        		break;
        	}
        	//fix this case and check it i dont think it works
        	if(areAnagrams(stringList[k],stringList[k+1])) {
        		length++;
        	}
        	else {
        		if(length>maxLength) {
        			maxLength=length;
        			end=k;
        		}
        		length=1;
        	}
        }
        if(length>maxLength) {
        	maxLength=length;
        	end=stringList.length-1;
        }


        /* Don't forget one last check for the end:
           if the longest list is the last group.
           As before, update variables accordingly.
        */


        /* Prepare to return. The following is almost the answer except
           for one thing...
        */
        String[] toReturn = new String[maxLength];
        if(maxLength==1) {
        	return new String[0];
        }
        for (int j = 0; j < maxLength; j++)
            toReturn[j] = stringList[j+end-maxLength+1].getUnsorted();
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
