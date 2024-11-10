package lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // Test SortedString
        SortedString str1 = new SortedString("Listen");
        SortedString str2 = new SortedString("Silent");
        System.out.println("Are 'Listen' and 'Silent' anagrams? " + AnagramUtil.areAnagrams(str1, str2));

        // Test getLargestAnagramGroup
        SortedString[] stringList = {
                new SortedString("carets"),
                new SortedString("caters"),
                new SortedString("caster"),
                new SortedString("crates"),
                new SortedString("reacts"),
                new SortedString("recast"),
                new SortedString("traces"),
                new SortedString("hello"),
                new SortedString("world")
        };

        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(stringList);
        System.out.println("Largest anagram group: " + String.join(", ", largestGroup));

        // Test InsertionSort
        Integer[] numbers = { 5, 2, 4, 3, 1 };
        Integer[] sortedNumbers = InsertionSort.sort(numbers);
        System.out.println("Insertion Sort Result: " + Arrays.toString(sortedNumbers));

        // Create an instance of MergeSort
        MergeSort<Integer> mergeSort = new MergeSort<>();
        // Test MergeSort
        Integer[] mergeSortedNumbers = mergeSort.sort(numbers);
        System.out.println("Merge Sort Result: " + Arrays.toString(mergeSortedNumbers));

        // Test reading from file (sample_word_list.txt)
        try {
            Scanner scanner = new Scanner(new File("sample_word_list.txt"));
            SortedString[] fileStrings = new SortedString[100]; // Assuming max 100 words for simplicity
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileStrings[index++] = new SortedString(line);
            }
            String[] largestAnagramGroupFromFile = AnagramUtil.getLargestAnagramGroup(Arrays.copyOf(fileStrings, index));
            System.out.println("Largest anagram group from file: " + String.join(", ", largestAnagramGroupFromFile));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
