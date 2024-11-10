package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramUtil {

    public static boolean areAnagrams(SortedString str1, SortedString str2) {
        return str1.getSorted().equals(str2.getSorted());
    }

    public static String[] getLargestAnagramGroup(String filename) {
        SortedString[] words = readFile(filename);
        return getLargestAnagramGroup(words);
    }

    public static String[] getLargestAnagramGroup(SortedString[] stringList) {
        if (stringList == null || stringList.length == 0) {
            return new String[0];
        }

        // Sort the array using Arrays.sort and a custom comparator
        Arrays.sort(stringList);

        int maxCount = 0;
        int currentCount = 1;
        ArrayList<String> maxGroup = new ArrayList<>();
        ArrayList<String> currentGroup = new ArrayList<>(Arrays.asList(stringList[0].getUnsorted()));

        for (int i = 1; i < stringList.length; i++) {
            if (stringList[i].getSorted().equals(stringList[i - 1].getSorted())) {
                currentGroup.add(stringList[i].getUnsorted());
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxGroup = new ArrayList<>(currentGroup);
                }
                currentGroup.clear();
                currentGroup.add(stringList[i].getUnsorted());
                currentCount = 1;
            }
        }
        
        if (currentCount > maxCount) {
            maxGroup = new ArrayList<>(currentGroup);
        }

        return maxGroup.toArray(new String[0]);
    }

    public static SortedString[] readFile(String filename) {
        ArrayList<SortedString> results = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = input.readLine()) != null) {
                results.add(new SortedString(line));
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return results.toArray(new SortedString[0]);
    }
}
