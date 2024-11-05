package lab06;

import java.util.Arrays;

public class AnagramUtil {
    public static boolean areAnagrams(SortedString str1, SortedString str2) {
        return str1.getSorted().equals(str2.getSorted());
    }

    public static String[] getLargestAnagramGroup(SortedString[] stringList) {
        Arrays.sort(stringList);
        int maxLength = 0;
        int end = 0, length = 1;

        for (int i = 0; i < stringList.length - 1; i++) {
            if (areAnagrams(stringList[i], stringList[i + 1])) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                    end = i;
                }
                length = 1;
            }
        }

        // Final check in case the largest group is at the end of the list
        if (length > maxLength) {
            maxLength = length;
            end = stringList.length - 1;
        }

        // Build the largest anagram group
        String[] largestGroup = new String[maxLength];
        for (int i = 0; i < maxLength; i++) {
            largestGroup[i] = stringList[end - maxLength + 1 + i].getUnsorted();
        }
        return largestGroup;
    }
}
