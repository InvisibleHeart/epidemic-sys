package com.myq.forecast.seir.population;


import java.util.Objects;

public class SeirRecord {

    private final int time;
    private final double n;
    private final double s;
    private final double e;
    private final double i;
    private final double r;


    public SeirRecord(final int time, final double n, final double s, final double e, final double i, final double r) {

        this.time = time;
        this.n = n;
        this.s = s;
        this.e = e;
        this.i = i;
        this.r = r;

    }

    public int getTime() {
        return time;
    }

    public double getN() {
        return n;
    }

    public double getS() {
        return s;
    }

    public double getE() {
        return e;
    }

    public double getI() {
        return i;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return String.format("SeirRecord{ time=%d, n=%.8f, s=%.8f, e=%.8f, i=%.8f, r=%.8f}", time, n, s, e, i, r);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeirRecord that = (SeirRecord) o;
        return time == that.time &&
                Double.compare(that.n, n) == 0 &&
                Double.compare(that.s, s) == 0 &&
                Double.compare(that.e, e) == 0 &&
                Double.compare(that.i, i) == 0 &&
                Double.compare(that.r, r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, n, s, e, i, r);
    }
}
