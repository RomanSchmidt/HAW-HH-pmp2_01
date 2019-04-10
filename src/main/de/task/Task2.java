package de.task;

import de.complex.Cartesian;
import de.complex.Complex;
import de.file.Manager;
import de.mandelbrot.Julia;
import de.mandelbrot.Mandel;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Roman Schmidt, Stanislav Brug
 * <p>
 * The class for the wole logic of Task2
 * generate some complex, write them to file, read again, generate both litss and save ordered to files
 */
public class Task2 {

    private ArrayList<Complex> _complexList = new ArrayList<>();
    private ArrayList<Complex> _mandelList = new ArrayList<>();
    private ArrayList<Complex> _juliaList = new ArrayList<>();

    private final Comparator<Complex> _compareByAbs = new Comparator<Complex>() {
        public int compare(@NotNull Complex o1, @NotNull Complex o2) {
            return Double.compare(o1.getAbsolute(), o2.getAbsolute());
        }
    };

    Task2() throws IOException {
        this._generateComplex();
        this._writeComplexToFile();
        this._complexList = Manager.getComplexListFromFile();
        this._generateMandelList();
        this._writeMandelList();
        this._generateJuliaList();
        this._writeJuliaList();
    }

    public static void main(String[] args) throws IOException {
        new Task2();
    }

    private void _writeMandelList() throws IOException {
        this._mandelList.sort(this._compareByAbs);
        Manager.writeMandelToFile(this._mandelList);
    }

    private void _writeJuliaList() throws IOException {
        this._juliaList.sort(this._compareByAbs);
        Manager.writeJuliaToFile(this._juliaList);
    }

    private void _writeComplexToFile() throws IOException {
        this._complexList.sort(this._compareByAbs);
        Manager.writeComplexListToFile(this._complexList);
    }

    private void _generateComplex() {
        double x = 0.0;
        double y = -2.0;
        double step = 0.004;
        int i = 0;

        for (; i < 1000; ++i) {
            this._complexList.add(new Complex(new Cartesian(x += step, y += step)));
        }
    }

    private void _generateMandelList() {
        int i = 0;
        for (; i < this._complexList.size(); ++i) {
            Complex complex = this._complexList.get(i);
            if (Mandel.isInSet(complex)) {
                this._mandelList.add(complex);
            }
        }
    }

    private void _generateJuliaList() {
        int i = 0;
        for (; i < this._complexList.size(); ++i) {
            Complex complex = this._complexList.get(i);
            if (Julia.isInSet(complex)) {
                this._juliaList.add(complex);
            }
        }
    }
}
