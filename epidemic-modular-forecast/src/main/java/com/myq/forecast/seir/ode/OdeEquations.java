package com.myq.forecast.seir.ode;


import com.myq.forecast.seir.population.SeirRecord;

public class OdeEquations {

    private OdeEquations() {
        // hidden constructor
    }

    public static double calculateDsDt(OdeProperties props, SeirRecord population) {

        final double n = population.getN();
        final double s = population.getS();
        final double i = population.getI();

        final double a = props.getMu() * (n - s);
        final double b = props.getBeta() * (s * i / n);
        final double c = props.getNu() * (s);

        return a - b - c;
    }


    public static double calculateDeDt(OdeProperties props, SeirRecord population) {
        final double n = population.getN();
        final double s = population.getS();
        final double e = population.getE();
        final double i = population.getI();

        final double a = props.getBeta() * (s * i / n);
        final double b = (props.getMu() + props.getSigma()) * e;

        return a - b;
    }


    public static double calculateDiDt(OdeProperties props, SeirRecord population) {
        final double e = population.getE();
        final double i = population.getI();

        final double a = props.getSigma() * e;
        final double b = (props.getMu() + props.getGamma()) * i;

        return a - b;
    }

    public static double calculateDrDt(OdeProperties props, SeirRecord population) {


        final double s = population.getS();
        final double i = population.getI();
        final double r = population.getR();

        final double a = props.getGamma() * i;
        final double b = props.getMu() * r;
        final double c = props.getNu() * s;

        return a - b + c;


    }
}