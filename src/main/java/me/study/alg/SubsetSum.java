package me.study.alg;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubsetSum {
    public boolean sum(int[] data, int k, int target, Deque<Integer> queue) {
        if (target == 0) {
            System.out.println(queue);
            return true;
        }
        if (target < 0 || k >= data.length) {
            return false;
        }

        boolean s1 = sum(data, k + 1, target, queue);
        queue.addLast(data[k]);
        boolean s2 = sum(data, k + 1, target - data[k], queue);
        queue.removeLast();
        return s1 || s2;
    }

    public static void main(String[] args) {
        new SubsetSum().sum(new int[]{10, 7, 5, 18, 12, 20, 15}, 0, 30, new ArrayDeque<>());
    }
}
