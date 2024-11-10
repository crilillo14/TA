package lab06;

public class MergeSort<E extends Comparable<E>> {
    private double c;

    public double O(int n) {
        return n * Math.log(n); // Assuming the implementation is O(n log n)
    }

    public void fit(E[] array) {
        long start = System.nanoTime();
        sort(array);
        long stop = System.nanoTime();
        double time = (stop - start) / 1000.0;
        c = time / O(array.length);
    }

    public double predict(int n) {
        return c * O(n);
    }

    public E[] sort(E[] array) {
        if (array.length <= 1) return array;
        E[] sorted = array.clone();
        E[] helper = sorted.clone();
        sortHelper(sorted, helper, 0, array.length - 1);
        return sorted;
    }

    private void sortHelper(E[] array1, E[] array2, int first, int last) {
        if (first < last) {
            int middle = first + (last - first) / 2;
            sortHelper(array1, array2, first, middle);
            sortHelper(array1, array2, middle + 1, last);
            merge(array1, array2, first, middle, last);
        }
    }

    private void merge(E[] array1, E[] array2, int first, int middle, int last) {
        int leftIndex = first, rightIndex = middle + 1, index = first;
        while (leftIndex <= middle && rightIndex <= last) {
            if (array1[leftIndex].compareTo(array1[rightIndex]) <= 0) {
                array2[index++] = array1[leftIndex++];
            } else {
                array2[index++] = array1[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            array2[index++] = array1[leftIndex++];
        }
        while (rightIndex <= last) {
            array2[index++] = array1[rightIndex++];
        }
        System.arraycopy(array2, first, array1, first, last - first + 1);
    }
}
