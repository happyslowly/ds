package me.study.alg;

import java.util.Deque;

public class PowerSet extends BackTracking<Boolean> {

    @Override
    public boolean isSolution(Boolean[] a, int k, int n) {
        return k == n;
    }

    @Override
    public Boolean[] constructCandidates(Boolean[] a, int k, int n) {
        return new Boolean[]{true, false};
    }

    @Override
    public void processSolution(Boolean[] a, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 1; i <= k; i++) {
            if (a[i]) {
                sb.append(i).append(',');
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('}');
        System.out.println(sb.toString());
    }

    public void powerSet(int[] set, int k, Deque<Integer> stack) {
        System.out.println(stack);

        for (int i = k; i < set.length; i++) {
            stack.push(set[i]);
            powerSet(set, i + 1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        PowerSet s = new PowerSet();
        s.backtrack(new Boolean[4], 0, 3);
    }
}
