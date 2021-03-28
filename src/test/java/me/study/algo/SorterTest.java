package me.study.algo;

import org.junit.Assert;
import org.junit.Test;

public class SorterTest {
    private final String[] data = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

    @Test
    public void mergesort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Sorter.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void insertionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Sorter.insertionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void selectionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Sorter.selectionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void quickSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Sorter.quickSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void heapSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Sorter.heapSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

}