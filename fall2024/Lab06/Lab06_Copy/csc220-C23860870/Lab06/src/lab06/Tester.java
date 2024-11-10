package lab06;

public class Tester {
	
	public static void main(String[] args) {
		//Part 1.1 and 1.2 test
		
        SortedString s1 = new SortedString("act");
        SortedString s2 = new SortedString("car");
        System.out.println("Original: " + s1.getUnsorted() + ", Sorted: " + s1.getSorted());  
        System.out.println("Original: " + s2.getUnsorted() + ", Sorted: " + s2.getSorted());  
  
        System.out.println("Compare sorted: " + s1.compareTo(s2)); 
        
        SortedString s3 = new SortedString("cat");
        
        System.out.println("Compare act to cat: " + s1.compareTo(s3));  
         
        SortedString s4 = new SortedString("Apple");
        SortedString s5 = new SortedString("apple");
        System.out.println("Original: " + s4.getUnsorted() + ", Sorted: " + s4.getSorted());
        System.out.println("Original: " + s5.getUnsorted() + ", Sorted: " + s5.getSorted());
        System.out.println("Compare Apple to apple: " + s4.compareTo(s5)); 
        
        
        //Part 2 test
        
        SortedString emptyStr = new SortedString("");
        SortedString nonEmptyStr = new SortedString("nonempty");
        System.out.println("Are '' and 'nonempty' anagrams? " + AnagramUtil.areAnagrams(emptyStr, nonEmptyStr)); 
        
        SortedString shuffleOne = new SortedString("no");
        SortedString shuffleTwo = new SortedString("on");
        System.out.println("Are 'no' and 'on' anagrams? " + AnagramUtil.areAnagrams(shuffleOne, shuffleTwo));
        
        SortedString sameOne = new SortedString("Hello");
        SortedString sameTwo = new SortedString("hello");
        System.out.println("Are 'Hello' and 'hello' anagrams? " + AnagramUtil.areAnagrams(sameOne, sameTwo));
        
        SortedString differentOne = new SortedString("first");
        SortedString differentTwo = new SortedString("second");
        System.out.println("Are 'first' and 'second' anagrams? " + AnagramUtil.areAnagrams(differentOne, differentTwo));
        
		
        //Assignment part 1 
        System.out.println("Testing AnagramUtil.getLargestAnagramGroup with sample_word_list.txt");

        
        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        
        
        System.out.println("Largest Anagram Group: ");
        for (String word : largestAnagramGroup) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        
        
        MergeSort<Integer> mergeSort = new MergeSort<>();

        // Test 1: A list with one element
        Integer[] oneElement = {5};
        Integer[] sortedOneElement = mergeSort.sort(oneElement);
        System.out.print("Sorted list with one element: ");
        for (int num : sortedOneElement) {
            System.out.print(num + " ");
        }
        System.out.println();  
        
        Integer[] twoElements = {10, 1};
        Integer[] sortedTwoElements = mergeSort.sort(twoElements);
        System.out.print("Sorted list with two elements: ");
        for (int num : sortedTwoElements) {
            System.out.print(num + " ");
        }
        System.out.println();  
        
        Integer[] sortedNumbers = {1, 2, 3, 4, 5};
        Integer[] sortedSortedNumbers = mergeSort.sort(sortedNumbers);
        System.out.print("Already sorted list of numbers: ");
        for (int num : sortedSortedNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();  
        
        Integer[] randomNumbers = {7, 3, 1, 6, 2};
        Integer[] sortedRandomNumbers = mergeSort.sort(randomNumbers);
        System.out.print("Sorted random list of numbers: ");
        for (int num : sortedRandomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();  

       
        System.out.println("Testing AnagramUtil.getLargestAnagramGroup with sample_word_list.txt using MergeSort");
        String[] largestAnagram = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        
        System.out.println("Largest Anagram Group (using MergeSort): ");
        for (String word : largestAnagram) {
            System.out.print(word + " ");
        }
        System.out.println();
       
        
        MergeSort<Integer> mergSort = new MergeSort<>();

        Integer[] randoNumbers = {7, 3, 1, 6, 2};

        
        mergSort.fit(randoNumbers);

        
        double predictedTime = mergSort.predict(100000);
        System.out.println("Predicted time for sorting 100,000 elements: " + predictedTime + " microseconds");
        
        InsertionSort<Integer> insertionSort = new InsertionSort<>();

     Integer[] oneElementList = {42};
     Integer[] sortedOneElementList = insertionSort.sort(oneElementList);
     System.out.print("InsertionSort - Sorted list with one element: ");
     for (int num : sortedOneElementList) {
         System.out.print(num + " ");
     }
     System.out.println();
     Integer[] twoElementsList = {99, 21};
     Integer[] sortedTwoElementsList = insertionSort.sort(twoElementsList);
     System.out.print("InsertionSort - two elements: ");
     for (int num : sortedTwoElementsList) {
         System.out.print(num + " ");
     }
     System.out.println();
     Integer[] sortedList = {10, 20, 30, 40, 50};
     Integer[] sortedSortedList = insertionSort.sort(sortedList);
     System.out.print("InsertionSort - Already sorted list: ");
     for (int num : sortedSortedList) {
         System.out.print(num + " ");
     }
     System.out.println();
     Integer[] randomList = {8, 4, 5, 1, 9};
     Integer[] sortedRandomList = insertionSort.sort(randomList);
     System.out.print("InsertionSort -  random list: ");
     for (int num : sortedRandomList) {
         System.out.print(num + " ");
     }
     System.out.println();
     insertionSort.fit(randomList);
     double predictedTimeForLargeInput = insertionSort.predict(100000);
     System.out.println("InsertionSort - Predicted time for sorting 100,000 elements: " + predictedTimeForLargeInput + " microseconds");
        
	}






}
