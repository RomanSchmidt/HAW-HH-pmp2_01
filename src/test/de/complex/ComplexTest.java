package de.complex;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ComplexTest {
    private final double _aReal = 5.0;
    private final double _aImag = 6.0;
    private final double _bReal = -3.0;
    private final double _bImag = 4.0;

    private final double _aRealDivBReal = 0.36;
    private final double _aImagDivBImag = -1.52;
    private final double _aRealMultiplyBReal = -39;
    private final double _aImagMultiplyBImag = 2.0;

    // build the awaited string
    @NotNull
    private static String _buildCartString(double real, double imag) {
        StringBuilder builder = new StringBuilder();
        builder.append(real);
        if (imag > 0) {
            builder.append(" + ");
        } else {
            builder.append(" - ");
        }
        builder.append(Math.abs(imag));
        builder.append('i');
        return builder.toString();
    }

    private static void _checkChanges(
            @NotNull Complex a,
            Complex b,
            @NotNull Complex c,
            double aReal,
            double aImag,
            double bReal,
            double bImag,
            double cReal,
            double cImag,
            boolean mutable
    ) {
        assertEquals(aReal, a.getReal(), 0);
        assertEquals(aImag, a.getImag(), 0);

        if (b != null) {
            assertEquals(bReal, b.getReal(), 0);
            assertEquals(bImag, b.getImag(), 0);
        }

        assertEquals(cReal, c.getReal(), 0);
        assertEquals(cImag, c.getImag(), 0);

        if (mutable) {
            assertEquals(a, c);
            assertEquals(a.hashCode(), c.hashCode());
            assertEquals(ComplexTest._buildCartString(cReal, cImag), a.toString());
        } else {
            assertNotEquals(a, c);
            assertNotEquals(a.hashCode(), c.hashCode());
            assertEquals(ComplexTest._buildCartString(a.getReal(), a.getImag()), a.toString());
        }

        assertNotEquals(a, b);
        if (b != null) {
            assertNotEquals(a.hashCode(), b.hashCode());
        }
        assertNotEquals(b, c);
        if (b != null) {
            assertNotEquals(b.hashCode(), c.hashCode());
            assertEquals(ComplexTest._buildCartString(b.getReal(), b.getImag()), b.toString());
        }
        assertEquals(ComplexTest._buildCartString(cReal, cImag), c.toString());
    }

    // Add two Immutables. Make sure its a new object.
    @Test
    void addImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), false);

        Complex c = a.plus(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aReal + this._bReal,
                this._aImag + this._bImag,
                false
        );
    }

    // Add two Mutables. Make sure its a new object.
    @Test
    void addMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), true);

        Complex c = a.plus(b);

        double newReal = this._aReal + this._bReal;
        double newImag = this._aImag + this._bImag;
        ComplexTest._checkChanges(
                a,
                b,
                c,
                newReal,
                newImag,
                this._bReal,
                this._bImag,
                newReal,
                newImag,
                true
        );
    }

    // Sub two Immutables. Make sure its a new object.
    @Test
    void subImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), false);

        Complex c = a.minus(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aReal - this._bReal,
                this._aImag - this._bImag,
                false
        );
    }

    // Sub two Mutables. Make sure its a new object.
    @Test
    void subMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), true);

        Complex c = a.minus(b);

        double newReal = this._aReal - this._bReal;
        double newImag = this._aImag - this._bImag;
        ComplexTest._checkChanges(
                a,
                b,
                c,
                newReal,
                newImag,
                this._bReal,
                this._bImag,
                newReal,
                newImag,
                true
        );
    }

    // Div two Immutables. Make sure its a new object.
    @Test
    void divImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), false);

        Complex c = a.divides(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aRealDivBReal,
                this._aImagDivBImag,
                false
        );
    }

    // Div two Mutables. Make sure its a new object.
    @Test
    void divMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), true);

        Complex c = a.divides(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aRealDivBReal,
                this._aImagDivBImag,
                this._bReal,
                this._bImag,
                this._aRealDivBReal,
                this._aImagDivBImag,
                true
        );
    }

    // Multiply two Immutables. Make sure its a new object.
    @Test
    void multImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), false);

        Complex c = a.multiply(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aRealMultiplyBReal,
                this._aImagMultiplyBImag,
                false
        );
    }

    // Multiply two Mutables. Make sure its a new object.
    @Test
    void multMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);
        Complex b = new Complex(new Cartesian(this._bReal, this._bImag), true);

        Complex c = a.multiply(b);

        ComplexTest._checkChanges(
                a,
                b,
                c,
                this._aRealMultiplyBReal,
                this._aImagMultiplyBImag,
                this._bReal,
                this._bImag,
                this._aRealMultiplyBReal,
                this._aImagMultiplyBImag,
                true
        );
    }

    // scale two Immutables. Make sure its a new object.
    @Test
    void scaleImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);
        double scale = 2.0;

        Complex c = a.scale(scale);

        ComplexTest._checkChanges(
                a,
                null,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aReal * scale,
                this._aImag * scale,
                false
        );
    }

    // scale two Mutables. Make sure its a new object.
    @Test
    void scaleMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);
        double scale = 2.0;

        Complex c = a.scale(scale);

        ComplexTest._checkChanges(
                a,
                null,
                c,
                this._aReal * scale,
                this._aImag * scale,
                this._bReal,
                this._bImag,
                this._aReal * scale,
                this._aImag * scale,
                true
        );
    }

    // conjugate two Immutables. Make sure its a new object.
    @Test
    void conjugateImmutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), false);

        Complex c = a.conjugate();

        ComplexTest._checkChanges(
                a,
                null,
                c,
                this._aReal,
                this._aImag,
                this._bReal,
                this._bImag,
                this._aReal,
                -this._aImag,
                false
        );
    }

    // conjugate two Mutables. Make sure its a new object.
    @Test
    void conjugateMutable() {
        Complex a = new Complex(new Cartesian(this._aReal, this._aImag), true);

        Complex c = a.conjugate();

        ComplexTest._checkChanges(
                a,
                null,
                c,
                this._aReal,
                -this._aImag,
                this._bReal,
                this._bImag,
                this._aReal,
                -this._aImag,
                true
        );
    }

    @Test
    void convertCartToPolar() {
        double expectedAbs = 5.0;
        double expectedAlpha = 53.13010235415598;
        double expectedRadiant = 0.9272952180016122;
        double expectedImag = 4;
        double expectedReal = 3;

        Cartesian cart = new Cartesian(expectedReal, expectedImag);
        Polar polar = cart.getPolar();
        assertEquals(expectedAbs, polar.getAbs(), 0);
        assertEquals(expectedAlpha, polar.getAlpha(), 0);

        assertEquals(expectedImag, cart.getImag(), 0);
        assertEquals(expectedReal, cart.getReal(), 0);

        Complex a = new Complex(cart);
        assertEquals(expectedAbs, a.getAbsolute(), 0);
        assertEquals(expectedRadiant, MathUtils.angleRadiant(a), 0);
        assertEquals(expectedAlpha, MathUtils.angleDegree(a), 0);
    }

    @Test
    void convertPolarToCart() {
        double expectedAbs = 5.656854249492381;
        double expectedAlpha = 53.13010235415598;
        double expectedRadiant = 0.9272952180016122;
        double expectedImag = 4;
        double expectedReal = 3;

        Polar polar = new Polar(expectedAlpha, expectedAbs);
        Cartesian cart = polar.getCartesian();
        assertEquals(expectedAbs, polar.getAbs(), 0);
        assertEquals(expectedAlpha, polar.getAlpha(), 0);

        assertEquals(expectedImag, cart.getImag(), 0.6);
        assertEquals(expectedReal, cart.getReal(), 0.4);

        Complex a = new Complex(polar);
        assertEquals(expectedAbs, a.getAbsolute(), 0.8);
        assertEquals(expectedRadiant, MathUtils.angleRadiant(a), 0.1);
        assertEquals(expectedAlpha, MathUtils.angleDegree(a), 0.1);
    }

    @Test
    void toStringPolar() {
        double expectedAlpha = 45.0;
        double expectedAbs = 10.0;
        Polar polar = new Polar(expectedAlpha, expectedAbs);
        Complex complex = new Complex(polar);
        assertEquals("absolute: " + expectedAbs + "; angle: " + expectedAlpha, complex.toString());
    }
}
