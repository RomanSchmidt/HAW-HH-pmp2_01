package de.complex;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Roman Schmidt, Stanislav Brug
 * <p>
 * Class for mathematical calculation of a complex class which should never force any changes to the Complex object
 */
public abstract class MathUtils {

    @NotNull
    @Contract("_ -> new")
    public static Cartesian getCartesianFromPolar(@NotNull Polar polar) {
        double radiant = polar.getAlpha() * (Math.PI / 180);
        double real = polar.getAbs() * Math.cos(radiant);
        double imag = polar.getAbs() * Math.sin(radiant);
        return new Cartesian(real, imag);
    }

    @NotNull
    @Contract("_ -> new")
    public static Polar getPolarFromCartesian(Cartesian cartesian) {
        Complex complex = new Complex(cartesian);
        return new Polar(MathUtils.angleDegree(complex), complex.getAbsolute());
    }

    /**
     * todo test
     */
    @NotNull
    public static Complex exp(@NotNull Complex complex) {
        Cartesian cart = new Cartesian(Math.exp(complex.getReal()) * Math.cos(complex.getImag()), Math.exp(complex.getReal()) * Math.sin(complex.getImag()));
        return new Complex(cart, complex.getType());
    }

    /**
     * todo test
     */
    @NotNull
    public static Complex sin(@NotNull Complex complex) {
        Cartesian cart = new Cartesian(Math.sin(complex.getReal()) * Math.cosh(complex.getImag()), Math.cos(complex.getReal()) * Math.sinh(complex.getImag()));
        return new Complex(cart, complex.getType());
    }

    /**
     * todo test
     */
    @NotNull
    public static Complex cos(@NotNull Complex complex) {
        Cartesian cart = new Cartesian(Math.cos(complex.getReal()) * Math.cosh(complex.getImag()), -Math.sin(complex.getReal()) * Math.sinh(complex.getImag()));
        return new Complex(cart, complex.getType());
    }

    /**
     * todo test
     */
    public static Complex tan(Complex complex) {
        return MathUtils.sin(complex).divides(MathUtils.cos(complex));
    }

    /**
     * todo test
     */
    public static double angleRadiant(@NotNull Complex complex) {
        return Math.atan(complex.getImag() / complex.getReal());
    }

    /**
     * todo test
     */
    public static double angleDegree(Complex complex) {
        return MathUtils.angleRadiant(complex) * (180 / Math.PI);
    }

    /**
     * todo test
     */
    @NotNull
    public static Complex reciprocal(@NotNull Complex complex) {
        double scale = complex.getReal() * complex.getReal() + complex.getImag() * complex.getImag();
        Cartesian cart = new Cartesian(complex.getReal() / scale, -complex.getImag() / scale);
        return new Complex(cart, complex.getType());
    }

    /**
     * todo test
     */
    public double phase(Complex complex) {
        return Math.atan2(complex.getImag(), complex.getReal());
    }
}
