package program;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ObslugaPlikow {

    public static void zapiszDoPliku() {
        try (FileWriter fw = new FileWriter("fiszki_z_bazy.txt")) {
            for (ParaSlow ps : OknoFiszki.paraSlow) {
                fw.write(ps.getSlowoPolskie() + ";" + ps.getSlowoAngielskie() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void wczytajFiszki(File plik) {

        try {
            if (plik.length() == 0) {
                OknoFiszki.paraSlow.add(new ParaSlow("kolor", "colour"));
            } else {
                for (String line : Files.readAllLines(plik.toPath())) {
                    OknoFiszki.paraSlow.add(new ParaSlow(
                            line.split(";")[0],
                            line.split(";")[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File wybierzPlik() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Pliki tekstowe", "txt"));
        fileChooser.showOpenDialog(null);

        return fileChooser.getSelectedFile();
    }
}
