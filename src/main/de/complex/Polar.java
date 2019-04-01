package de.complex;

/**
 * @author Roman Schmidt, Stanislav Brug
 * <p>
 * Handle and scope the polar attributes and give convert method to cartesian
 */
public class Polar {
    private double _alpha;
    private double _abs;

    public Polar(double alpha, double abs) {
        this._alpha = alpha;
        this._abs = abs;
    }

    public double getAlpha() {
        return _alpha;
    }

    public double getAbs() {
        return _abs;
    }

    public Cartesian getCartesian() {
        return MathUtils.getCartesianFromPolar(this);
    }
}
