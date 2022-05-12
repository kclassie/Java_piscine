package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    private static char whiteColor;
    private static char blackColor;
    private static String path;

    public static void main(String[] args) throws NotValidArgumentException {

        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {

            throw new NotValidArgumentException();
        }

        whiteColor = args[0].charAt(0);
        blackColor = args[1].charAt(0);
        path = args[2];
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logic.outputImage(img, whiteColor, blackColor);
    }
}
