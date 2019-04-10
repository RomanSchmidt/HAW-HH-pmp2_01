package de.mandelbrot;

import de.complex.Complex;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Roman Schmidt, Stanislaw Brug
 * <p>
 * Tooken code from source below and minimized to our needs.
 * <p>
 * source: https://de.wikipedia.org/wiki/Mandelbrot-Menge
 */
public class Julia {
    private static final double _reC = -0.65175;
    private static final double _imC = 0.41850;

    // Zo-Werte checken nach Zn+1 = Zn^2 + C, C = const.
    @Contract(pure = true)
    public static boolean isInSet(@NotNull Complex complex) {
        double reZ;
        double imZ;
        double reZMinus1 = complex.getReal();
        double imZMinus1 = complex.getImag();
        int i = 0;

        for (; i < 47; i++) {
            imZ = 2 * reZMinus1 * imZMinus1 + Julia._imC;
            reZ = reZMinus1 * reZMinus1 - imZMinus1 * imZMinus1 + Julia._reC;
            if (reZ * reZ + imZ * imZ > 4) {
                return true;
            }
            reZMinus1 = reZ;
            imZMinus1 = imZ;
        }
        return false;
    }
}
