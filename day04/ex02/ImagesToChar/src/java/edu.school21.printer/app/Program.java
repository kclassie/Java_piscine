package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.api.Ansi;

@Parameters(separators = "=")
public class Program {

    @Parameter(names="--white")
    String firstColor;
    @Parameter(names="--black")
    String secondColor;
    private static final String IMAGE_FILE_PATH = "/resources/it.bmp";

    public static void main(String[] args) throws NotValidArgumentException {

        Program program = new Program();

        try {
            JCommander.newBuilder().addObject(program).build().parse(args);
            program.run();
        } catch (ParameterException ex) {
            throw new NotValidArgumentException();
        }
    }

    public void run() {

        Logic logic = new Logic();

        if (firstColor == null || secondColor == null) {

            throw new NotValidArgumentException();
        }

        Ansi.BColor color1 = Ansi.BColor.valueOf(firstColor);
        Ansi.BColor color2 = Ansi.BColor.valueOf(secondColor);
        logic.outputImage(color1, color2, Program.class.getResource(IMAGE_FILE_PATH));
    }
}
