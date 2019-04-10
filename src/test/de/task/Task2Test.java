package de.task;

import de.complex.Complex;
import de.file.Manager;
import de.file.Parser;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Roman Schmidt, Stanislav Brug
 * <p>
 * Just the test if its been sorted before it was written to file, like requested
 */
class Task2Test {
    @Test
    void orderMandel() throws IOException {
        new Task2();

        BufferedReader fileHandler = Manager.getReadHandler(Manager.getMandlePath());
        this._checkOrder(fileHandler);
    }

    @Test
    void orderJulia() throws IOException {
        new Task2();

        BufferedReader fileHandler = Manager.getReadHandler(Manager.getJuliaPath());
        this._checkOrder(fileHandler);
    }

    private void _checkOrder(@NotNull BufferedReader fileHandler) throws IOException {
        String line = fileHandler.readLine();
        Complex prevC = null;
        while (line != null) {
            Complex currentC = Parser.parseRowToComplex(line);
            if (prevC != null) {
                assertTrue(prevC.getAbsolute() <= currentC.getAbsolute());
            }
            prevC = currentC;
            line = fileHandler.readLine();
        }
        fileHandler.close();
    }
}