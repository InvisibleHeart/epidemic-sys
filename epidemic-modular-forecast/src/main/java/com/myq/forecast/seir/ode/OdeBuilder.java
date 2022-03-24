package com.myq.forecast.seir.ode;

import com.myq.forecast.seir.exception.SeirException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OdeBuilder {
    private static final Logger LOGGER = LogManager.getLogger(OdeBuilder.class);
    private double mu;
    private double nu;
    private double gamma;
    private double sigma;
    private double beta;


    public OdeBuilder setMu(double mu) {
        this.mu = mu;
        return this;
    }

    public OdeBuilder setNu(double nu) {
        this.nu = nu;
        return this;
    }

    public OdeBuilder setGamma(double gamma) {
        this.gamma = gamma;
        return this;
    }

    public OdeBuilder setSigma(double sigma) {
        this.sigma = sigma;
        return this;
    }

    public OdeBuilder setBeta(double beta) {
        this.beta = beta;
        return this;
    }

    public OdeProperties build() {

        if (gamma == 0d) {
            String message = "The value for gamma cannot be zero.";
            LOGGER.error(message);
            throw new SeirException(message);
        }
        if (sigma == 0d) {
            String message = "The value for sigma cannot be zero.";
            LOGGER.error(message);
            throw new SeirException(message);
        }
        if (beta == 0d) {
            String message = "The value for beta cannot be zero.";
            LOGGER.error(message);
            throw new SeirException(message);
        }

        return new OdeProperties(gamma, sigma, beta, mu, nu);
    }


}
