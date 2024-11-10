package lab06;


public class Tester {

    //You will need to write your own tests
	  public static void main(String[] args) {
		  	SortedString sort1 = new SortedString("cat"); 
		  	SortedString sort2 = new SortedString("act"); 
		  	SortedString sort3 = new SortedString(""); 
		  	SortedString sort4 = new SortedString("bat"); 
		  	System.out.println(sort2.compareTo(sort4));
		  	
		  	
		  	System.out.println(AnagramUtil.areAnagrams(sort3, sort2));
		  	
		  	String[] newString = {"cat", "dog", "bat", "how"}; 
		  	
		  	InsertionSort<String> sort6 = new InsertionSort<String>(); 
		  	
		  	String[] stringAgain = sort6.sort(newString); 
		  	
		  	for (int i = 0; i < newString.length; i++) {
		  		System.out.print(stringAgain[i] + " ");
		  	}
		  	System.out.println();
		  	
		  	sort6.fit(newString);
		  	System.out.println(sort6.predict(100000000));
		  	System.out.println(sort6.predict(newString.length));
		  	
		  	String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		  	System.out.println("Largest Anagram Group from file: ");
	        for (String word : s3) {
	            System.out.print(word + " "); 
	        }
	        System.out.println();
		  	
	        Integer[] intArray = {5, 2, 9, 1, 6, 3, 8, 7, 4, 0};
	        MergeSort<Integer> mergeSort = new MergeSort<>();
	        Integer[] sortedArray = mergeSort.sort(intArray);
	        System.out.print("Sorted integer array: ");
	        for (Integer num : sortedArray) {
	            System.out.print(num + " ");
	        }
	        System.out.println();  
	        
	        Integer[] sortedInput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	        sortedArray = mergeSort.sort(sortedInput);
	        System.out.print("Sorted already sorted array: ");
	        for (Integer num : sortedArray) {
	            System.out.print(num + " ");
	        }
	        System.out.println();  
	        
	        Integer[] singleElementArray = {42};
	        sortedArray = mergeSort.sort(singleElementArray);
	        System.out.print("Sorted single element array: ");
	        for (Integer num : sortedArray) {
	            System.out.print(num + " ");
	        }
	        System.out.println();  
	        
	        Integer[] emptyArray = {};
	        sortedArray = mergeSort.sort(emptyArray);
	        System.out.print("Sorted empty array: ");
	        for (Integer num : sortedArray) {
	            System.out.print(num + " ");
	        }
	        System.out.println(); 
	        
	        mergeSort.fit(intArray);
	        System.out.println("Constant c: " + mergeSort.predict(intArray.length)); 
	        
	        System.out.println("Predicted time for 100,000 elements: " + mergeSort.predict(100000) + " microseconds");
	        System.out.println("Predicted time for 1,000,000 elements: " + mergeSort.predict(1000000) + " microseconds");
	        
	        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
	        System.out.println("Largest Anagram Group from file: ");
	        for (String word : largestAnagramGroup) {
	            System.out.print(word + " ");
	        }
	        System.out.println();
	        
		  	
	  }

}

