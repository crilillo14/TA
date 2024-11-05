package lab06;

public class Tester {
	
	public static void main(String[] args) {
		
		// Test for SortedString
		SortedString s1 = new SortedString("listen");
		SortedString s2 = new SortedString("silent");
		
		if (s1.compareTo(s2) == 0) {
			System.out.println("SortingString passed");
		}
		else {
			System.out.println("SortedString failed");
		}
		
		// Test for areAnagrams
		if (AnagramUtil.areAnagrams(s1, s2)) {
			System.out.println("areAnagrams passed");
		}
		else {
			System.out.println("areAnagrams failed");
		}
		
		// Test for InsertionSort
		String[] states = {"Arizona", "California", "Florida"};
        SortedString[] sortedStrings = SortedString.toSortedString(states);
        InsertionSort<SortedString> sorter = new InsertionSort<>();
        SortedString[] result = sorter.sort(sortedStrings);

        System.out.println("Testing InsertionSort: ");
        for (SortedString ss : result) {
            System.out.println(ss);
        }

        if (result[0].toString().equals("Arizona") && 
            result[1].toString().equals("California") &&
            result[2].toString().equals("Florida")) {
            System.out.println("InsertionSort passed");
        }
        else {
            System.out.println("InsertionSort failed");
        }
        
        // Test for InsertionSort Performance
        sorter.fit(sortedStrings);
        double time = sorter.predict(10);
        
        if (time > 0) {
            System.out.println("InsertionSort performance passed");
        } 
        else {
            System.out.println("InsertionSort performance failed");
        }
        
        // Test for MergeSort        
        Integer[] merge = {5, 3, 8, 1, 2};
        MergeSort<Integer> mergeSorter = new MergeSort<>();
        Integer[] mergeResult = mergeSorter.sort(merge);

        System.out.println("Testing MergeSort:");
        for (int i : mergeResult) {
            System.out.print(i + " ");
        }
        System.out.println();

        if (mergeResult[0] == 1 && mergeResult[4] == 8) {
            System.out.println("MergeSort passed");
        }
        else {
            System.out.println("MergeSort failed");
        }

        // Test for MergeSort performance
        mergeSorter.fit(merge);
        double mergePredictedTime = mergeSorter.predict(10);
      
        if (mergePredictedTime > 0) {
            System.out.println("MergeSort Performance passed");
        }
        else {
            System.out.println("MergeSort Performance failed");
        }
        
        // Test for getLargestAnagramGroup
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Testing getLargestAnagramGroup:");
        for (String word : s3) {
            System.out.println(word);
        }

        if (s3.length > 0) {
            System.out.println("getLargestAnagramGroup passed");
        }
        else {
            System.out.println("getLargestAnagramGroup failed");
        }
	}
}