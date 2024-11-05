package lab06;

public class Tester {
	
	public static void main(String[] args) {
		
		// Test #1
		
		System.out.println("First test: Constructor and getSorted");
		
		SortedString s1 = new SortedString("The Alert");
		
		SortedString s2 = new SortedString("Later!");
		
		System.out.println("Original: " + s1.getUnsorted() + ", Sorted: " + s1.getSorted());
		
		System.out.println("Original: " + s2.getUnsorted() + ", Sorted: " + s2.getSorted());
		
		
		// both will have "The Alert" sorted version
		
		
		// Test #2
		System.out.println("\nTest 2: Anagram Comparison using the compareTo");
		
		if (s1.compareTo(s2) == 0) {
			
			System.out.println(s1.getUnsorted() + "and" + s2.getUnsorted() + "are anagrams.");
			

		} else {
			
			System.out.println(s1.getUnsorted() + "and" + s2.getUnsorted() + "are not anagrams.");
			
		}
		
		// Test #3; edge case
		
		
		System.out.println("\nTest 3, edge case with empty string");
		
		SortedString s3 = new SortedString("");
		SortedString s4 = new SortedString("");
		
		if (s3.compareTo(s4) == 0) {
			
			System.out.println("Empty string are considered anagrams.");
			
		} else {
			
			System.out.println("Empty string are not considered anagrams.");
			
		}
		
		// Test #4; case  insensitivity
		
		System.out.println("\nTest 4 is for case insensitivity");
		
		SortedString s5 = new SortedString("Begin");
		
		SortedString s6 = new SortedString("being");
		
		if (s5.compareTo(s6) == 0) {
			
			System.out.println(s5.getUnsorted() + " and " + s6.getUnsorted() + " are anagrams (case-insensitive). ");
			
		} else {				
				
			System.out.println(s5.getUnsorted() + " and " + s6.getUnsorted() + " are not anagrams.");
				
			}
		
		 // Test 5; a non-anagram test
      System.out.println("\nTest 5; non-anagram test");
      
      SortedString s7 = new SortedString("hello");
      
      SortedString s8 = new SortedString("world");
      
      if (s7.compareTo(s8) == 0) {
    	  
          System.out.println(s7.getUnsorted() + " and " + s8.getUnsorted() + " are anagrams.");
          
      } else {
    	  
          System.out.println(s7.getUnsorted() + " and " + s8.getUnsorted() + " are not anagrams.");
          
      }
      
      InsertionSort<SortedString> sorter = new InsertionSort<>();
      
      // Fit with a small array (PART 3 & 4 OF LAB)
      System.out.println("\nFitting runtime prediction...");
      
      SortedString[] smallArray = {
    		  
          new SortedString("grapes"), 
          
          new SortedString("apples"), 
          
          new SortedString("orange")
          
      };
      
      sorter.fit(smallArray);
      
      // predicting the runtime for a larger array (e.g., 100K or 1M elements)
      int largeInputSize = 100000;
      
      System.out.println("Predicted runtime for input size " + largeInputSize + ": " + sorter.predict(largeInputSize) + " seconds");
      
      
      System.out.println("Below you will find Assignment 06 testing: ");
      
      String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
      
      System.out.println("\nLargest group of Anangrams: ");
      
      for (String word: largestGroup) {
    	  
    	  System.out.println(word);
    		  
    	  }
      
      // Assignment Tests
      
        MergeSort<Integer> mergeSort = new MergeSort<>();

              // Test with a list of one element
        
        
        Integer[] oneElementArray = {5};
        
        System.out.println("Sorted (one element):");
        
        printArray(mergeSort.sort(oneElementArray));
              
              

              // Test with a list of two elements
              
        Integer[] twoElementArray = {10, 2};
        
        System.out.println("Sorted (two elements):");
        
        printArray(mergeSort.sort(twoElementArray));
        
        

              // Test with a sorted list
        
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        
        System.out.println("Sorted (already sorted):");
        
        printArray(mergeSort.sort(sortedArray));
        
        

              
        // Test with a random list
        
        Integer[] randomArray = {7, 3, 1, 6, 2};
        
        System.out.println("Sorted (random list):");
        
        printArray(mergeSort.sort(randomArray));

              // Predict runtime for larger inputs
              
        mergeSort.fit(randomArray);  // Fit the timing model with a small array
         
        int largeSize = 100000;
         
        System.out.println("Predicted runtime for input size " + largeSize + ": " + mergeSort.predict(largeSize) + " milliseconds");
        
        
          }

          // Helper method to print arrays
          public static void printArray(Integer[] array) {
        	  
        	  for (int num : array) {
        		  
        		  System.out.print(num + " ");
        	  }
        	  
        	  System.out.println();

      }

      
      
      
      
	}


