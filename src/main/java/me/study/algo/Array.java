package me.study.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class Array {

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
        Heap<T> heap = new Heap<>(arr.length);
        for (T item : arr) {
            heap.insert(item);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extract();
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
        int p = partition(arr, lo, hi);
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

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
