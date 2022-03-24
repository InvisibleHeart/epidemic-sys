package com.myq.forecast.seir.io;



import com.myq.forecast.seir.population.SeirRecord;

import java.util.Objects;

public class Properties extends SeirRecord {

    private final int t0;
    private final int tMax;


    public Properties(double n, double s, double e, double i, double r, int t0, int tMax) {

        super(t0, n, s, e, i, r);
        this.t0 = t0;
        this.tMax = tMax;
    }

    public int getT0() {
        return t0;
    }

    public int gettMax() {
        return tMax;
    }


    @Override
    public String toString() {
        return "Properties{" +
                "super=" + super.toString() +
                ",t0=" + t0 +
                ", tMax=" + tMax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Properties that = (Properties) o;
        return t0 == that.t0 &&
                tMax == that.tMax;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), t0, tMax);
    }
}
