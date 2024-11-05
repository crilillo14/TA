package lab06;

public class InsertionSort<E extends Comparable<E>> {
    private double c; // The constant used in the time formula t = c * O()

    public double O(int n) {
        return Math.pow(n, 2); // Assuming the implementation is O(n^2)
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
        for (int i = 1; i < sorted.length; i++) {
            E current = sorted[i];
            int j = i;
            while (j > 0 && sorted[j - 1].compareTo(current) > 0) {
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = current;
        }
        return sorted;
    }
}
