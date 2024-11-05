package lab06;

public class Tester {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constuctor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
	public class Main {

	    public static void main(String[] args) {
	        SortedString s1 = new SortedString("listen");
	        SortedString s2 = new SortedString("silent");
	        SortedString s3 = new SortedString("apple");
	        System.out.println("SortedString 1: " + s1); 
	        System.out.println("SortedString 2: " + s2); 
	        System.out.println("SortedString 3: " + s3); 

	        if (s1.compareTo(s2) == 0) {
	            System.out.println("SortedString 1 and SortedString 2 are anagrams.");
	        } else {
	            System.out.println("SortedString 1 and SortedString 2 are not anagrams.");
	        }
	        
	        String[] words = {"stone", "tones", "hello", "world"};
	        SortedString[] sortedWords = SortedString.toSortedString(words);
	        System.out.println("\nArray of SortedStrings:");
	        for (int i = 0; i < sortedWords.length; i++) {
	            SortedString sortedString = sortedWords[i];
	            System.out.println(sortedString);
	        }
	        
	        System.out.println("\nSorted Array of SortedStrings:");
	        for (int i = 0; i < sortedWords.length; i++) {
	            SortedString sortedString = sortedWords[i];
	            System.out.println(sortedString);
	        }
	        
	        InsertionSort<Integer> sorter = new InsertionSort<>();
	        Integer[] array = {5, 2, 9, 1, 5, 6};
	        System.out.print("Original array: ");
	     
	        Integer[] sortedArray = sorter.sort(array);
	        System.out.print("Sorted array: ");
	            

	               
	        int newSize = 10;
	        double predictedTime = sorter.predict(newSize);
	        System.out.println("Predicted time to sort an array of size " + newSize + ": " + predictedTime + " microseconds");

	        newSize = 100;
	        predictedTime = sorter.predict(newSize);
	        System.out.println("Predicted time to sort an array of size " + newSize + ": " + predictedTime + " microseconds");
	        }

	            
	                    
	            
	        
	}
	
}


