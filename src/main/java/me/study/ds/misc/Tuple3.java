package me.study.ds.misc;

public class Tuple3<X, Y, Z> {
    private final X x;
    private final Y y;
    private final Z z;

    public Tuple3(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public Z getZ() {
        return z;
    }
}
