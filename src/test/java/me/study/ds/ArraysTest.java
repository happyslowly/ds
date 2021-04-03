package me.study.ds;

import me.study.ds.misc.Tuple2;
import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {
    private final String[] data = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

    @Test
    public void mergesort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void insertionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.insertionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void selectionSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.selectionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void quickSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.quickSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void heapSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.heapSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void binarySearch() {
        String[] arr = data.clone();
        Arrays.quickSort(arr);
        Assert.assertEquals(3, Arrays.binarySearch(arr, "L"));
    }

    @Test
    public void min() {
        String[] arr = data.clone();
        Assert.assertEquals("A", Arrays.min(arr));
    }

    @Test
    public void minMax() {
        String[] arr = data.clone();
        Tuple2<String, String> t = Arrays.minMax(arr);
        Assert.assertEquals("A", t.getX());
        Assert.assertEquals("X", t.getY());
    }

    @Test
    public void mergeSort() {
        String[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void radixSort() {
        int[] arr = new int[]{190, 45, 23, 1, 27, 383, 70, 3};
        Arrays.radixSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void kthSmallest() {
        Integer[] arr = new Integer[]{3, 1, 42, 9, 10, 37, 91, 81, 18};
        Assert.assertEquals(1, (int) Arrays.kthSmallest(arr, 1));
        Assert.assertEquals(42, (int) Arrays.kthSmallest(arr, 7));
        Assert.assertEquals(91, (int) Arrays.kthSmallest(arr, 9));
    }

    @Test
    public void bucketSort() {
        double[] arr = new double[]{.78, .17, .39, .25, .72, .95, .21, .12, .23, .67};
        Arrays.bucketSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }
}