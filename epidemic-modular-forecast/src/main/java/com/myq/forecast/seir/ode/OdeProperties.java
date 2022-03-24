package com.myq.forecast.seir.ode;

import java.util.Objects;

public class OdeProperties {

    private final double gamma;
    private final double sigma;
    private final double beta;
    private final double nu;
    private final double mu;


    public OdeProperties(double gamma, double sigma, double beta, double mu, double nu) {
        this.gamma = gamma;
        this.sigma = sigma;
        this.beta = beta;
        this.nu = nu;
        this.mu = mu;
    }

    public double getGamma() {
        return gamma;
    }

    public double getSigma() {
        return sigma;
    }

    public double getBeta() {
        return beta;
    }

    public double getMu() {
        return mu;
    }

    public double getNu() {
        return nu;
    }

    @Override
    public String toString() {
        return String.format("OdeProperties{gamma=%.8f, sigma=%.8f, beta=%.8f, mu=%.8f, nu=%.8f}", gamma, sigma, beta, mu, nu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OdeProperties that = (OdeProperties) o;
        return Double.compare(that.gamma, gamma) == 0 &&
                Double.compare(that.sigma, sigma) == 0 &&
                Double.compare(that.beta, beta) == 0 &&
                Double.compare(that.nu, nu) == 0 &&
                Double.compare(that.mu, mu) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamma, sigma, beta, nu, mu);
    }
}
