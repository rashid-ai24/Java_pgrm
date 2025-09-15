// File: DistanceConverter.java
package DistanceConverter;

public class DistanceConverter {

    public double metertokm(double x) {
        return x * 0.001;
    }
    public double kmtometer(double x) {
        return x / 0.001;
    }
    public double milestokm(double x) {
        return x * 1.60934;
    }
    public double kmtomiles(double x) {
        return x / 1.60934;
    }
}
