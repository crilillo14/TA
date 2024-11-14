package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Utility class for handling anagram-related operations such as determining
 * if two strings are anagrams and finding the largest group of anagrams from
 * a list.
 */
public class AnagramUtil 
{

    /**
     * Determines if two SortedString objects are anagrams of each other.
     *
     * @param str1 the first SortedString
     * @param str2 the second SortedString
     * @return true if the two strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(SortedString str1, SortedString str2)
    {
        // TODO: Lab Part 2
    	return str1.toString().equals(str2.toString());
    }

    /**
     * Finds the largest group of anagrams in a file. The file should contain one
     * word per line.
     *
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename)
    {
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
    public static String[] getLargestAnagramGroup(SortedString[] stringList)
    {

        //TODO Assignment Part 1
    	if(stringList == null || stringList.length <= 1)
    	{
    		return new String[0];
    	}

        /* Initialize a sorting algorithm of type SortedString using either
         MergeSort or InsertionSort */
    	MergeSort<SortedString> mergeSort = new MergeSort<>();
    	stringList = mergeSort.sort(stringList);
    	
    	int maxLength = 0;
    	int currentLength = 1;
    	int maxEndIndex = 0;

        /* sort the input string list */
    	
    	for(int i = 0; i < stringList.length - 1; i++)
    	{
    		if(areAnagrams(stringList[i], stringList[i+1]))
    		{
    			currentLength++;
    		}
    		else
    		{
    			if(currentLength > maxLength)
    			{
    				maxLength = currentLength;
    				maxEndIndex = i;
    			}
    			
    			currentLength = 1;
    		}
    	}


        /* The case where stringList is of size 1 or less */


        /* The variables for the logic following */
        //int end = 0, length = 1, i = 0, maxLength = 0;

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
    	
    	if(currentLength > maxLength)
    	{
    		maxLength = currentLength;
    		maxEndIndex = stringList.length - 1;
    	}


        /* Prepare to return. The following is almost the answer except
           for one thing...
        */
        String[] largestGroup = new String[maxLength];
        for (int j = 0; j < maxLength; j++)
            largestGroup[j] = stringList[maxEndIndex - maxLength + 1 + j].getUnsorted();

        return largestGroup; 
    }

    /**
     * Reads a list of words from a file, where each line of the file contains a single word.
     * Converts the words to SortedString objects.
     *
     * @param filename the name of the file to read from
     * @return an array of SortedString objects representing the words in the file
     */
    public static SortedString[] readFile(String filename) 
    {
        ArrayList<SortedString> results = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader(filename)))
        {
            //BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            //while(input.ready()) 
            while((line = input.readLine()) != null)
            {
                //results.add(new SortedString(input.readLine()));
            	results.add(new SortedString(line.trim()));
            }
            //input.close();
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        //SortedString[] retval = new SortedString[1];
        //return results.toArray(retval);
        return results.toArray(new SortedString[0]);
    }
}