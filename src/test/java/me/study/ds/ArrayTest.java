package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {
    private final String[] data = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

    @Test
    public void mergesort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Array.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void insertionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Array.insertionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void selectionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Array.selectionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void quickSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Array.quickSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void heapSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Array.heapSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void binarySearch() {
        String[] arr = data.clone();
        Array.quickSort(arr);
        Assert.assertEquals(3, Array.binarySearch(arr, "L"));
    }

}