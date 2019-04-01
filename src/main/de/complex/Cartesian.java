package de.complex;

/**
 * @author Roman Schmidt, Stanislav Brug
 * <p>
 * Handle and scope the cartesian attributes and give convert method to polar
 */
public class Cartesian {
    private double _imag;
    private double _real;

    public Cartesian(double real, double imag) {
        this._imag = imag;
        this._real = real;
    }

    public double getImag() {
        return _imag;
    }

    public double getReal() {
        return _real;
    }

    public Polar getPolar() {
        return MathUtils.getPolarFromCartesian(this);
    }
}
