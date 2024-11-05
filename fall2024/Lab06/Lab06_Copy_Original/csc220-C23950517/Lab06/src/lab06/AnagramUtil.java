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
    	
    	if (str1.compareTo(str2) == 0){
    		return true; 
    	}
        return false; 
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
    	
    	MergeSort<SortedString> sorter = new MergeSort<>();
    	//InsertionSort<SortedString> sorter = new InsertionSort<>();
    	 
        /* sort the input string list */
    	 sorter.sort(stringList); 

        /* The case where stringList is of size 1 or less */
    	 if (stringList.length <= 1) {
    	        return new String[0];
    	    }


    	 int maxLength = 0;  
         int maxGroupStart = 0;  

         
         for (int i = 0; i < stringList.length; i++) {
             int currentLength = 1;  
             for (int j = i + 1; j < stringList.length; j++) {
                 
                 if (areAnagrams(stringList[i], stringList[j])) {
                     currentLength++; 
                 }
             }

             
             if (currentLength > maxLength) {
                 maxLength = currentLength;
                 maxGroupStart = i;
             }
         }

         
         String[] toReturn = new String[maxLength];
         int index = 0;
         for (int i = 0; i < stringList.length; i++) {
             if (areAnagrams(stringList[maxGroupStart], stringList[i])) {
                 toReturn[index++] = stringList[i].getUnsorted();  
             }
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
