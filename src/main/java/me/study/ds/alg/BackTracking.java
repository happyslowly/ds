package me.study.ds.alg;

public abstract class BackTracking<T> {

    /**
     * @param a hold partial solution till k
     * @param k current solved problem till k
     * @param n problem size
     */
    public void backtrack(T[] a, int k, int n) {
        if (isSolution(a, k, n)) {
            processSolution(a, k);
        } else {
            k = k + 1;
            T[] candidates = constructCandidates(a, k, n);
            for (T candidate : candidates) {
                a[k] = candidate;
                makeMove(a, k);
                backtrack(a, k, n);
                unmakeMove(a, k);
            }
        }
    }

    public abstract boolean isSolution(T[] a, int k, int n);

    public abstract T[] constructCandidates(T[] a, int k, int n);

    public abstract void processSolution(T[] a, int k);

    public void makeMove(T[] a, int k) {
    }

    public void unmakeMove(T[] a, int k) {
    }

}
