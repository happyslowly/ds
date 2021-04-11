package me.study.alg;

import java.util.Arrays;
import java.util.Deque;

public class Permutations extends BackTracking<Integer> {

    @Override
    public boolean isSolution(Integer[] a, int k, int n) {
        return k == n;
    }

    @Override
    public Integer[] constructCandidates(Integer[] a, int k, int n) {
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            used[a[i]] = true;
        }
        int nc = 0;
        Integer[] candidates = new Integer[n - k + 1];
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                candidates[nc++] = i;
            }
        }
        return candidates;
    }

    @Override
    public void processSolution(Integer[] a, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 1; i <= k; i++) {
            sb.append(a[i]).append(',');
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('}');
        System.out.println(sb.toString());
    }

    public static void permutation(int[] a, int n, Deque<Integer> stack) {
        if (stack.size() == n) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!stack.contains(a[i])) {
                stack.push(a[i]);
                permutation(a, n, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        Integer[] a = new Integer[3];
        Arrays.fill(a, 0);
        p.backtrack(a, 0, 3);
    }
}
