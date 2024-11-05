package lab06;

import java.util.Arrays;

public class SortedString implements Comparable<SortedString> {

    private String unsorted;
    private String sorted;

    public SortedString(String unsorted) {
        this.unsorted = unsorted;
        char[] chars = unsorted.toLowerCase().toCharArray();
        Arrays.sort(chars);
        this.sorted = new String(chars);
    }

    public String getUnsorted() {
        return unsorted;
    }

    public String getSorted() {
        return sorted;
    }

    @Override
    public int compareTo(SortedString other) {
        return this.sorted.compareTo(other.sorted);
    }

    @Override
    public String toString() {
        return unsorted + "/" + sorted;
    }

    /**
     * Converts an array of strings to an array of SortedString objects.
     * @param strings the input array of strings
     * @return an array of SortedString objects
     */
    public static SortedString[] toSortedString(String[] strings) {
        SortedString[] sortedStrings = new SortedString[strings.length];
        for (int i = 0; i < strings.length; i++) {
            sortedStrings[i] = new SortedString(strings[i]);
        }
        return sortedStrings;
    }
}
