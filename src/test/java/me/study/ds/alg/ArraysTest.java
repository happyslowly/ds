package me.study.ds.alg;

import me.study.ds.TestHelper;
import me.study.ds.misc.Tuple2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static me.study.ds.TestData.smallArray;

public class ArraysTest {
    private static Integer[] data;

    @BeforeClass
    public static void beforeClass() {
        data = java.util.Arrays.stream(smallArray).boxed().toArray(Integer[]::new);
    }

    @Test
    public void mergesort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void insertionSort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.insertionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void selectionSort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.selectionSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void quickSort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.quickSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void heapSort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.heapSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void binarySearch() {
        Integer[] arr = data.clone();
        Arrays.quickSort(arr);
        Assert.assertEquals(2, Arrays.binarySearch(arr, 3));
    }

    @Test
    public void min() {
        Integer[] arr = data.clone();
        Assert.assertEquals(1, (int) Arrays.min(arr));
    }

    @Test
    public void minMax() {
        Integer[] arr = data.clone();
        Tuple2<Integer, Integer> t = Arrays.minMax(arr);
        Assert.assertEquals(1, (int) t.getX());
        Assert.assertEquals(11, (int) t.getY());
    }

    @Test
    public void mergeSort() {
        Integer[] arr = data.clone();
        Assert.assertFalse(TestHelper.isSorted(arr));
        Arrays.mergeSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void radixSort() {
        int[] arr = smallArray.clone();
        Arrays.radixSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }

    @Test
    public void kthSmallest() {
        Integer[] arr = data.clone();
        Assert.assertEquals(1, (int) Arrays.kthSmallest(arr, 1));
        Assert.assertEquals(10, (int) Arrays.kthSmallest(arr, 7));
    }

    @Test
    public void bucketSort() {
        double[] arr = new double[]{.78, .17, .39, .25, .72, .95, .21, .12, .23, .67};
        Arrays.bucketSort(arr);
        Assert.assertTrue(TestHelper.isSorted(arr));
    }
}