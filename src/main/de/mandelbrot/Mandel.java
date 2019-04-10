package de.mandelbrot;

import de.complex.Complex;

/**
 * @author Roman Schmidt, Stanislaw Brug
 * <p>
 * Tooken code from source below and minimized to our needs.
 * <p>
 * source: https://introcs.cs.princeton.edu/java/32class/Mandelbrot.java.html
 */
public class Mandel {
    private static double _maxAbsolute = 2.0;

    public static boolean isInSet(Complex z0) {
        Complex z = z0;
        int t = 0;

        for (; t < 100; t++) {
            if (z.getAbsolute() > Mandel._maxAbsolute) {
                return true;
            }
            z = z.multiply(z).plus(z0);
        }
        return false;
    }
}
