package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Program {
    private static char whiteColor;
    private static char blackColor;
    private static URL path;
    private static final String IMAGE_FILE_PATH = "/resources/it.bmp";

    public static void main(String[] args) throws NotValidArgumentException {

        if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {

            throw new NotValidArgumentException();
        }

        whiteColor = args[0].charAt(0);
        blackColor = args[1].charAt(0);
        path = Program.class.getResource(IMAGE_FILE_PATH);
        BufferedImage img = null;

        try {
            img = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logic.outputImage(img, whiteColor, blackColor);
    }
}
