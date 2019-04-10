package de.file;

import de.complex.Complex;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Roman Schmidt, Stanislaw Brug
 * <p>
 * Central Utility Class to handle all file handlings
 */
abstract public class Manager {
    private static String _inFile = System.getProperty("user.dir") + "/src/resource/inFile.txt";
    private static String _juliaFile = System.getProperty("user.dir") + "/src/resource/juliaFile.txt";
    private static String _mandelFile = System.getProperty("user.dir") + "/src/resource/mandelFile.txt";

    @Contract(pure = true)
    public static String getMandlePath() {
        return Manager._mandelFile;
    }

    @Contract(pure = true)
    public static String getJuliaPath() {
        return Manager._juliaFile;
    }

    @NotNull
    @Contract("_ -> new")
    public static BufferedReader getReadHandler(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    @NotNull
    @Contract("_ -> new")
    private static BufferedWriter getWriteHandler(String filePath) throws IOException {
        return new BufferedWriter(new FileWriter(filePath));
    }

    public static ArrayList<Complex> getComplexListFromFile() throws NullPointerException, IOException {
        final ArrayList<Complex> complexList = new ArrayList<>();
        BufferedReader fileHandler = Manager.getReadHandler(Manager._inFile);
        String line = fileHandler.readLine();
        while (line != null) {
            complexList.add(Parser.parseRowToComplex(line));
            line = fileHandler.readLine();
        }
        fileHandler.close();
        return complexList;
    }

    public static void writeComplexListToFile(@NotNull ArrayList<Complex> list) throws IOException {
        Manager._writeListToFile(Manager._inFile, list);
    }

    public static void writeMandelToFile(ArrayList<Complex> list) throws IOException {
        Manager._writeListToFile(Manager._mandelFile, list);
    }

    public static void writeJuliaToFile(ArrayList<Complex> list) throws IOException {
        Manager._writeListToFile(Manager._juliaFile, list);
    }

    private static void _writeListToFile(String path, @NotNull ArrayList<Complex> list) throws IOException {
        BufferedWriter fileHandler = Manager.getWriteHandler(path);

        for (int i = 0; i < list.size(); i++) {
            fileHandler.write(list.get(i).toString());
            fileHandler.newLine();
        }
        fileHandler.close();
    }
}
