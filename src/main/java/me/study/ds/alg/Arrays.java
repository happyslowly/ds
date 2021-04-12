package me.study.ds.alg;

import me.study.ds.basic.HeapPriorityQueue;
import me.study.ds.misc.Tuple2;

import java.util.Queue;
import java.util.*;

public class Arrays {
    private static final Random rand = new Random();

    public static <T extends Comparable<T>> T min(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Input array is empty.");
        }

        T min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> Tuple2<T, T> minMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Input array is empty.");
        }

        T min, max;
        int start;
        if ((arr.length & 1) == 1) {
            min = arr[0];
            max = arr[0];
            if (arr.length == 1) {
                return new Tuple2<>(min, max);
            }
            start = 1;
        } else {
            min = arr[0].compareTo(arr[1]) < 0 ? arr[0] : arr[1];
            max = min == arr[0] ? arr[1] : arr[0];
            start = 2;
        }
        for (int i = start; i < arr.length; i = i + 2) {
            T smaller = arr[i].compareTo(arr[i + 1]) < 0 ? arr[i] : arr[i + 1];
            T larger = smaller == arr[i] ? arr[i + 1] : arr[i];
            if (smaller.compareTo(min) < 0) {
                min = smaller;
            }
            if (larger.compareTo(max) > 0) {
                max = larger;
            }
        }
        return new Tuple2<>(min, max);
    }

    public static <T extends Comparable<T>> T kthSmallest(T[] arr, int k) {
        return randomSelect(arr, 0, arr.length - 1, k);
    }

    private static <T extends Comparable<T>> T randomSelect(T[] arr, int lo, int hi, int k) {
        if (lo == hi) {
            return arr[lo];
        }

        int p = randomPartition(arr, lo, hi);
        int i = p - lo + 1;
        if (i == k) {
            return arr[p];
        }
        if (i > k) {
            return randomSelect(arr, lo, p - 1, k);
        } else {
            return randomSelect(arr, p + 1, hi, k - i);
        }
    }

    private static void countingSort(int[] arr, int e, int k) {
        if (arr.length == 0) {
            return;
        }
        int[] aux = new int[k + 1];
        for (int n : arr) {
            aux[n / e % 10]++;
        }
        for (int i = 0; i < aux.length - 1; i++) {
            aux[i + 1] += aux[i];
        }
        int[] res = new int[arr.length];
        for (int j = arr.length - 1; j >= 0; j--) {
            res[aux[arr[j] / e % 10] - 1] = arr[j];
            aux[arr[j] / e % 10] -= 1;
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int e = 1; max / e > 0; e *= 10) {
            countingSort(arr, e, 9);
        }
    }

    @SuppressWarnings("unchecked")
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        List<Double>[] aux = new ArrayList[n];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new ArrayList<>();
        }
        for (double d : arr) {
            aux[(int) (d * n)].add(d);
        }
        for (List<Double> doubles : aux) {
            Collections.sort(doubles);
        }
        double[] ans = new double[arr.length];
        for (int i = 0, j = 0; j < aux.length; j++) {
            if (aux[j].size() == 0) {
                continue;
            }
            for (double d : aux[j]) {
                ans[i++] = d;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> int binarySearch(T[] arr, T key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid].equals(key)) {
                return mid;
            }
            if (arr[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return -1;
    }

    // merge sort
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);

    }

    private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
        Queue<T> queue1 = new ArrayDeque<>();
        Queue<T> queue2 = new ArrayDeque<>();
        for (int i = lo; i <= mid; i++) {
            queue1.offer(arr[i]);
        }
        for (int i = mid + 1; i <= hi; i++) {
            queue2.offer(arr[i]);
        }
        int i = lo;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            arr[i++] = queue1.peek().compareTo(queue2.peek()) < 0 ? queue1.poll() : queue2.poll();
        }
        while (!queue1.isEmpty()) {
            arr[i++] = queue1.poll();
        }
        while (!queue2.isEmpty()) {
            arr[i++] = queue2.poll();
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        me.study.ds.basic.PriorityQueue<T> heap = new HeapPriorityQueue<>(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = randomPartition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        T pivot = arr[hi];
        int j = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, j + 1, hi);
        return j + 1;
    }

    private static <T extends Comparable<T>> int randomPartition(T[] arr, int lo, int hi) {
        int pivotIndex = rand.nextInt(hi - lo + 1) + lo;
        swap(arr, pivotIndex, hi);
        return partition(arr, lo, hi);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
