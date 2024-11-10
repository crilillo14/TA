package lab06;

public class Tester {

    public static void main(String[] args) {
        
        // Testing anagram functionality
        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("silent");
        System.out.println("Are 'listen' and 'silent' anagrams? " + AnagramUtil.areAnagrams(str1, str2));
        
        // Predict sorting times and sort numbers
        InsertionSort<Integer> intSort = new InsertionSort<>();
        Integer[] numbers = {12, 3, 5, 1, 6, 2, 10, 4};
        intSort.fit(numbers); // Fit model on a small data sample
        System.out.println("Predicted time to sort 100 elements: " + intSort.predict(100));
        Integer[] sortedNumbers = intSort.sort(numbers);
        System.out.print("Sorted numbers: ");
        for (Integer num : sortedNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test sorting and anagram group finding with words
        String filename = "sample_word_list.txt";
        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup(filename);
        if (largestAnagramGroup != null) {
            System.out.print("Largest group of anagrams: ");
            for (String word : largestAnagramGroup) {
                System.out.print(word + " ");
            }
            System.out.println();
        } else {
            System.out.println("No anagrams found or error reading file.");
        }

        // Merge Sort tests
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.fit(numbers); // Fit model on a small data sample
        System.out.println("Predicted time to sort 1000 elements: " + mergeSort.predict(1000));
    }
}
