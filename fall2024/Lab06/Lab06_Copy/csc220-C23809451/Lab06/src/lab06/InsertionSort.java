package lab06;

public class InsertionSort {
    public static <E extends Comparable<E>> E[] sort(E[] array) {
        E[] sortedArray = array.clone(); // Create a copy of the input array

        for (int i = 1; i < sortedArray.length; i++) {
            E key = sortedArray[i];
            int j = i - 1;

            // Move elements of sortedArray[0..i-1] that are greater than key
            while (j >= 0 && sortedArray[j].compareTo(key) > 0) {
                sortedArray[j + 1] = sortedArray[j];
                j--;
            }
            sortedArray[j + 1] = key;
        }
        return sortedArray;
    }
}
