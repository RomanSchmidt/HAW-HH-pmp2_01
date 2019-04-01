package de.complex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    /**
     * using getCartesianFromPolar directly and getPolarFromCartesian indirectly
     */
    @Test
    void getCartesianFromPolar() {
        Polar polar = new Polar(3, 4);
        Cartesian cart = MathUtils.getCartesianFromPolar(polar);
        assertEquals(0.2, cart.getImag(), 0.1);
        assertEquals(4, cart.getReal(), 0.1);
        Polar polar2 = cart.getPolar();
        assertEquals(polar2, polar);
        Cartesian cart2 = polar2.getCartesian();
        assertEquals(cart, cart2);
    }

    /**
     * also uses cos + sin
     */
    @Test
    void exp() {
        double real = 3.0;
        double imag = 4.0;
        Cartesian cart = new Cartesian(real, imag);
        Complex a = new Complex(cart);
        Complex b = MathUtils.exp(a);

        assertNotEquals(a, b);
        assertEquals(b.getCartesian(), new Cartesian(-13.128783081462158, -15.200784463067954));
    }

    /**
     * uses also tag, cos and divides
     */
    @Test
    void tan() {
        double real = 3.0;
        double imag = 4.0;
        Cartesian cart = new Cartesian(real, imag);
        Complex a = new Complex(cart);
        Complex b = MathUtils.tan(a);

        assertNotEquals(a, b);
        assertEquals(b.getCartesian(), new Cartesian(-1.8734620462948492E-4, 0.999355987381473));
    }

    @Test
    void phase() {
        double real = 3.0;
        double imag = 4.0;
        Cartesian cart = new Cartesian(real, imag);
        Complex a = new Complex(cart);
        double phase = MathUtils.phase(a);

        assertEquals(1, phase, 0.1);
    }
}